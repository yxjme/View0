package com.zhaotuomobile.jbh.view0;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by zbsdata on 2017/9/20.
 */

public class TouchView extends View {


    public TouchView(Context context) {
        this(context , null);
    }

    public TouchView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs , 0);
    }

    public TouchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action=event.getActionMasked();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                float x=event.getX();
                float y=event.getY();
                Log.v("========","x:"+x);
                Log.v("========","y:"+y);


                float rawX=event.getRawX();
                float rawY=event.getRawY();
                Log.v("========","rawX:"+rawX);
                Log.v("========","rawY:"+rawY);
                break;
        }
        return true;
    }


    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawColor(Color.YELLOW);
    }
}
