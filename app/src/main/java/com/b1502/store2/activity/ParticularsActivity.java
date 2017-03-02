package com.b1502.store2.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ListView;
import android.widget.TextView;

import com.b1502.store2.R;
import com.b1502.store2.model.StoreParams;
import com.b1502.store2.util.UrlUtil;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.x;

public class ParticularsActivity extends AppCompatActivity {
    private ListView partctlars_listview;
    private WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_particulars);
        initView();
        initdata();
    }

    private void initdata() {
        StoreParams params = new StoreParams(UrlUtil.GetNews);
        x.http().get(params, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i("MainActivity", "1scmcsndbdj" + result);
                Gson gson = new Gson();
//                List<Bean> namelist = gson.fromJson(result, new TypeToken<List<Bean>>() {
//                }.getType());
//                Bean namelist=gson.fromJson(result,Bean.class);
//                partctlars_listview.setAdapter(new PartcularsAdapter((List<Bean>) namelist,ParticularsActivity.this));
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public boolean onCache(String result) {
                return false;
            }
        });
    }

    private void initView() {
       //  partctlars_listview = (ListView) findViewById(R.id.partctlars_listview);
        TextView jump =(TextView) findViewById(R.id.jump);
        webview =(WebView) findViewById(R.id.webview);
        webview.loadUrl("http://web.alinq.cn/store2/#home_news?id=648cf203-16f0-4603-b291-40864c472356");


    }
}
