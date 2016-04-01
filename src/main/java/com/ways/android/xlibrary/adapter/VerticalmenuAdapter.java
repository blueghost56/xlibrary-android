package com.ways.android.xlibrary.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ways.android.xlibrary.entity.XItem;
import com.ways.android.xlibrary.log.XLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wwzy on 16/4/1.
 */
public class VerticalmenuAdapter extends RecyclerView.Adapter<VerticalmenuAdapter.ViewHolder>{

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView menuView;
        public ViewHolder(View itemView) {
            super(itemView);
            this.menuView=(TextView)itemView;
            this.menuView.setBackgroundColor(Color.BLUE);
        }
    }

    private List<XItem<String,Integer>> items;
    private Context mContext;
    private View.OnClickListener listener;

    public VerticalmenuAdapter(@Nullable List<XItem<String,Integer>> items){
         setItems(items);
    }

    public VerticalmenuAdapter(Context context){
      this.mContext=context;
    }

    void setItems(List<XItem<String,Integer>>items){
        if(items==null){
            items=new ArrayList<>();
        }
        this.items=items;
    }

    public void updateDataset(List<XItem<String,Integer>> items){
        this.items=items;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(View.OnClickListener listener){
        this.listener=listener;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView menuView=new TextView(mContext);
         menuView.setOnClickListener(listener);
        return new ViewHolder(menuView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
      XItem<String,Integer> item=items.get(position);
        holder.menuView.setText(item.title);
        holder.menuView.setCompoundDrawables(null,null,null,null);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
