package com.b1502.store2.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.b1502.store2.R;

/**
 * Created by Pooh on 2017/2/28.
 */
public class MyTabFragment extends Fragment{

    private TextView tab_name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_tab, container, false);
        tab_name = (TextView) mView.findViewById(R.id.tab_name);
        return mView;
    }

}
