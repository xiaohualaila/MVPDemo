package com.example.mvpdemo.bean;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.mvpdemo.BR;

public class Account extends BaseObservable {
    private String name;//账号名称
    private int level;//账号等级

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
        notifyPropertyChanged(BR.level);
    }
}
