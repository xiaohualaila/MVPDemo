package com.example.mvpdemo.callback;


import com.example.mvpdemo.bean.Account;

public interface MCallback {
    void onSuccess(Account account);
    void onFailed();
}
