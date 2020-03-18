package com.example.mvpdemo.mvc;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mvpdemo.R;
import com.example.mvpdemo.bean.Account;
import com.example.mvpdemo.callback.MCallback;

/**
 * MVC优缺点  优点：一定程度实现了Model与View的分离，降低了代码的耦合性。
 *            缺点Controller 与View 难以完全解耦，并且随着项目的复杂度的提升，Contrller将越来越臃肿。
 *            Controller: Activity,Fragment
 *            View: layout,View控件
 *            Model: 数据处理（网络请求，SQL等）
 */

public class MVCActivity  extends AppCompatActivity implements View.OnClickListener{

    private TextView mTvResult;
    private EditText mEtAccount;
    private MVCModel mvcModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        initView();
        mvcModel = new MVCModel();
    }

    private void initView() {
        mTvResult = findViewById(R.id.tv_Result);
        mEtAccount = findViewById(R.id.et_account);
        findViewById(R.id.btn_getAccount).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mvcModel.getAccountData(getUserInput(), new MCallback() {
            @Override
            public void onSuccess(Account account) {
                showSuccessPage(account);
            }

            @Override
            public void onFailed() {
                showFailPage();
            }
        });
    }

    private String getUserInput(){
        return mEtAccount.getText().toString();
    }

    private void showSuccessPage(Account account){
        mTvResult.setText("用户账号："+account.getName()+"|"+"用户等级："+account.getLevel());
    }

    private void showFailPage(){
        mTvResult.setText("获取数据失败！");
    }
}
