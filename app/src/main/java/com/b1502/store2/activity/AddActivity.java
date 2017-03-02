package com.b1502.store2.activity;

import android.content.Intent;
import android.os.Bundle;

import com.b1502.store2.R;

public class AddActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initgetIntent();
    }

    //接受值
    private void initgetIntent() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        initStoreBar(name);
    }
}
