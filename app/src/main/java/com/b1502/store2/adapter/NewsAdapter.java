package com.b1502.store2.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.b1502.store2.R;
import com.b1502.store2.bean.NewsBean;
import com.b1502.store2.util.ImageLoader;
import com.b1502.store2.util.LogUtil;
import com.b1502.store2.util.UrlUtil;

import java.util.List;

import static com.b1502.store2.R.id.imageview;
import static com.b1502.store2.R.id.textview;

/**
 * 1.类的用途
 * 2.@author:zhanghaisheng
 * 3.@2017/2/28
 * 资讯适配器
 */


public class NewsAdapter extends BaseAdapter {

    private List<NewsBean> namelist;
    private Context context;

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
        return namelist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item_newsfragment, null);
            viewHolder.imageView = (ImageView) convertView.findViewById(imageview);
            viewHolder.textView = (TextView) convertView.findViewById(textview);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ImageLoader image = new ImageLoader(context, "tttt");
        final ViewHolder finalViewHolder = viewHolder;
        LogUtil.d("111", UrlUtil.getImageUrl(namelist.get(position).getImgUrl()));
        image.loadImage(UrlUtil.getImageUrl(namelist.get(position).getImgUrl()), new ImageLoader.ImageLoadListener() {
            @Override
            public void loadImage(Bitmap bmp) {
                finalViewHolder.imageView.setImageBitmap(bmp);
            }
        });
        viewHolder.textView.setText(namelist.get(position).getTitle());
        return convertView;
    }

    class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}
