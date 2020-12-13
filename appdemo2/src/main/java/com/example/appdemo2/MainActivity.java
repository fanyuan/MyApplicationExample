package com.example.appdemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.common.Tools;
@Route(path = "/demo2/main")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo2_activity_main);
        Tools.log("demo2 MainActivity");

    }
    public void test(View v){
        String path = "/demo/main";
        ARouter.getInstance().build(path).navigation();
    }
}
