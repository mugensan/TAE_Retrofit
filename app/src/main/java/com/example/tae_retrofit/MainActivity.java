/*******************************************************************
 * RETROFIT - 3RD PARTY LIBRARY FOR API CALLS
 * WILL HANDLE THE CONVERSION OF JSON TO GSON
 * ALSO HANDLE'S CONNECTIONS, THREADING, PARSING, ETC
 * TO BE USED ALONG POSTMAN
 * API TO BE CREATED IN DEPENDENCIES
 *
 * don't forget to add permission in the manifest
 *
 * https://www.vogella.com/tutorials/Retrofit/article.html
 *
 * https://developer.github.com/v3/
 *
 * //    write the latest version to be used in gradle (app),
 * //    is where we allow our project to access the REST API RETROFIT
 * //    second step Define the API and the Retrofit adapter
 * //    then define the interface to call the REST API for retrofit
 * //    then create class controller
 * //    now you can create your object on the main
 *
 * you also have to create your new package to be better readable and to find for other devs
 *******************************************************************/

package com.example.tae_retrofit;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tae_retrofit.model.GithubRepoModel;
import com.example.tae_retrofit.model.Owner;
import com.example.tae_retrofit.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private RecyclerView rv_repo_list;
    private RepoAdapter repoAdapter;
    private List<GithubRepoModel> repos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_repo_list = findViewById(R.id.rv_repo_list);




        //this is the result call from all we did
        GitHubClient gitHubClient = RetrofitInstance.getRetrofitInstance().create(GitHubClient.class);
        //returning the call
        Call<List<GithubRepoModel>> call = gitHubClient.getRepos("mugensan");
        //now using call to make the API call
        //enqueue creates a new Thread automatically YOY
        call.enqueue(new Callback<List<GithubRepoModel>>() {
            @Override
            //onResponse == success
            public void onResponse(Call<List<GithubRepoModel>> call, Response<List<GithubRepoModel>> response) {
                //need to display
                 repos = response.body();
                repoAdapter = new RepoAdapter(repos);

                LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                rv_repo_list.setLayoutManager(layoutManager);
                rv_repo_list.setAdapter(repoAdapter);

                if (repos != null) {
                    for (int i = 0; i < repos.size(); i++) {
                        //hardcoding the display on the Logcat
                        Log.i("MainActivity", "onResponse: " + repos.get(i).getFullName());

//                        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(imageView);

                    }
                }



            }

            @Override
            public void onFailure(Call<List<GithubRepoModel>> call, Throwable t) {

            }
        });

    }


}
