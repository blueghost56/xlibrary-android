package com.ways.android.xlibrary.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import android.view.View;

import android.widget.FrameLayout;
import android.widget.RelativeLayout;


import com.ways.android.xlibrary.adapter.VerticalmenuAdapter;
import com.ways.android.xlibrary.entity.XItem;
import com.ways.android.xlibrary.utils.XDipPXUtils;

import java.util.List;

/**
 * Created by csl on 16/4/1.
 */
public class XRotationdrawer extends RelativeLayout {

    //菜单
    private RecyclerView recyclerView;
    //菜单控制按钮
    private XFloatActionButton xFloatActionButton;
    //数据集
    private VerticalmenuAdapter verticalmenuAdapter;

    private boolean isClicked;

    public XRotationdrawer(Context context){
        super(context);
        init();
    }
    public XRotationdrawer(Context context, AttributeSet attrs){
        super(context,attrs);
        init();
    }
    public XRotationdrawer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public XRotationdrawer(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


    private void init(){
        //初始并添加子View
       LayoutParams layoutPrams=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
          layoutPrams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
          layoutPrams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

        xFloatActionButton=new XFloatActionButton(getContext());
        xFloatActionButton.setId(1);
        addView(xFloatActionButton, layoutPrams);

        xFloatActionButton.setOnClickListener(listener);

          recyclerView=new RecyclerView(getContext());
        LayoutParams layoutPrams2=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
          layoutPrams2.addRule(RelativeLayout.ABOVE, 1);
          layoutPrams2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
          addView(recyclerView, layoutPrams2);



        verticalmenuAdapter=new VerticalmenuAdapter(getContext());

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(verticalmenuAdapter);
        recyclerView.setVisibility(GONE);
    }

    public void setMenuItems(List<XItem<String,Integer>> items){
        verticalmenuAdapter.updateDataset(items);
    }

    public void setOnMenuItemListener(OnClickListener listener){
        verticalmenuAdapter.setOnItemClickListener(listener);
    }

   private OnClickListener listener=new OnClickListener() {

       @Override
       public void onClick(View v) {
            isClicked=!isClicked;
           handleClick(isClicked);
       }
   };

    private void handleClick(boolean isClick){
        xFloatActionButton.doRotationAnimation(isClick);
        recyclerView.setVisibility(isClick ? VISIBLE : GONE);
        setBackgroundColor(isClick? Color.LTGRAY:Color.TRANSPARENT);
    }
}
