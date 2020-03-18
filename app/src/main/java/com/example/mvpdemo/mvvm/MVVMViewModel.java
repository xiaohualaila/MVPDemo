package com.example.mvpdemo.mvvm;

import android.app.Application;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.mvpdemo.BR;
import com.example.mvpdemo.bean.Account;
import com.example.mvpdemo.callback.MCallback;
import com.example.mvpdemo.databinding.ActivityMvvmBinding;

public class MVVMViewModel extends BaseObservable {

    private MVVMModel mvvmModel;
    private ActivityMvvmBinding binding;
    private String result;
    private String userInput;

    //一般需要传入 Application 对象，方便再 ViewModel 中使用 application
    //比如 sharedpreferces 需要使用
    public MVVMViewModel(Application application) {
        mvvmModel = new MVVMModel();
    }

    public MVVMViewModel(Application application, ActivityMvvmBinding binding) {
        mvvmModel = new MVVMModel();
        this.binding = binding;
    }

    public void getData(View view) {
    //    String account = binding.etAccount.getText().toString();
        mvvmModel.getAccountData(userInput, new MCallback() {
            @Override
            public void onSuccess(Account account) {
                String info = account.getName() + "|" + account.getLevel();
                setResult(info);
            }

            @Override
            public void onFailed() {
                setResult("获取数据失败");
            }
        });
    }

    @Bindable
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
        notifyPropertyChanged(BR.result);
    }

    @Bindable
    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
        notifyPropertyChanged(BR.userInput);
    }
}
