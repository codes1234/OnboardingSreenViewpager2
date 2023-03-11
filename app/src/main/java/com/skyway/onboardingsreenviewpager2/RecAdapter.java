package com.skyway.onboardingsreenviewpager2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.skyway.onboardingsreenviewpager2.databinding.RecItemBinding;

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.exViewHolder> {
    ItemClickrdListner clickrdListner;
    private boolean isAllChecked = false;

    public RecAdapter(ItemClickrdListner clickrdListner) {
        this.clickrdListner = clickrdListner;
    }

    @NonNull
    @Override
    public RecAdapter.exViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new exViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecAdapter.exViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.binding.checkbox.setOnClickListener(v -> {
            clickrdListner.Clicked(position);
        });
        if (isAllChecked){
            holder.binding.checkbox.setChecked(true);
        }else {
            holder.binding.checkbox.setChecked(false);
        }
    }

    @Override
    public int getItemCount() {
        return 20;
    }
    public void setAllChecked(boolean checked){
        isAllChecked = checked;
        notifyDataSetChanged();
    }

    public class exViewHolder extends RecyclerView.ViewHolder {
        RecItemBinding binding;

        public exViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = RecItemBinding.bind(itemView);
        }
    }
}
