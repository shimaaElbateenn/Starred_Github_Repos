package com.example.starredgithubrepos.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starredgithubrepos.R;
import com.example.starredgithubrepos.models.Repository;
import com.example.starredgithubrepos.viewmodels.RepoViewModel;

import java.util.List;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepoViewHolder>{

    private Context mContext;
    private List<Repository> repoList;
    private RepoViewModel reposViewModel;
    private Bitmap bitmap;


    public RepoAdapter(Context mContext, List<Repository> repoList) {
        this.mContext = mContext;
        this.repoList = repoList;
        this.bitmap = bitmap;
    }

    public void setReposList(List<Repository> orderList) {
        this.repoList = orderList;
        notifyDataSetChanged();
    }

    public void setRepossBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RepoAdapter.RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.repo_item, parent, false);
        return new RepoAdapter.RepoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoAdapter.RepoViewHolder holder, int position) {
        Repository model = repoList.get(position);
        holder.repoName.setText(model.getRepoName());
        holder.repoDesc.setText(model.getRepoDesc());
        holder.repoOwner.setText(model.getRepoOwner());
        holder.star_numbers.setText(model.getStarNumbers());

//        String id = model.getOrderId();
//        String url = "https://waset-order-service.herokuapp.com/order/" + id + "/photo";
//
//        holder.orderImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
//
//        Picasso.get()
//                .load(url)
//                .resize(240, 120)
//                .centerInside()
//                .into(holder.orderImage);

    }



    @Override
    public int getItemCount() {
        Log.e("size", String.valueOf(repoList.size()));
        if (this.repoList != null) {
            return this.repoList.size();
        }
        return 0;
    }

    void getOrderPhoto(String id) {


    }

    public class RepoViewHolder extends RecyclerView.ViewHolder {
        TextView repoName;
        TextView repoDesc;
        TextView repoOwner;
        TextView star_numbers;
        ImageView repoImg;

        public RepoViewHolder(View view) {
            super(view);

            repoName = view.findViewById(R.id.repoName);
            repoDesc = view.findViewById(R.id.repoDesc);
            repoOwner = view.findViewById(R.id.repoOwner);
            star_numbers = view.findViewById(R.id.star_numbers);
            repoImg = view.findViewById(R.id.repoImg);

        }

    }
}
