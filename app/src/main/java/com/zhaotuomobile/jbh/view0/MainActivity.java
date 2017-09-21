package com.zhaotuomobile.jbh.view0;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements MyRecyclerView.TouchOffset{

    private MyRecyclerView mRecyclerView;

    private RecyclerView listContact;

    private TextView showText;

    private LinearLayoutManager linearLayoutManager;

    private String[] list={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    private String[] str={"就","发","感受到","假如","住房","让它","一天","缩放"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView=(MyRecyclerView)findViewById(R.id.mRecyclerView);
        mRecyclerView.setTouchOffset(this);
        showText=(TextView)findViewById(R.id.text) ;
        listContact=(RecyclerView)findViewById(R.id.listContact);
        initList();
        initListContact();
        comparator();
    }

    private void comparator() {
        /**通过文字首字母排序的*/
        Comparator comparator= Collator.getInstance(Locale.CHINA);
        Arrays.sort(str,comparator);
        for (int i=0;i<str.length;i++){
            Log.v("========","字母："+getPYIndexStr(str[i],true)+"\nstr="+str[i]);
        }
    }



    private void initList() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        CommonAdapter adapter=new CommonAdapter(this,R.layout.text,list.length,0,0) {

            @Override
            public void content(RecyclerView.ViewHolder holder, int position) {
                TextView itemData=(TextView)holder.itemView.findViewById(R.id.itemData);
                itemData.setText(list[position]);
            }

            @Override
            public void headContent(RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            public void footerContent(RecyclerView.ViewHolder holder, int position) {

            }
        };
        mRecyclerView.setAdapter(adapter);
    }


    private void initListContact() {
        linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listContact.setLayoutManager(linearLayoutManager);
        CommonAdapter adapter=new CommonAdapter(this,R.layout.item_layout,list.length,0,0) {

            @Override
            public void content(RecyclerView.ViewHolder holder, int position) {
                TextView title_name=(TextView)holder.itemView.findViewById(R.id.title_name);
                title_name.setText(list[position]);
            }

            @Override
            public void headContent(RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            public void footerContent(RecyclerView.ViewHolder holder, int position) {

            }
        };
        listContact.setAdapter(adapter);
    }

    @Override
    public void offset(int position , float offset,Boolean state ) {
        if(state){
            showText.setVisibility(View.VISIBLE);
            Log.d("======","position:"+position);
            showText.setTranslationY(offset);
            showText.setText(list[position]);
            linearLayoutManager.scrollToPosition(position);
        }else {
            showText.setVisibility(View.GONE);
        }
    }


    /**
     * @param strChinese
     * @param bUpCase
     * @return
     */
    public static String getPYIndexStr(String strChinese, boolean bUpCase){
        try{
            StringBuffer buffer = new StringBuffer();
            //把中文转化成byte数组
            byte b[] = strChinese.getBytes("GBK");
            for(int i = 0; i < b.length; i++){
                if((b[i] & 255) > 128){
                    int char1 = b[i++] & 255;
                    //左移运算符用“<<”表示，是将运算符左边的对象，向左移动运算符右边指定的位数，并且在低位补零。其实，向左移n位，就相当于乘上2的n次方
                    char1 <<= 8;
                    int chart = char1 + (b[i] & 255);
                    buffer.append(getPYIndexChar((char)chart, bUpCase));
                    continue;
                }
                char c = (char)b[i];
                //确定指定字符是否可以是 Java 标识符中首字符以外的部分。
                if(!Character.isJavaIdentifierPart(c)){
                    c = 'A';
                }
                buffer.append(c);
            }
            return buffer.toString();
        }catch(Exception e){
            System.out.println((new StringBuilder()).append("\u53D6\u4E2D\u6587\u62FC\u97F3\u6709\u9519").append(e.getMessage()).toString());
        }
        return null;
    }


    /**
     * @param strChinese
     * @param bUpCase
     * @return
     */
    private static char getPYIndexChar(char strChinese, boolean bUpCase){
        int charGBK = strChinese;
        char result;
        if(charGBK >= 45217 && charGBK <= 45252)
            result = 'A';
        else
        if(charGBK >= 45253 && charGBK <= 45760)
            result = 'B';
        else
        if(charGBK >= 45761 && charGBK <= 46317)
            result = 'C';
        else
        if(charGBK >= 46318 && charGBK <= 46825)
            result = 'D';
        else
        if(charGBK >= 46826 && charGBK <= 47009)
            result = 'E';
        else
        if(charGBK >= 47010 && charGBK <= 47296)
            result = 'F';
        else
        if(charGBK >= 47297 && charGBK <= 47613)
            result = 'G';
        else
        if(charGBK >= 47614 && charGBK <= 48118)
            result = 'H';
        else
        if(charGBK >= 48119 && charGBK <= 49061)
            result = 'J';
        else
        if(charGBK >= 49062 && charGBK <= 49323)
            result = 'K';
        else
        if(charGBK >= 49324 && charGBK <= 49895)
            result = 'L';
        else
        if(charGBK >= 49896 && charGBK <= 50370)
            result = 'M';
        else
        if(charGBK >= 50371 && charGBK <= 50613)
            result = 'N';
        else
        if(charGBK >= 50614 && charGBK <= 50621)
            result = 'O';
        else
        if(charGBK >= 50622 && charGBK <= 50905)
            result = 'P';
        else
        if(charGBK >= 50906 && charGBK <= 51386)
            result = 'Q';
        else
        if(charGBK >= 51387 && charGBK <= 51445)
            result = 'R';
        else
        if(charGBK >= 51446 && charGBK <= 52217)
            result = 'S';
        else
        if(charGBK >= 52218 && charGBK <= 52697)
            result = 'T';
        else
        if(charGBK >= 52698 && charGBK <= 52979)
            result = 'W';
        else
        if(charGBK >= 52980 && charGBK <= 53688)
            result = 'X';
        else
        if(charGBK >= 53689 && charGBK <= 54480)
            result = 'Y';
        else
        if(charGBK >= 54481 && charGBK <= 55289)
            result = 'Z';
        else
            result = (char)(65 + (new Random()).nextInt(25));
        if(!bUpCase)
            result = Character.toLowerCase(result);
        return result;
    }
}
