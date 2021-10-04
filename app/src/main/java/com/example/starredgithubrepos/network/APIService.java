package com.example.starredgithubrepos.network;

import com.example.starredgithubrepos.models.Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("repositories?q=created:>2017-10-22&sort=stars&order=desc")
    Call<List<Repository>> getRepos();
}
