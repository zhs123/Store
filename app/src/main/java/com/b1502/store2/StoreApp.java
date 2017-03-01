package com.b1502.store2;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.xutils.x;

/**
 * 1. 类的用途
 * 2. @author：liqingyi
 * 3. @date：2017/2/26 13:16
 */

public class StoreApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        //初始化ImageLoader
        ImageLoaderConfiguration.Builder builder = new ImageLoaderConfiguration.Builder(this);
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(builder.build());
    }
}
