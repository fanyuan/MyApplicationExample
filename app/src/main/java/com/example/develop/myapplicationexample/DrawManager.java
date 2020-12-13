package com.example.develop.myapplicationexample;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by develop on 2020/11/7.
 */

public class DrawManager {
    private static List<Draw> draws = new ArrayList<>();
    public static void add(Draw draw){
        draws.add(draw);
    }
    public static Bitmap draw(Bitmap bitmap){
        return  draws.get(0).draw(bitmap);
    }
}
