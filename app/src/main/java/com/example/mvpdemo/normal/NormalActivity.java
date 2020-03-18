package com.example.mvpdemo.normal;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mvpdemo.R;
import com.example.mvpdemo.bean.Account;
import com.example.mvpdemo.callback.MCallback;

import java.util.Random;

public class NormalActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView mTvResult;
    private EditText mEtAccount;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        initView();
    }

    private void initView() {
        mTvResult = findViewById(R.id.tv_Result);
        mEtAccount = findViewById(R.id.et_account);
        findViewById(R.id.btn_getAccount).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
           String userInput = getUserInput();
           getAccountData(userInput, new MCallback() {
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

    private void getAccountData(String accountName, MCallback callback){
        Random random = new Random();
        boolean isSuccess = random.nextBoolean();
        if(isSuccess){
            Account account = new Account();
            account.setName(accountName);
            account.setLevel(100);
            callback.onSuccess(account);
        }else {
            callback.onFailed();
        }
    }
}
