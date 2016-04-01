package com.ways.android.xlibrary.utils;

import android.content.Context;

/**
 * Created by csl on 16/4/1.
 */
public final class XDipPXUtils {
  public static final int dp2px(Context context,float dpValue){
      float scale=context.getResources().getDisplayMetrics().density;
      return (int)(dpValue*scale+0.5f);
  }
   public static final int px2dp(Context context,float pxValue){
       float scale=context.getResources().getDisplayMetrics().density;
       return (int)(pxValue/scale+0.5);
   }
}
