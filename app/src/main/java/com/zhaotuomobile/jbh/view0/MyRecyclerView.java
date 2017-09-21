package com.zhaotuomobile.jbh.view0;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by zbsdata on 2017/9/20.
 */

public class MyRecyclerView extends RecyclerView {

    /**记录所有的孩子控件*/
    private int count;
    /**第一个孩子的高度 用于计算手指滑动到那个孩子那里了*/
    private int childHeight;


    public MyRecyclerView(Context context) {
        this(context , null);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs , 0);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        LinearLayoutManager manager = (LinearLayoutManager) this.getLayoutManager();
        count=getChildCount();
        if(count>0){
            View view=manager.getChildAt(0);
            childHeight=view.getMeasuredHeight();
            Log.d("======","count:"+count);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action=event.getActionMasked();
        float x=event.getX();
        float y=event.getY();
        int position= (int) (y/childHeight);
        if(position<count&&position >= 0){
            Boolean state = false;
            switch (action){
                case MotionEvent.ACTION_DOWN:
                case MotionEvent.ACTION_MOVE:
                    state=true;
                    break;
                case MotionEvent.ACTION_CANCEL:
                case MotionEvent.ACTION_UP:
                    state=false;
                    break;
            }
            touchOffset.offset(position,y,state);
        }
        return true;
    }

    private TouchOffset touchOffset;


    public interface TouchOffset{
        void offset(int position , float offset ,Boolean state);
    }
    
    public void setTouchOffset(TouchOffset touchOffset) {
        this.touchOffset = touchOffset;
    }
}
