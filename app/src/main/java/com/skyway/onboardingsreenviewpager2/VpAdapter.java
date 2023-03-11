package com.skyway.onboardingsreenviewpager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.skyway.onboardingsreenviewpager2.databinding.VpItemBinding;

import java.util.ArrayList;

public class VpAdapter extends RecyclerView.Adapter<VpAdapter.exViewHolder> {
    ArrayList<VpModel> list;

    public VpAdapter(ArrayList<VpModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public VpAdapter.exViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new exViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.vp_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VpAdapter.exViewHolder holder, int position) {
        holder.binding.imageView.setImageResource(list.get(position).getImage());
        holder.binding.textView.setText(list.get(position).heading);
        holder.binding.textView2.setText(list.get(position).description);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class exViewHolder extends RecyclerView.ViewHolder {
        VpItemBinding binding;

        public exViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = VpItemBinding.bind(itemView);
        }
    }
}
