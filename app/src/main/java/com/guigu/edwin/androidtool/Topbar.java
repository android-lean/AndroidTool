package com.guigu.edwin.androidtool;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class Topbar extends RelativeLayout{

    private Button leftButton,rightButton;
    private TextView tvTitle;

    private int leftTextColor;
    private Drawable leftBackground;
    private String leftText;
    
    private int rightTextColor;
    private Drawable rightBackground;
    private String rightText;

    private float titleTextSize;
    private int titleTextColors;
    private String titles;

    private LayoutParams leftParams,rightParams,titleParams;


    public Topbar(Context context, AttributeSet attrs) {
        super(context, attrs);

        //获取自定义属性
        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.Topbar);
        //赋值
        leftTextColor = ta.getColor(R.styleable.Topbar_leftTextColor,0);
        leftBackground = ta.getDrawable(R.styleable.Topbar_leftBackground);
        leftText = ta.getString(R.styleable.Topbar_leftText);
        
        rightTextColor = ta.getColor(R.styleable.Topbar_rightTextColor,0);
        rightBackground = ta.getDrawable(R.styleable.Topbar_rightBackground);
        rightText = ta.getString(R.styleable.Topbar_rightText);

        titleTextSize = ta.getDimension(R.styleable.Topbar_titleTextSize,0);
        titleTextColors = ta.getColor(R.styleable.Topbar_titleTextColors,0);
        titles = ta.getString(R.styleable.Topbar_titles);

        //回收资源
        ta.recycle();

        leftButton = new Button(context);//context 引用上下文
        rightButton = new Button(context);
        tvTitle = new TextView(context);

        //吧属性赋值给对象
        leftButton.setTextColor(leftTextColor);
        leftButton.setBackground(leftBackground);
        leftButton.setText(leftText);

        rightButton.setTextColor(rightTextColor);
        rightButton.setBackground(rightBackground);
        rightButton.setText(rightText);

        tvTitle.setTextColor(titleTextColors);
        tvTitle.setTextSize(titleTextSize);
        tvTitle.setText(titles);
        tvTitle.setGravity(Gravity.CENTER);//设置居中

        setBackgroundColor(0xFFF59563);

        leftParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
        addView(leftButton,leftParams);//添加到view

        rightParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
        addView(rightButton,rightParams);

        titleParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);//居中
        addView(tvTitle,titleParams);//添加到view





    }
}
