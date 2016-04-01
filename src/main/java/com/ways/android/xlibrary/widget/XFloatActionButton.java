package com.ways.android.xlibrary.widget;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;

import com.ways.android.xlibrary.animation.XAnimationUtils;
import com.ways.android.xlibrary.listener.OnClickAgainListener;

/**
 * Created by csl on 16/4/1.
 */
public class XFloatActionButton extends FloatingActionButton implements View.OnClickListener{
    private  boolean isClickAgain;
    private OnClickAgainListener mClickAgainListener;

    public XFloatActionButton(Context context) {
        super(context);
        init();
    }
    public XFloatActionButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public XFloatActionButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 添加事件监听
     * @param listener
     */
    public void addClickAgainListener(OnClickAgainListener listener){
        this.mClickAgainListener=listener;
    }

    /**
     * 简单360度顺时针旋转或相反
    */
    public void doRotationAnimation(boolean isClockwise){
     startAnimation( XAnimationUtils.simpleRotateAnimation(isClockwise));
    }

    @Override
    public void onClick(View v) {
        isClickAgain=!isClickAgain;
        handleClicked();
    }

    private void handleClicked(){
           if(this.mClickAgainListener==null)return;

           if(isClickAgain){
               this.mClickAgainListener.click();
           }else{
               this.mClickAgainListener.clickAgain();
           }

    }

    private void init(){
       setOnClickListener(this);

    }
}
