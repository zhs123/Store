package com.b1502.store2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.b1502.store2.R;
import com.b1502.store2.model.Product;

import java.util.ArrayList;

/**
 * 1. 主页产品适配器
 * 2. @author：liqingyi
 * 3. @date：2017/2/27 14:22
 */

public class HomeProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Product> list;
    private Context context;

    public HomeProductAdapter(Context context, ArrayList<Product> list) {
        this.context = context;
        this.list = list;
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

        public ProductHolder(View itemView) {
            super(itemView);

        }

    }

}
