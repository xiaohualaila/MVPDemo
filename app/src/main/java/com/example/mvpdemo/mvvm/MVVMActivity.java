package com.example.mvpdemo.mvvm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.mvpdemo.R;
import com.example.mvpdemo.databinding.ActivityDemoBinding;
import com.example.mvpdemo.databinding.ActivityMvvmBinding;

public class MVVMActivity extends AppCompatActivity {
    private ActivityMvvmBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        MVVMViewModel mvvmModel = new MVVMViewModel(getApplication(),binding);
        binding.setViewModel(mvvmModel);

    }
}
