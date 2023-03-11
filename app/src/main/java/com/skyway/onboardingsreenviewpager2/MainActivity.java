package com.skyway.onboardingsreenviewpager2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.skyway.onboardingsreenviewpager2.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayList<VpModel> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();

        int[] image = {R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3};

        String[] heading = {"skdj","dghijgdgs","sdgjidsds"};
        String[] description = {"slkdjgwiej","sjdojowejgwej","sjdijfiwoejgweo"};

        for (int i=0;i<image.length;i++){
            VpModel model= new VpModel(image[i],heading[i],description[i]);
            list.add(model);
        }

        VpAdapter adapter= new VpAdapter(list);
        binding.viewpager2.setAdapter(adapter);

        binding.nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.viewpager2.getCurrentItem() == image.length - 1){
                    startActivity(new Intent(MainActivity.this,SellectAllItemRecyclerview.class));
                }else {
                    binding.viewpager2.setCurrentItem(binding.viewpager2.getCurrentItem()+1);

                }
            }
        });
        binding.previousBtn.setOnClickListener(v -> {
            binding.viewpager2.setCurrentItem(binding.viewpager2.getCurrentItem()-1);
        });
        binding.skiptext.setOnClickListener(v -> {
            startActivity(new Intent(this,SellectAllItemRecyclerview.class));
        });

    }
}