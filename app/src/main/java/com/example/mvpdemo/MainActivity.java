package com.example.mvpdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mvpdemo.databinding.DemoActivity;
import com.example.mvpdemo.mvc.MVCActivity;
import com.example.mvpdemo.mvp.MVPActivity;
import com.example.mvpdemo.mvvm.MVVMActivity;
import com.example.mvpdemo.normal.NormalActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MVVMActivity.class);
                startActivity(intent);
            }
        });
    }
}
