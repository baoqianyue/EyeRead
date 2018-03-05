package com.barackbao.eyeread.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;

/**
 * Created by 22876 on 2018/2/24.
 */

public class TestView extends View{

    VelocityTracker velocityTracker;

    public TestView(Context context) {
        super(context);
        velocityTracker = VelocityTracker.obtain();
        velocityTracker.computeCurrentVelocity(1000);
        int xVelocity = (int) velocityTracker.getXVelocity();
        int yVelocity = (int) velocityTracker.getYVelocity();
        //获取TouchSlop
        ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }


}
