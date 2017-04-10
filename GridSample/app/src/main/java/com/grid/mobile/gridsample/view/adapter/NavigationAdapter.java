package com.grid.mobile.gridsample.view.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.grid.mobile.gridsample.R;
import com.grid.mobile.gridsample.model.Data;

import java.util.List;

/**
 * Created by Mobile on 4/7/2017.
 */

public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.ViewHolder> {

    private final Activity activity;
    private final List<Data> navigationPropList;
    public OnItemClickListener mItemClickListener;


    public NavigationAdapter(Activity activity, List<Data> navigationPropList) {
        this.activity = activity;
        this.navigationPropList = navigationPropList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_navigation, null);
        ViewHolder viewholder = new ViewHolder(view);
        return viewholder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textViewCategoryName.setText(navigationPropList.get(position).getName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    mItemClickListener.onItemClick(v, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return navigationPropList.size();
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewCategoryName;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewCategoryName = (TextView) itemView.findViewById(R.id.textViewCategoryName);
        }
    }



}
