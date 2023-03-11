package com.skyway.onboardingsreenviewpager2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.skyway.onboardingsreenviewpager2.databinding.ActivitySellectAllItemRecyclerviewBinding;

public class SellectAllItemRecyclerview extends AppCompatActivity {
    ActivitySellectAllItemRecyclerviewBinding binding;
    RecAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySellectAllItemRecyclerviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter= new RecAdapter(new ItemClickrdListner() {
            @Override
            public void Clicked(int pos) {
                Toast.makeText(SellectAllItemRecyclerview.this, "Hii" + pos, Toast.LENGTH_SHORT).show();

            }
        });
        binding.recview.setHasFixedSize(true);
        binding.recview.setAdapter(adapter);

        binding.checkboxselectall.setOnClickListener(v -> {
            if (binding.checkboxselectall.isChecked()) {
                adapter.setAllChecked(true); // to check all items
            }else {
                adapter.setAllChecked(false);// to uncheck all items

            }
        });


    }
}