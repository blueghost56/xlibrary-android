package com.ways.android.xlibrary.animation;

import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;

/**
 * Created by csl on 16/4/1.
 */
public final class XAnimationUtils {
    private final static long DURATION_MILLIS=1000;
    private final static int SHAKE_TIMES=5;
    private final static int ZERO=0;

    /**
     *
     * 简单左右摇晃动画1秒/5次
     * @return Animation
     *
     */
    public static final Animation simpleShakeAnimation(){
       final Animation animation=new TranslateAnimation(ZERO,10,ZERO,ZERO);
           animation.setDuration(DURATION_MILLIS);
           animation.setInterpolator(new CycleInterpolator(SHAKE_TIMES));
        return animation;
    }

    /**
     * 360度旋转
     * @return Animation
     */
    public static final Animation simpleRotateAnimation(boolean isClockwise){
       final Animation animation=new RotateAnimation(0f,(isClockwise?360f:-360f),Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        animation.setRepeatCount(0);
        animation.setFillAfter(true);
        animation.setDuration(DURATION_MILLIS);
       return animation;
    }

}
