package com.example.develop.myapplicationexample;

import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/app/activity/frag")
public class FragmentActivity extends AppCompatActivity {
    FrameLayout frameLayout;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        frameLayout = findViewById(R.id.frameLayout);
        imageView = findViewById(R.id.frameLayout02);
    }
    public void add(View v){
        toast("add");
        FragmentTransaction transac = getSupportFragmentManager().beginTransaction();
        transac.add(R.id.frameLayout,new MyFragment());
        transac.commit();

    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void draw(View v){
        Bitmap bitmap = Bitmap.createBitmap(imageView.getWidth(), imageView.getHeight(),Bitmap.Config.RGB_565);
//        Canvas canvas = new Canvas(bitmap);
//        frameLayout.draw(canvas);
        Bitmap src = DrawManager.draw(bitmap);
        imageView.setImageBitmap(src);
    }
    private void toast(String str) {
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }

}
