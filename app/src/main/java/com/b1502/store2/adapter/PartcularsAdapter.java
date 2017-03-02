package com.b1502.store2.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.b1502.store2.R;
import com.b1502.store2.bean.Bean;
import com.b1502.store2.util.ImageLoader;
import com.b1502.store2.util.LogUtil;
import com.b1502.store2.util.UrlUtil;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author:zhanghaisheng
 * 3.@2017/3/1
 */


public class PartcularsAdapter extends BaseAdapter{

    private List<Bean> namelist;
    private Context context;
    public PartcularsAdapter(List<Bean> namelist, Context context) {
        this.namelist = namelist;
        this.context = context;
    }



    @Override
    public int getCount() {
        return namelist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if(convertView==null){
            convertView=View.inflate(context, R.layout.partculars_item,null);
            viewHolder=new ViewHolder();
            viewHolder.title =(TextView) convertView.findViewById(R.id.title);
            viewHolder.time =(TextView) convertView.findViewById(R.id.time);
            viewHolder.count =(TextView) convertView.findViewById(R.id.count);
            viewHolder.imageview =(ImageView) convertView.findViewById(R.id.imageview);
            convertView.setTag(viewHolder);
        }else {
            viewHolder  =(ViewHolder) convertView.getTag();

        }
        ImageLoader image = new ImageLoader(context, "tttt");
        final ViewHolder finalViewHolder = viewHolder;
        LogUtil.d("111", UrlUtil.getImageUrl(namelist.get(position).getImgUrl()));
        image.loadImage(UrlUtil.getImageUrl(namelist.get(position).getImgUrl()), new ImageLoader.ImageLoadListener() {
            @Override
            public void loadImage(Bitmap bmp) {
                finalViewHolder.imageview.setImageBitmap(bmp);
            }
        });
        viewHolder.title.setText(namelist.get(position).getTitle());
        viewHolder.count.setText(namelist.get(position).getContent());
        viewHolder.time.setText(namelist.get(position).getDate());
        return convertView;
    }
    class ViewHolder{
        ImageView imageview;
        TextView title,time,count;
    }
}
