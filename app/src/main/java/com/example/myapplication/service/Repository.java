package com.example.myapplication.service;

import android.content.Context;

import com.example.myapplication.service.Request;

public class Repository {


    public void downloadData(Context context, Request.RequestCallBack callBack) {
        Request.getInstance(context).requestDownload(callBack);
    }
}
