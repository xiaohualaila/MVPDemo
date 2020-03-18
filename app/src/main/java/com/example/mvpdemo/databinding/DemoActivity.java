package com.example.mvpdemo.databinding;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.mvpdemo.R;
import com.example.mvpdemo.bean.Account;

public class DemoActivity extends AppCompatActivity {
    private ActivityDemoBinding binding;
    private Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_demo);
        account = new Account();
        account.setName("TEST");
        account.setLevel(100);
        binding.setAccount(account);
        binding.setActivity(this);
    }

    public void onClick(View view) {
        int le = account.getLevel();
        account.setLevel(le + 1);
       // binding.setAccount(account);
    }

}
