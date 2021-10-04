package com.example.starredgithubrepos.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.starredgithubrepos.models.Repository;
import com.example.starredgithubrepos.network.APIService;
import com.example.starredgithubrepos.network.RetroInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepoViewModel {

    private final APIService apiService;
//    private MutableLiveData<List<Repository>> mRepoList;

    public RepoViewModel() {
        apiService = RetroInstance.getRetroClient().create(APIService.class);
//        mRepoList = new MutableLiveData<>();
    }

    final MutableLiveData<List<Repository>> getRepoData = new MutableLiveData<>();

//    public MutableLiveData<List<Repository>> getRepoListObserver() {
//        return mRepoList;
//    }

    public LiveData<List<Repository>> getReposObserver() {
        getHomeOrders();
        return getRepoData;
    }

    public void getHomeOrders() {
        Call<List<Repository>> call = apiService.getRepos();
        call.enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                getRepoData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {
                Log.i("Home Orders Response", t.getMessage());
            }
        });
    }

//    public void getTrendingRepos() {
//        Call<List<Repository>> call = apiService.getRepos();
//        call.enqueue(new Callback<List<Repository>>() {
//            @Override
//            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
//                mRepoList.postValue(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<List<Repository>> call, Throwable t) {
//                mRepoList.postValue(null);
//                Log.i("Response: ", t.getMessage());
//            }
//        });
//    }

}
