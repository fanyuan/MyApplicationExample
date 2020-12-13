package com.example.develop.myapplicationexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;

import java.security.PublicKey;

public class SkipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip);
    }
    public void demo(View v){
        String path = "/demo/main";
        ARouter.getInstance().build(path).navigation(this);
    }
    public void demo2(View v){
        String path = "/demo2/main";
        ARouter.getInstance().build(path).navigation(this);
    }
}
