package com.example.tae_retrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tae_retrofit.model.GithubRepoModel;
import com.example.tae_retrofit.model.Owner;

import java.util.List;

import retrofit2.Call;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepoViewHolder> {

    private List<GithubRepoModel> repos;

    public RepoAdapter(List<GithubRepoModel> repos) {
        this.repos = repos;
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.repo_item_layout,parent,false);
        return new RepoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
        Owner owner = repos.get(position).getOwner();
        holder.tv_name.setText(repos.get(position).getName());
        holder.tv_owner_login.setText(owner.getLogin());
        holder.tv_id.setText(""+owner.getId());

        //TODO
        //understand how and where to get the info cause you got it WRONG!!!!



    }



    @Override
    public int getItemCount() {
        return repos.size();
    }

    public class RepoViewHolder extends RecyclerView.ViewHolder implements GitHubClient {

        public TextView tv_name;
        public TextView tv_owner_login;
        public TextView tv_id;

        public RepoViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_owner_login = itemView.findViewById(R.id.tv_owner_login);
            tv_id = itemView.findViewById(R.id.tv_id);
        }

        @Override
        public Call<List<GithubRepoModel>> getRepos(String user) {
            return getRepos(user);
        }
    }
}
