package com.ways.android.xlibrary.log;

import android.util.Log;

/**
 * Created by csl on 16/4/1.
 */
public final class XLog {
    private final static boolean DEBUG=true;

    public static  void out(Class<?> zclass,String msg){
         if(DEBUG){
             final  String Tag=zclass.getSimpleName();
             Log.i(Tag,msg);
         }
    }
}
