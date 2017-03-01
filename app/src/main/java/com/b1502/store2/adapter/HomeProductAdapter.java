package com.b1502.store2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.b1502.store2.R;
import com.b1502.store2.model.Product;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 主页产品适配器
 * 2. @author：liqingyi
 * 3. @date：2017/2/27 14:22
 */

public class HomeProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Product> list;
    private Context context;
    private final ImageLoader mImageLoader;

    public HomeProductAdapter(Context context, List<Product> list) {
        this.context = context;
        this.list = list;
        mImageLoader = ImageLoader.getInstance();
    }

    public void addData(ArrayList<Product> items) {
        this.list.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_product, parent, false);
        return new ProductHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ProductHolder productHolder = (ProductHolder) holder;
        productHolder.mItem_home_product_name.setText(list.get(position).getName());
        productHolder.mItem_home_product_price.setText("¥" + list.get(position).getPrice() + "");
        mImageLoader.displayImage(list.get(position).getImgUrl(), productHolder.mItem_home_product_image);
        if (list.get(position).getPromotionLabel().equals("")) {
            productHolder.mItem_home_product_reduce.setVisibility(View.GONE);
            productHolder.mItem_home_product_given.setVisibility(View.GONE);
        } else if (list.get(position).getPromotionLabel().equals("Reduce")) {
            productHolder.mItem_home_product_given.setVisibility(View.GONE);
        } else if (list.get(position).getPromotionLabel().equals("Given")) {
            productHolder.mItem_home_product_reduce.setVisibility(View.GONE);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ProductHolder extends RecyclerView.ViewHolder {

        private final TextView mItem_home_product_name;
        private final ImageView mItem_home_product_image;
        private final TextView mItem_home_product_price;
        private final TextView mItem_home_product_reduce;
        private final TextView mItem_home_product_given;

        public ProductHolder(View itemView) {
            super(itemView);
            mItem_home_product_name = (TextView) itemView.findViewById(R.id.item_home_product_name);
            mItem_home_product_image = (ImageView) itemView.findViewById(R.id.item_home_product_image);
            mItem_home_product_price = (TextView) itemView.findViewById(R.id.item_home_product_price);
            mItem_home_product_reduce = (TextView) itemView.findViewById(R.id.item_home_product_reduce);
            mItem_home_product_given = (TextView) itemView.findViewById(R.id.item_home_product_given);
        }

    }

}
