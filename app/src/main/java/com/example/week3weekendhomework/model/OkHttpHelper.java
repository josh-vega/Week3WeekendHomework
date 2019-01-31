package com.example.week3weekendhomework.model;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpHelper {

    public static void asyncOkHttpApiCall(String url){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            String jsonResponse;
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG", "onFailure: ", e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                jsonResponse = response.body().string();
                Gson gson = new Gson();
            }
        });
    }

    public static void syncOkHttpApiCall(String url){
        final OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder().url(url).build();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Response response = okHttpClient.newCall(request).execute();
                    String jsonResponse = response.body().string();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
