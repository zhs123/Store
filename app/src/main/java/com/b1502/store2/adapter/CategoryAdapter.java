package com.b1502.store2.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.b1502.store2.R;
import com.b1502.store2.activity.CategoryActivity;
import com.b1502.store2.bean.CategoryBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：张贤伟
 * 说明：分类界面的适配器
 */


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private List<CategoryBean> list = new ArrayList<>();
    private Context context;

    public CategoryAdapter(List<CategoryBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.categoryitem, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.name.setText(list.get(position).getName());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CategoryActivity.class);
                intent.putExtra("name", list.get(position).getName());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.categoryitem_name);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.categoryitem_lin);
        }
    }
}
