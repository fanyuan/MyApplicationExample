package com.example.appdemo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.common.Tools;

@Route(path = "/demo/main")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_activity_main);
        Tools.log("demo MainActivity");
    }
    //        MyTools.testLib();
    //        MyTools.libLog("一个测试string");
    //        MyTools.libToast(this,"测试");
    //        MyTools.toOneActivity(this);
    public void demo2(View view){
        String path = "/demo2/main";
        ARouter.getInstance().build(path).navigation();
    }
    public void ext(View view){
        String path = "/ext/main";
        ARouter.getInstance().build(path).navigation();
    }
}
