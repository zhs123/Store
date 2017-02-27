package com.b1502.store2.activity;

import android.app.Activity;
import android.os.Bundle;

import com.b1502.store2.R;

/**
 * 分类列表页面
 * <p>
 * TabLayout
 */
public class CategoryActivity extends BaseActivity {

    public static void open(Activity activity) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        initStoreBar("分类列表");
    }
}
