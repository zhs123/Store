package com.b1502.store2.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.b1502.store2.R;
import com.b1502.store2.bean.NewsBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import static com.b1502.store2.R.id.imageview;
import static com.b1502.store2.R.id.textview;

/**
 * 1.类的用途
 * 2.@author:zhanghaisheng
 * 3.@2017/2/28
 */


public class NewsAdapter extends BaseAdapter{

    private  List<NewsBean> namelist;
    private Context context;
    private int i;
    public NewsAdapter(List<NewsBean> namelist, Context context) {
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
            viewHolder=new ViewHolder();
            convertView=View.inflate(context, R.layout.item_newsfragment,null);
            viewHolder.imageView =(ImageView) convertView.findViewById(imageview);
            viewHolder.textView =(TextView) convertView.findViewById(textview);
            convertView.setTag(viewHolder);
        }else {
            viewHolder  =(ViewHolder) convertView.getTag();
        }

        //显示图片
//        DisplayImageOptions options = new DisplayImageOptions.Builder()
//                .cacheInMemory(true)
//                .cacheOnDisk(true)
//                .bitmapConfig(Bitmap.Config.RGB_565)
//                .build();
        ImageLoader.getInstance().displayImage(namelist.get(position).getImgUrl(), viewHolder.imageView);
        viewHolder.textView.setText(namelist.get(i).getTitle());
        return convertView;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
