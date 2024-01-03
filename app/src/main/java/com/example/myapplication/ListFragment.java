package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapplication.databinding.FragmentListBinding;
import com.example.myapplication.model.Platform;
import com.example.myapplication.service.MainViewModel;

import java.util.List;

public class ListFragment extends Fragment {

    private FragmentListBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding =  FragmentListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MainViewModel mainViewModel = new ViewModelProvider(requireActivity())
                .get(MainViewModel.class);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        mainViewModel.getPlatforms().observe(getViewLifecycleOwner(), new Observer<List<Platform>>() {
            @Override
            public void onChanged(List<Platform> platforms) {
                binding.recyclerView.setAdapter(new PlatformAdapter(platforms));
            }
        });
    }
}
