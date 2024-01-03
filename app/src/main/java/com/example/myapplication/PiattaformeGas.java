package com.example.myapplication;

import android.app.Application;

import com.example.myapplication.service.Repository;

public class PiattaformeGas extends Application {

    private Repository repository;
    @Override
    public void onCreate() {
        super.onCreate();

        repository = new Repository();
    }

    public Repository getRepository() {
        return repository;
    }
}
