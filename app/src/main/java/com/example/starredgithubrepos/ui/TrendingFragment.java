package com.example.starredgithubrepos.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.starredgithubrepos.R;
import com.example.starredgithubrepos.adapters.RepoAdapter;
import com.example.starredgithubrepos.models.Repository;
import com.example.starredgithubrepos.viewmodels.RepoViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TrendingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrendingFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private List<Repository> repoList;
    private RepoViewModel mRepoViewModel;
    private RepoAdapter adapter;

    public TrendingFragment() {
        // Required empty public constructor
    }

    public static TrendingFragment newInstance(String param1, String param2) {
        TrendingFragment fragment = new TrendingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_trending, container, false);
        setupVariables(view);
        getRepos();
        return view;
    }

    void setupVariables(View view) {
        recyclerView = view.findViewById(R.id.recycler_view);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        adapter = new RepoAdapter(getActivity(), repoList);
//        recyclerView.setAdapter(adapter);
    }

    void getRepos() {
//        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RepoAdapter(getActivity(), repoList);
        recyclerView.setAdapter(adapter);

//        ViewModelProvider.Factory factory = new ViewModelProvider.NewInstanceFactory();
//        mRepoViewModel = new ViewModelProvider(this, factory).get(RepoViewModel.class);

        ViewModelProvider.Factory factory = new ViewModelProvider.NewInstanceFactory();
        mRepoViewModel = new ViewModelProvider(this, factory).get(RepoViewModel.class);
        RepoViewModel viewModel = new ViewModelProvider(this, factory).get(RepoViewModel.class);

        mRepoViewModel.getReposObserver().observe(this, new Observer<List<Repository>>() {
            @Override
            public void onChanged(List<Repository> repositories) {
                repositories = repoList;
                adapter.notifyDataSetChanged();
                adapter.setReposList(repoList);
            }
        });

    }
}