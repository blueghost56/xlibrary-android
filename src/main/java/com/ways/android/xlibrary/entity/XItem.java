package com.ways.android.xlibrary.entity;

/**
 * Created by csl on 16/4/1.
 */
public final class XItem<E,T>{
    public final E title;
    public final T icon;
    public XItem(E title, T icon){
        this.title=title;
        this.icon=icon;
    }
}
