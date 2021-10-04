package com.example.starredgithubrepos.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstance {

    private final static String API_BASE_URL = "https://api.github.com/search/";

    private static Retrofit repoRetrofit;
    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();


    public static Retrofit getRetroClient() {
        if (repoRetrofit == null) {
            repoRetrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return repoRetrofit;
    }

}
