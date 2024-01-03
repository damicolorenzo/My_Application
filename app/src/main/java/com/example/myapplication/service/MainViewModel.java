package com.example.myapplication.service;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.PiattaformeGas;
import com.example.myapplication.database.DB;
import com.example.myapplication.model.Platform;

import org.chromium.net.CronetException;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private Repository repository;

    private MutableLiveData<List<Platform>> platforms = new MutableLiveData<>();
    public MainViewModel(@NonNull Application application) {
        super(application);

        repository = ((PiattaformeGas) application).getRepository();
        List<Platform> list = DB.getInstance(application).getPlatformDao().findAll();

        if (list.isEmpty()) {
            repository.downloadData(application, new Request.RequestCallBack() {
                @Override
                public void onCompleted(UrlRequest request, UrlResponseInfo info, byte[] data, CronetException error) {

                    List<Platform> tempPlatforms = new ArrayList<>();

                    if (data != null) {
                        String response = new String(data);
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject item = array.optJSONObject(i);
                                Platform platform = Platform.parseJSon(item);
                                if (platform != null) tempPlatforms.add(platform);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    } else {
                        if (error != null) {
                            error.printStackTrace();
                        }
                    }
                    DB.getInstance(getApplication()).getPlatformDao().insert(tempPlatforms);
                    platforms.postValue(tempPlatforms);
                }
            });
        } else {
            platforms.setValue(list);
        }
    }

    public LiveData<List<Platform>> getPlatforms() {
        return platforms;
    }
}
