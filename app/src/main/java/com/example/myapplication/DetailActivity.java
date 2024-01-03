package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityDetailBinding;
import com.example.myapplication.model.Platform;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_PLATFORM = "extra_platform";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityDetailBinding binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Platform platform = (Platform) getIntent().getSerializableExtra(EXTRA_PLATFORM);
        if (platform != null) {
            binding.setPlatform(platform);
        }
    }
}
