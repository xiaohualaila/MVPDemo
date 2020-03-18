package com.example.mvpdemo.mvp;

import com.example.mvpdemo.bean.Account;
import com.example.mvpdemo.callback.MCallback;

public class MVPPresenter {
    private IMVPView mView;
    private MVPModel mModel;

    public MVPPresenter(IMVPView imvpView){
        this.mView = imvpView;
        mModel = new MVPModel();
    }

    public void getData(String account) {
        mModel.getAccountData(account, new MCallback() {
            @Override
            public void onSuccess(Account account) {
                mView.showSuccessPage(account);
            }

            @Override
            public void onFailed() {
                mView.showFailPage();
            }
        });
    }
}
