package com.project.employeeso7.ui.view.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.employeeso7.R;
import com.project.employeeso7.model.googleCustomSearch.ItemsItem;

import java.util.List;

public class PublicProfileAdapter extends RecyclerView.Adapter<PublicProfileAdapter.PublicProfileViewHolder> {
    List<ItemsItem> searchList;

    public PublicProfileAdapter(List<ItemsItem> searchList) {
        this.searchList = searchList;
    }

    @NonNull
    @Override
    public PublicProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_search, parent, false);
        return new PublicProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PublicProfileViewHolder holder, int position) {
        ItemsItem currentItem = searchList.get(position);

        holder.title.setText(currentItem.getTitle());
        holder.link.setText(currentItem.getLink());
    }

    @Override
    public int getItemCount() {
        if (searchList.size() >= 5) {
            return 5;
        } else {
            return searchList.size();
        }
    }

    public class PublicProfileViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView link;

        public PublicProfileViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title);
            link = itemView.findViewById(R.id.tv_link);
        }
    }
}
