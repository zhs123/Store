package com.b1502.store2.widget;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.b1502.store2.R;

/**
 * 1. 类的用途
 * 2. @author：liqingyi
 * 3. @date：2017/2/27 11:41
 */

public class StoreBar implements View.OnClickListener {
    Activity activity;
    TextView back;
    TextView title;

    public StoreBar(Activity activity) {
        this.activity = activity;
        this.back = (TextView) activity.findViewById(R.id.bar_back);
        this.back.setOnClickListener(this);
        this.title = (TextView) activity.findViewById(R.id.bar_title);
    }

    public void hideBackButton() {
        this.back.setVisibility(View.GONE);
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bar_back) {
            this.activity.finish();
        }
    }
}
