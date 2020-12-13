package com.example.develop.myapplicationexample;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Build;
import android.os.Looper;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Printer;
import android.view.View;
import android.widget.LinearLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.common.Tools;

@Route(path = "/app/activity/main")
public class MainActivity extends AppCompatActivity  implements Draw{
    LinearLayout layout;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.layout);
        DrawManager.add(this);
        //BlockDetectChoregrapher.getInstance().start();
        initPermission();
        Tools.log("app MainActivity");
    }
    private void initPermission() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }

    }

    private void leakCheck(){
        Looper.getMainLooper().setMessageLogging(new Printer() {
            String start = ">>>>>";
            String end = "<<<<<";
            long startDution;
            @Override
            public void println(String x) {
                if(x.startsWith(start)){
                    startDution = System.currentTimeMillis();
                }else if(x.startsWith(end)){
                    long duration = System.currentTimeMillis() - startDution;
                    Log.d("ddebug","duration = "+ duration );
                }
                Log.d("ddebug","loop println System.currentTimeMillis() = "+ System.currentTimeMillis() + " x = " + x );
            }
        });
    }
    public void fragment(View v){
        startActivity(new Intent(MainActivity.this,FragmentActivity.class));
    }
    public void skip(View v){
        startActivity(new Intent(MainActivity.this,SkipActivity.class));
    }
    @Override
    public Bitmap draw(Bitmap bitmap) {
        Bitmap src = Bitmap.createBitmap(layout.getWidth(),layout.getHeight(),Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(src);
        ((View)layout.getParent().getParent()).draw(canvas);
        float scaleWidth = ((float)bitmap.getWidth())/src.getWidth();
        float scalegetHeight = ((float)bitmap.getHeight())/src.getHeight();
        Matrix m = new Matrix();
        m.postScale(scaleWidth,scalegetHeight);
        Bitmap tmp = Bitmap.createBitmap(src,0,0,src.getWidth(),src.getHeight(),m,true);

        return tmp;
    }
}
