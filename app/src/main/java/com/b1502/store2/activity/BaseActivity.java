package com.b1502.store2.activity;

import android.support.v7.app.AppCompatActivity;

import com.b1502.store2.widget.StoreBar;

/**
 * 1. Activity 基类
 * 2. @author：liqingyi
 * 3. @date：2017/2/27 12:45
 */

public class BaseActivity extends AppCompatActivity {

    protected StoreBar storeBar;

    /**
     * 初始化标题栏
     *
     * @param title
     */
    protected void initStoreBar(String title) {
        storeBar = new StoreBar(this);
        storeBar.setTitle(title);
    }

    /**
     * 设置标题
     *
     * @param title
     */
    public void setStoreBarTitle(String title) {
        storeBar.setTitle(title);
    }


}
