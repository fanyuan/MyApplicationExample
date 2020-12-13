package com.example.develop.myapplicationexample;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.Choreographer;

/**
 * Created by develop on 2020/11/8.
 */

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class BlockDetectChoregrapher implements Choreographer.FrameCallback {
    public static BlockDetectChoregrapher sInstance;
    private String tag = "ddebug";
    public static final  float deviceRefreshRateMs = 16.6f;
    public static long lastFrameTimeNanos = 0;//纳秒为单位
    public static long currentFrameTimeNanos = 0;

    public void start(){
        Choreographer.getInstance().postFrameCallback(BlockDetectChoregrapher.getInstance());
    }

    public static BlockDetectChoregrapher getInstance() {
        if(sInstance == null){
            sInstance = new BlockDetectChoregrapher();
        }
        return  sInstance;
    }

    @Override
    public void doFrame(long frameTimeNanos) {
        if(lastFrameTimeNanos == 0){
            lastFrameTimeNanos = frameTimeNanos;
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        currentFrameTimeNanos = frameTimeNanos;
        float value = (currentFrameTimeNanos - lastFrameTimeNanos)/1000000.0f;
        int skipFrameCount = skipFrameCount(lastFrameTimeNanos,currentFrameTimeNanos,deviceRefreshRateMs);
        if(skipFrameCount > 1){
            Log.d(tag,"两次绘制时间间隔value = " + value + " frameTimeNanos = " + frameTimeNanos
            + "   currentFrameTimeNanos = " + currentFrameTimeNanos+ "   skipFrameCount = " + skipFrameCount);
        }
        lastFrameTimeNanos = currentFrameTimeNanos;
        Choreographer.getInstance().postFrameCallback(this);
    }

    private int skipFrameCount(long start, long end, float deviceRefreshRate) {
        int count = 0 ;
        long diffNs = end - start;
        long diffMs = Math.round(diffNs / 1000000.0f);
        long dev = Math.round(deviceRefreshRate);
        if(diffMs > dev){
            long skipCount = diffMs / dev;
            count = (int) skipCount;
        }
        return  count;
    }
}
