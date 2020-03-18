package com.example.mvpdemo.mvp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mvpdemo.R;
import com.example.mvpdemo.bean.Account;

/**
 *
 * MVC 与 MVP 的差别
 * 1，Model 与 View 不再直接进行通信，而是通过中间层 Presenter 来实现
 * 2，Activity 的功能被简化，不再充当控制器，主要负责 View 层面的工作
 *
 *
 * MVP 优缺点
 * 优点：解决了 MVC 中 Controller 与 View 过度耦合的缺点，职责划分明显，更加易于维护。
 * 缺点：
 *    接口数量多，项目复杂度升高。随着项目的复杂度的提升，Presenter 层将越来越臃肿。
 *
 *    使用 MVP 的建议
 *    1，接口规范化（封装父类的接口以减少接口的使用量）
 *    2，使用第三方插件自动生成 MVP 代码
 *    3，对于一些简单的界面，可以选择不使用框架
 *    4，根据项目复杂程度，部分模块可以选择不使用接口
 */


public class MVPActivity extends AppCompatActivity implements
        View.OnClickListener,IMVPView{
    private TextView mTvResult;
    private EditText mEtAccount;
    private MVPPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        initView();
        presenter = new MVPPresenter(this);
    }

    private void initView() {
        mTvResult = findViewById(R.id.tv_Result);
        mEtAccount = findViewById(R.id.et_account);
        findViewById(R.id.btn_getAccount).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        presenter.getData(getUserInput());
    }

    @Override
    public String getUserInput() {
       return mEtAccount.getText().toString();
    }

    @Override
    public void showSuccessPage(Account account) {
        mTvResult.setText("用户账号："+account.getName()+"|"+"用户等级："+account.getLevel());
    }

    @Override
    public void showFailPage() {
        mTvResult.setText("获取数据失败！");
    }
}
