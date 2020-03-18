package com.example.mvpdemo.mvp;

import com.example.mvpdemo.bean.Account;

public interface IMVPView {
    String getUserInput();
    void showSuccessPage(Account account);
    void showFailPage();
}
