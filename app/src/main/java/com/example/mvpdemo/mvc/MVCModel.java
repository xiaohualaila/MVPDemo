package com.example.mvpdemo.mvc;

import com.example.mvpdemo.bean.Account;
import com.example.mvpdemo.callback.MCallback;

import java.util.Random;

public class MVCModel {
    public void getAccountData(String accountName, MCallback callback){
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
