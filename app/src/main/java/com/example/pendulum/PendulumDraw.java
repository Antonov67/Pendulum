package com.example.pendulum;

import android.content.Context;
import android.view.View;

public class PendulumDraw extends View {
    public static final Integer BALLS_COUNT = 15;
    int[] l = new int[BALLS_COUNT];
    double x0, y0;
    double[] x = new double[BALLS_COUNT];
    double[] y = new double[BALLS_COUNT];
    double g = 9.823f, pi = Math.PI;
    double fi0;
    double[] fi = new double[BALLS_COUNT];
    int t = 0, deltaT = 1;


    public PendulumDraw(Context context) {
        super(context);
    }
}
