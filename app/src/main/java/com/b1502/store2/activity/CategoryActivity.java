package com.b1502.store2.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.b1502.store2.R;

/**
 * 分类列表页面
 * <p>
 * TabLayout
 */
public class CategoryActivity extends BaseActivity implements View.OnClickListener {

    private TextView category_comprehensive;
    private TextView category_sales_volume;
    private TextView category_price;

    public static void open(Activity activity) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        initgetIntent();
        initid();

    }

    private void initid() {
        //综合
        category_comprehensive = (TextView) findViewById(R.id.category_comprehensive);
        //销量
        category_sales_volume = (TextView) findViewById(R.id.category_Sales_volume);
        //价格
        category_price = (TextView) findViewById(R.id.category_Price);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.category_recycle);
        category_comprehensive.setOnClickListener(this);
        category_sales_volume.setOnClickListener(this);
        category_price.setOnClickListener(this);

    }

    //接受值
    private void initgetIntent() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        initStoreBar(name);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.category_comprehensive:
                category_comprehensive.setTextColor(Color.RED);
                category_sales_volume.setTextColor(Color.BLACK);
                category_price.setTextColor(Color.BLACK);
                break;
            case R.id.category_Sales_volume:
                category_comprehensive.setTextColor(Color.BLACK);
                category_sales_volume.setTextColor(Color.RED);
                category_price.setTextColor(Color.BLACK);
                break;
            case R.id.category_Price:
                category_comprehensive.setTextColor(Color.BLACK);
                category_sales_volume.setTextColor(Color.BLACK);
                category_price.setTextColor(Color.RED);
                break;

            default:
                break;
        }

    }



}
