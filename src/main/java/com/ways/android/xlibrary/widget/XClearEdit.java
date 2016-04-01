package com.ways.android.xlibrary.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.ways.android.xlibrary.R;
import com.ways.android.xlibrary.animation.XAnimationUtils;


/**
 * Created by csl on 16/4/1.
 */
public class XClearEdit extends EditText implements View.OnFocusChangeListener
{
    private Drawable rightDrawable;

    public XClearEdit(Context context) {
        super(context);
        init();
    }
    public XClearEdit(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public XClearEdit(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public XClearEdit(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event){

         if(MotionEvent.ACTION_DOWN==event.getAction()){
             int distanceX=(int)event.getX();
             int clearIconStartX=getWidth()-getTotalPaddingRight();
             int clearIconEndX=getWidth()-getPaddingRight();

              if(distanceX>clearIconStartX&&distanceX<clearIconEndX){
                 clearText();
              }

             return true;
         }

        return false;
    }


    @Override
    public void onFocusChange(View v, boolean hasFocus) {
          if(hasFocus){
           showClearIcon(getText().length()>0);
          }else{
             showClearIcon(false);
          }
    }


    private void init(){

        //初始ClearIcon
        rightDrawable=getResources().getDrawable(R.drawable.ic_cancel);
        rightDrawable.setBounds(0, 0, rightDrawable.getIntrinsicWidth(), rightDrawable.getIntrinsicHeight());

        //注册事件监听
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                showClearIcon(s.length()>0);
            }
        });

        setOnFocusChangeListener(this);

    }

    /**
     * 简单的左右摇晃动画
     */
    public void doShakeAnimation(){
       startAnimation(XAnimationUtils.simpleShakeAnimation());
    }

    //清楚文本
    private void clearText(){
        setText("");
    }
    //是否显示clearIcon
    private void showClearIcon(boolean isClear){
        setCompoundDrawables(null,null,(isClear?rightDrawable:null),null);
    }
}
