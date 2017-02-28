package com.b1502.store2.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.b1502.store2.R;
import com.b1502.store2.bean.CartBean;
import com.b1502.store2.model.StoreParams;
import com.b1502.store2.util.UrlUtil;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.xutils.common.Callback;
import org.xutils.x;

import java.util.List;

import static com.b1502.store2.R.id.cart_item_name;
import static com.b1502.store2.R.id.cart_item_price;


/**
 * 购物车
 * A simple {@link Fragment} subclass.
 * Use the {@link CartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CartFragment extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private SparseArray<Boolean> mSelectState = new SparseArray<>();
    private int totalprice = 0;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView cartlistView;
    private List<CartBean> list1;
    private CartAdapter cartAdapter;
    private CartBean[] cartBeen;
    private TextView cart_jiesuan;
    private TextView cart_price;
    private CheckBox check_box;

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
        check_box = (CheckBox) view.findViewById(R.id.check_box);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getItems();
    }

    //适配数据并且刷新listview
    private void refreshListView() {
        if (cartAdapter == null) {
            cartAdapter = new CartAdapter();
            cartlistView.setAdapter(cartAdapter);
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
                Gson gson=new Gson();
                cartBeen = gson.fromJson(result, CartBean[].class);
                refreshListView();
               // Log.d(TAG, list1.toString());

            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }
            @Override
            public void onFinished() {

            }
        });
    }
    public class CartAdapter extends BaseAdapter{

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
            if (convertView == null) {
                convertView = View.inflate(getActivity(), R.layout.cart_item, null);
                holder = new MyViewHolder();
                holder.imageView = (ImageView) convertView.findViewById(R.id.cart_item_image);
                holder.cart_item_name = (TextView) convertView.findViewById(cart_item_name);
                holder.cart_item_price = (TextView) convertView.findViewById(cart_item_price);
                holder.checkbox = (CheckBox) convertView.findViewById(R.id.cart_item_checkbox);
                convertView.setTag(holder);
            } else {
                holder = (MyViewHolder) convertView.getTag();
            }
            CartBean cartBean = cartBeen[position];
            holder.cart_item_name.setText(cartBean.getName());
            holder.cart_item_price.setText("￥" + cartBean.getPrice() + "");
            ImageLoader.getInstance().displayImage(UrlUtil.getImageUrl(cartBean.getImageUrl()), holder.imageView);
            holder.checkbox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "点击了", Toast.LENGTH_SHORT).show();
                    CartBean cartBean = cartBeen[position];
                    MyViewHolder viewHolder = (MyViewHolder) v.getTag();
                    int id = cartBean.getI();
                    boolean b = !mSelectState.get(id, false);
                    //viewHolder.checkbox.toggle();
                    if(b){
                        mSelectState.put(id,true);
                        totalprice+=cartBean.getPrice()*cartBean.getCount();
                    }else{
                        mSelectState.delete(id);
                        totalprice-=cartBean.getPrice()*cartBean.getCount();
                    }
                    cart_jiesuan.setText("结算"+"("+mSelectState.size()+")");
                    cart_price.setText("￥"+totalprice);
                    if(mSelectState.size()==cartBeen.length){
                        check_box.setChecked(true);
                    }else{
                        check_box.setChecked(false);
                    }
                }
            });
            return convertView;
        }

        class MyViewHolder {
            ImageView imageView;
            TextView cart_item_name;
            TextView cart_item_price;
            CheckBox checkbox;
        }

    }
}

