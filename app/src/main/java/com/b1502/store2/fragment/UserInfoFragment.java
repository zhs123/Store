package com.b1502.store2.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.b1502.store2.R;
import com.b1502.store2.activity.AccountActivity;
import com.b1502.store2.activity.AddActivity;
import com.b1502.store2.activity.AppraiseActivity;
import com.b1502.store2.activity.CollectActivity;
import com.b1502.store2.activity.CouponActivity;
import com.b1502.store2.activity.OrderActivity;
import com.b1502.store2.activity.PointsActivity;
import com.b1502.store2.activity.QuitActivity;

/**
 * 用户信息
 * A simple {@link Fragment} subclass.
 * Use the {@link UserInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserInfoFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
//    private View view;
    private RadioButton rb_appraise;
    private RadioButton rb_delivery;
    private RadioButton rb_order;
    private RadioButton rb_pay;
    private RelativeLayout mycollect;
    private RelativeLayout mycoupon;
    private RelativeLayout mypoints;
    private RelativeLayout accountsecurity;
    private RelativeLayout quit;
    private RadioGroup rg;
    private RelativeLayout myadd;


    public UserInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserInfoFragment newInstance(String param1, String param2) {
        UserInfoFragment fragment = new UserInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_user_info,null);
        //获取控件
        //intoView();
        rb_appraise = (RadioButton) view.findViewById(R.id.rb_appraise);
        rb_delivery = (RadioButton) view.findViewById(R.id.rb_delivery);
        rb_order = (RadioButton) view.findViewById(R.id.rb_order);
        rb_pay = (RadioButton) view.findViewById(R.id.rb_pay);
        rg = (RadioGroup) view.findViewById(R.id.rg);

        //RelativeLayout
        mycollect = (RelativeLayout) view.findViewById(R.id.user_info_mycollect);
        mycoupon = (RelativeLayout) view.findViewById(R.id.user_info_mycoupon);
        myadd = (RelativeLayout) view.findViewById(R.id.user_info_myadd);
        mypoints = (RelativeLayout) view.findViewById(R.id.user_info_mypoints);
        accountsecurity = (RelativeLayout) view.findViewById(R.id.user_info_accountsecurity);
        quit = (RelativeLayout) view.findViewById(R.id.user_info_quit);
        //点击
        rg.setOnCheckedChangeListener(this);
        myadd.setOnClickListener(this);
        mycollect.setOnClickListener(this);
        mycoupon.setOnClickListener(this);
        mypoints.setOnClickListener(this);
        accountsecurity.setOnClickListener(this);
        quit.setOnClickListener(this);


        return view;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rb_order:
                Intent intent_order = new Intent(getActivity(), OrderActivity.class);
                startActivity(intent_order);
                break;
            case R.id.rb_pay:
                Intent intent_pay = new Intent(getActivity(), OrderActivity.class);
                startActivity(intent_pay);
                break;
            case R.id.rb_delivery:
                Intent intent_delivery = new Intent(getActivity(), OrderActivity.class);
                startActivity(intent_delivery);
                break;
            case R.id.rb_appraise:
                Intent intent_appraise = new Intent(getActivity(), AppraiseActivity.class);
                startActivity(intent_appraise);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.user_info_myadd:
                Intent intent_myadd = new Intent(getActivity(), AddActivity.class);
                startActivity(intent_myadd);
                break;
            case R.id.user_info_mycollect:
                Intent intent_mycollect = new Intent(getActivity(), CollectActivity.class);
                startActivity(intent_mycollect);
                break;
            case R.id.user_info_mypoints:
                Intent intent_mypoints = new Intent(getActivity(), PointsActivity.class);
                startActivity(intent_mypoints);
                break;
            case R.id.user_info_mycoupon:
                Intent intent_mycoupon = new Intent(getActivity(), CouponActivity.class);
                startActivity(intent_mycoupon);
                break;
            case R.id.user_info_accountsecurity:
                Intent intent_accountsecurity = new Intent(getActivity(), AccountActivity.class);
                startActivity(intent_accountsecurity);
                break;
            case R.id.user_info_quit:
                Intent intent_quit = new Intent(getActivity(), QuitActivity.class);
                startActivity(intent_quit);
                break;
        }
    }
}
