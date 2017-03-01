package com.b1502.store2.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.b1502.store2.R;
import com.b1502.store2.adapter.Cateadapter;
import com.b1502.store2.bean.CatBean_;
import com.b1502.store2.network.StoreParams;
import com.b1502.store2.util.UrlUtil;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.x;

import java.util.List;

/**
 * 分类列表页面
 * <p>
 * TabLayout
 */
public class CategoryActivity extends BaseActivity implements View.OnClickListener {

    private TextView category_comprehensive;
    private TextView category_sales_volume;
    private TextView category_price;
    private RecyclerView recyclerView;
    private Cateadapter categoryAdapter;

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
        recyclerView = (RecyclerView) findViewById(R.id.category_recycle);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        categoryAdapter = new Cateadapter(this);
        recyclerView.setAdapter(categoryAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(CategoryActivity.this, LinearLayout.VERTICAL));
        recyclerView.addItemDecoration(new DividerItemDecoration(CategoryActivity.this, LinearLayout.HORIZONTAL));


        category_comprehensive.setOnClickListener(this);
        category_sales_volume.setOnClickListener(this);
        category_price.setOnClickListener(this);

    }

    //接受值
    private void initgetIntent() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String id = intent.getStringExtra("id");
        initStoreBar(name);

        getCategory("categoryId", id);
        getProducts(id, 0);
    }

    @Override
    public void onClick(@NonNull View v) {
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

    /**
     * @param param
     * @param categoryId
     */
    public void getCategory(String param, String categoryId) {
        StoreParams params = new StoreParams(UrlUtil.GetCategory, param, categoryId);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onSuccess(String result) {
//                Log.i("MainActivity", result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    //分类界面

    public void getProducts(final String productCategoryId, int startRowIndex) {
        StoreParams params = new StoreParams(UrlUtil.GetProducts, productCategoryId, startRowIndex);
        x.http().get(params, new Callback.CommonCallback<String>() {

            private List<CatBean_.ProductsEntity> products;

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onSuccess(String result) {
                Log.i("MainActivity", result);
                Gson gson = new Gson();
                CatBean_ catBean_ = gson.fromJson(result, CatBean_.class);
                List<CatBean_.ProductsEntity> products = catBean_.getProducts();
                Log.i("TAG", products.toString());
//                List<CatBean_> list = gson.fromJson(result, new TypeToken<List<CatBean_>>() {
//                }.getType());
//                for (int i = 0; i < list.size(); i++) {
//                    products = list.get(i).getProducts();
//
//                }
                categoryAdapter.setData(products);
//                List<CatBean_.ProductsEntity> products = new ArrayList<CatBean_.ProductsEntity>();
//                for (int i = 0; i < list.size(); i++) {
//                    products.addAll(list.get(i).getProducts());
//                }


            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onFinished() {

            }
        });
    }


}
