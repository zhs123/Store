package com.b1502.store2.util;

import android.content.Context;
import android.widget.ImageView;

import com.youth.banner.loader.ImageLoader;

/**
 * 作者：郭传沛
 * 时间：2017/2/28:15:27
 * 邮箱：gcpzdl@mail.com
 * 说明： banner图片加载器
 */


public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        com.nostra13.universalimageloader.core.ImageLoader imageLoader = com.nostra13.universalimageloader.core.ImageLoader.getInstance();
        imageLoader.displayImage((String) path, imageView);
    }
}
