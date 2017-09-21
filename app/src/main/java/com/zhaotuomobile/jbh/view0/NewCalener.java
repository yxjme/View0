package com.zhaotuomobile.jbh.view0;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zbsdata on 2017/5/27.
 */

@RequiresApi(api = Build.VERSION_CODES.N)
public class NewCalener extends LinearLayout {

    private TextView textData;
    private ImageView btnPrew;
    private ImageView btnNext;
    private GridView grid;

    private Calendar mCalendar=Calendar.getInstance();

    public NewCalener(Context context) {
        super(context);
    }

    public NewCalener(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initControl(context);
    }

    public NewCalener(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initControl(context);
    }

    public void initControl(Context context)
    {
        bindControl(context);
        BindControlEventvent();
        renderCalendar();
    }



    private void bindControl(Context context)
    {
        LayoutInflater inflater= LayoutInflater.from(context);
        View v =inflater.inflate(R.layout.newcalener_view,null);
        btnNext=(ImageView)v.findViewById(R.id.btnNext);
        btnPrew=(ImageView)v.findViewById(R.id.btnPrev);
        textData=(TextView)v.findViewById(R.id.textData);
        grid=(GridView)v.findViewById(R.id.mGridView);
        addView(v);
    }


    private void BindControlEventvent() {

        btnPrew.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mCalendar.add(Calendar.MONTH,-1);
                renderCalendar();
            }
        });

        btnNext.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mCalendar.add(Calendar.MONTH,1);
                renderCalendar();
            }
        });
    }

    private void renderCalendar() {

        SimpleDateFormat sdf=new SimpleDateFormat("MMM yyy");
        textData.setText(sdf.format(mCalendar.getTime()));

        ArrayList<Date> cells=new ArrayList<>();
        Calendar calendar= (Calendar) mCalendar.clone();
        calendar.set(Calendar.DAY_OF_MONTH,1);
        int prewDays=calendar.get(Calendar.DAY_OF_WEEK)-1;
        calendar.add(Calendar.DAY_OF_MONTH,-prewDays);


        int maxConnt=6*7;
        while (cells.size()<maxConnt){
            cells.add(calendar.getTime());
            calendar.add(Calendar.DAY_OF_MONTH,1);
        }

        grid.setAdapter(adapter=new MyAdapter(getContext(),cells));
        adapter.notifyDataSetChanged();
    }


    MyAdapter adapter;
    private class MyAdapter extends BaseAdapter{
        ArrayList<Date> list;
        Context context;
        public MyAdapter(@NonNull Context context, ArrayList<Date> list) {
            this.context=context;
            this.list=list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            TextView itemTime=null;
            View v=null;
            if(convertView==null){
                v = LayoutInflater.from(context).inflate(R.layout.text,null);
            }else {
                v=convertView;
            }
            itemTime=(TextView)v.findViewById(R.id.itemData);
            itemTime.setText(String.valueOf(list.get(position).getDate()));


            Date d=new Date();
            Date d1 = list.get(position);
            if(d1.getDate()==d1.getDate()&&
                    d.getMonth()==d1.getMonth()&&
                    d.getYear()==d1.getYear()){
                itemTime.setBackgroundColor(Color.RED);
            }
            return v;
        }
    }
}
