package com.zhaotuomobile.jbh.view0;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zbsdata on 2017/7/4.
 */

public class DrawView0 extends View{

    /**
     * 画笔
     * @param context
     */
    private Paint mPaint;

    /**
     * radius
     * @param context
     */
    private int radius=20;


    public DrawView0(Context context) {
        this(context,null);
    }


    public DrawView0(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DrawView0(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a=context.obtainStyledAttributes(attrs,R.styleable.DrawView0,0,defStyleAttr);

        initPaint();
    }

    /**
     * 初始化画笔
     */
    private void initPaint() {
        mPaint=new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLUE);
//        Paint.Style.FILL    :填充内部
//        Paint.Style.FILL_AND_STROKE  ：填充内部和描边
//        Paint.Style.STROKE  ：仅描边
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeWidth(5);
        mPaint.setShadowLayer(10, 15, 15, Color.GREEN);//设置阴影
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//
//
//        Paint paint=new Paint();
//        paint.setColor(Color.RED);  //设置画笔颜色
//        paint.setStyle(Paint.Style.FILL);//设置填充样式
//        paint.setStrokeWidth(5);//设置画笔宽度
//        float[] pts={10,10,100,100,200,200,400,400 ,500,500,300,300};
//        canvas.drawLines(pts, paint);


        Paint paint1=new Paint();
        paint1.setAntiAlias(true);
        paint1.setColor(Color.RED);  //设置画笔颜色
        paint1.setStyle(Paint.Style.STROKE);//设置填充样式
        paint1.setStrokeWidth(5);
        Path p=new Path();
        p.moveTo(100,0);
        p.lineTo(150,50);
        p.lineTo(100,100);
        p.lineTo(300,200);
        p.lineTo(0,600);
        p.lineTo(500,800);
        canvas.drawPath(p,paint1);

        Paint paint2=new Paint();
        paint2.setAntiAlias(true);
        paint2.setTextSize(30);
        paint2.setColor(Color.WHITE);  //设置画笔颜色
        paint2.setStyle(Paint.Style.STROKE);//设置填充样式
        paint2.setStrokeWidth(3);

        canvas.drawCircle(100,0,radius,mPaint);
        canvas.drawText("1",100,0,paint2);
        canvas.drawCircle(150,50,radius,mPaint);
        canvas.drawText("2",150,50,paint2);
        canvas.drawCircle(100,100,radius,mPaint);
        canvas.drawText("3",100,100,paint2);
        canvas.drawCircle(300,200,radius,mPaint);
        canvas.drawText("4",300,200,paint2);
        canvas.drawCircle(0,600,radius,mPaint);
        canvas.drawText("5",0,600,paint2);
        canvas.drawCircle(500,800,radius,mPaint);
        canvas.drawText("6",500,800,paint2);

//        Paint paint3=new Paint();
//        paint3.setAntiAlias(true);
//        paint3.setColor(Color.YELLOW);
//        paint3.setStyle(Paint.Style.FILL_AND_STROKE);
//        RectF rect=new RectF(0,100,300,500);
//        canvas.drawRect(rect,paint3);
    }
}
