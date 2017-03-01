package com.b1502.store2.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.b1502.store2.R;
import com.b1502.store2.bean.CartBean;
import com.b1502.store2.model.StoreParams;
import com.b1502.store2.util.ImageLoader;
import com.b1502.store2.util.UrlUtil;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import static com.b1502.store2.R.id.cart_item_name;
import static com.b1502.store2.R.id.cart_item_price;
import static com.b1502.store2.R.id.check_box;


/**
 * 购物车
 * A simple {@link Fragment} subclass.
 * Use the {@link CartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CartFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private SparseArray<Boolean> mSelectState = new SparseArray<>();


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView cartlistView;
    private CartAdapter cartAdapter;
    private CartBean[] cartBeen;
    private TextView cart_jiesuan;
    private TextView cart_price;
    private CheckBox check_boxAll;
    private View view;
    private List<CartBean> bean;
    private LinearLayout bottom_bar;
    private TextView cartTextview;
    private double totalprice=0.00;
    private List<CartBean> list=new ArrayList<>();
    private int totalnum=1;

    public CartFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CartFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CartFragment newInstance(String param1, String param2) {
        CartFragment fragment = new CartFragment();
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
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        cartlistView = (ListView) view.findViewById(R.id.cartlistView);
        cart_jiesuan = (TextView) view.findViewById(R.id.cart_jiesuan);
        cart_price = (TextView) view.findViewById(R.id.cart_price);
        check_boxAll = (CheckBox) view.findViewById(check_box);
        bottom_bar = (LinearLayout) view.findViewById(R.id.bottom_bar);
        cartTextview = (TextView) view.findViewById(R.id.cartTextview);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getItems();
        check_boxAll.setOnCheckedChangeListener(this);


    }
    //适配数据并且刷新listview
    private void refreshListView() {
        if (cartAdapter == null) {
            cartAdapter = new CartAdapter();
            cartlistView.setAdapter(cartAdapter);
         cartlistView.setOnItemClickListener(cartAdapter);
        } else {
            cartAdapter.notifyDataSetChanged();
        }
    }
    private void getItems() {
        StoreParams params = new StoreParams(UrlUtil.GetItems);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                cartBeen = gson.fromJson(result, CartBean[].class);

              if (CartFragment.this.cartBeen.length != 0 && CartFragment.this.cartBeen.length > 0) {
                    bottom_bar.setVisibility(View.VISIBLE);
                    cartTextview.setVisibility(View.GONE);
                    cartlistView.setVisibility(View.VISIBLE);
                } else {
                    bottom_bar.setVisibility(View.GONE);
                    cartTextview.setVisibility(View.VISIBLE);
                }
                refreshListView();
            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            for(int i=0;i<cartBeen.length;i++){
                cartBeen[i].setCheck(isChecked);
            }
            refreshListView();
            setPrice();
        }else{
            for(int i=0;i<cartBeen.length;i++){
                cartBeen[i].setCheck(isChecked);
            }
            refreshListView();
            setPrice();
        }
    }


    public class CartAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {

        @Override
        public int getCount() {
            return cartBeen.length;
        }

        @Override
        public Object getItem(int position) {
            return cartBeen[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            MyViewHolder holder = null;
            view = convertView;
            if (view == null) {
                view = View.inflate(getActivity(), R.layout.cart_item, null);
                holder = new MyViewHolder();
                holder.imageView = (ImageView) view.findViewById(R.id.cart_item_image);
                holder.cart_item_name = (TextView) view.findViewById(cart_item_name);
                holder.cart_item_price = (TextView) view.findViewById(cart_item_price);
                holder.checkbox = (CheckBox) view.findViewById(R.id.cart_item_checkbox);
                holder.add = (TextView) view.findViewById(R.id.tv_add);
                holder.reduce = (TextView) view.findViewById(R.id.tv_reduce);
                holder.num = (TextView) view.findViewById(R.id.tv_num);
                view.setTag(holder);
            } else {
                holder = (MyViewHolder) view.getTag();
            }
            final CartBean cartBean = cartBeen[position];
            holder.cart_item_name.setText(cartBean.getName());
            holder.cart_item_price.setText("￥" + cartBean.getPrice() + "");
            ImageLoader imageLoader=new ImageLoader(getActivity(),"text8");
            holder.num.setText(cartBean.getCount()+"");
            final MyViewHolder finalHolder = holder;
            imageLoader.loadImage(UrlUtil.getImageUrl(cartBean.getImageUrl()), new ImageLoader.ImageLoadListener() {
                @Override
                public void loadImage(Bitmap bmp) {
                    finalHolder.imageView.setImageBitmap(bmp);
                }
            });
            holder.checkbox.setChecked(cartBean.isCheck());
            holder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        cartBean.setCheck(isChecked);
                    } else {
                        cartBean.setCheck(isChecked);
                    }
                    notifyDataSetChanged();
                    setPrice();
                }
            });
            final MyViewHolder finalHolder1 = holder;
            holder.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cartBean.setCount(cartBean.getCount()+1);
                    notifyDataSetChanged();
                    setPrice();
                }
            });
            holder.reduce.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(cartBean.getCount()<2){
                        return;
                    }
                    cartBean.setCount(cartBean.getCount()-1);
                    notifyDataSetChanged();
                    setPrice();
                }
            });
            return view;
        }

       @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        }
        class MyViewHolder {
            ImageView imageView;
            TextView cart_item_name;
            TextView cart_item_price;
            CheckBox checkbox;
            TextView add;
            TextView reduce;
            TextView num;
        }

    }
    public void setPrice(){
        totalprice=0.00;
        totalnum=0;
        for(int i=0;i<cartBeen.length;i++){
            if(cartBeen[i].isCheck()){
                totalnum = totalnum+cartBeen[i].getCount();
                totalprice+=cartBeen[i].getPrice()*cartBeen[i].getCount();
            }
        }
        cart_jiesuan.setText("结算" + "(" + totalnum + ")");
        cart_price.setText("￥" + totalprice);
    }
}

