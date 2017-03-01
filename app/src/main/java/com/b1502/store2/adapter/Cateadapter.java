package com.b1502.store2.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.b1502.store2.R;
import com.b1502.store2.bean.CatBean_;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者： 张贤伟
 * 时间： 2017/2/28 19:03
 * 类描述：
 */
public class Cateadapter extends RecyclerView.Adapter<Cateadapter.ViewHolder> {
    private List<CatBean_.ProductsEntity> list = new ArrayList<>();

    public Cateadapter(List<CatBean_.ProductsEntity> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_twoitem, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.price.setText("¥ " + list.get(position).getPrice());
//        holder.name.setText(list.get(position).getProducts().get(position).getName());
//        holder.price.setText(list.get(position).getPrice() + "");


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, price;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.categorytwoitem_name);
            price = (TextView) itemView.findViewById(R.id.categorytwoitem_price);
            imageView = (ImageView) itemView.findViewById(R.id.categorytwoitem_image);
        }
    }
}
