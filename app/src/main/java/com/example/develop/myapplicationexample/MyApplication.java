package com.example.develop.myapplicationexample;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by develop on 2020/11/12.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        log("MyApplication --- onCreate");
        Log.d("ddebug","getCurrentProcessName --- " + getCurrentProcessName(this));
        Log.d("ddebug","getPackageName() --- " + getPackageName());
        Log.d("ddebug","getPackageName() --- " + getDir("test",Context.MODE_PRIVATE)+" +++ " + getCacheDir());
    }
    private String getCurrentProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager mActivityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : mActivityManager
                .getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }

    public static void toast(Context context,String message) {
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
    public static void log(String message) {
        Log.d("ddebug",message);
    }
}
