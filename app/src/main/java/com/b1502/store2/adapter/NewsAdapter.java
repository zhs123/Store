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
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author:zhanghaisheng
 * 3.@2017/2/28
 */


public class NewsAdapter extends BaseAdapter{
    private List<NewsBean> list;
    private Context context;
    private int i;
    @Override
    public int getCount() {
        return list.size();
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
            convertView=View.inflate(context, R.layout.item_newsfragment,null);
            viewHolder=new ViewHolder();
            ImageView imageview =(ImageView) convertView.findViewById(R.id.imageview);
            TextView textview =(TextView) convertView.findViewById(R.id.textview);
            convertView.setTag(viewHolder);
        }else {
            viewHolder  =(ViewHolder) convertView.getTag();
        }
        //显示图片
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration
                .createDefault(context);
        //ImageLoader.getInstance().init(configuration);
        // DisplayImageOptions options = ImageLoaderUtils.initOptions();
        ImageLoader.getInstance().displayImage(list.get(position).getImgUrl(), viewHolder.imageView);
        viewHolder.textView.setText(list.get(i).getTitle());
        return convertView;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
