package com.example.pendulum;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.view.View;

import androidx.annotation.NonNull;

public class PendulumDraw extends View {
    public static final Integer BALLS_COUNT = 15;
    int[] l = new int[BALLS_COUNT];
    double x0, y0;
    double[] x = new double[BALLS_COUNT];
    double[] y = new double[BALLS_COUNT];
    double g = 9.823f, pi = Math.PI;
    double[] w = new double[BALLS_COUNT];
    double fi0;
    double[] fi = new double[BALLS_COUNT];
    int t = 0, deltaT = 1;


    public PendulumDraw(Context context) {
        super(context);
        makePendulum();
        MyTimer timer = new MyTimer();
        timer.start();
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        x0 = getWidth() / 2;
        y0 = getHeight() / 2;
        Paint paint = new Paint();
        canvas.drawCircle((float) x0, (float) y0, 10, paint);
        for (int i = 0; i < BALLS_COUNT; i++) {
            paint.setColor(Color.BLUE);
            canvas.drawLine((float) x0, (float) y0, (float) (x[i] + x0), (float) (y[i] + y0), paint);
            paint.setColor(Color.RED);
            canvas.drawCircle((float) (x[i] + x0), (float) (y[i] + y0), 20, paint);
        }
    }

    void makePendulum() {
        fi0 = pi / 4;
        int l_min = 100;
        for (int i = 0; i < BALLS_COUNT; i++) {
            l[i] = l_min;
            l_min += 50;
            w[i] = Math.sqrt(g / l[i]);
        }
    }

    void movePendulum() {
        t += deltaT;
        for (int i = 0; i < BALLS_COUNT; i++) {
            fi[i] = fi0 * Math.cos(w[i] * t);
            x[i] = l[i] * Math.sin(fi[i]);
            y[i] = l[i] * Math.cos(fi[i]);
        }
    }

    void nextFrame(){
        movePendulum();
        invalidate();
    }

    class MyTimer extends CountDownTimer{

        public MyTimer() {
            super(100000, 100);
        }

        @Override
        public void onTick(long l) {
            nextFrame();
        }

        @Override
        public void onFinish() {

        }
    }
}
