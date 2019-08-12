//defining the interface to call the REST API for retrofit
//defining the endpoints

//takes your Java inputs and turn them into classes
//http://www.jsonschema2pojo.org/

//example type https://api.github.com/users/mugensan/repos in POSTMAN
//then copy/paste 2 pojo
//create package (model) + (add your package name in2 pojo)
//once you created the model you can get.Requests -> @GET

package com.example.tae_retrofit;

import com.example.tae_retrofit.model.GithubRepoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubClient {

//we want the name of the user to be dynamic ->{user}
    @GET("/users/{user}/repos")
//    then we need to pass the argument to allow the dynamic
    Call<List<GithubRepoModel>> getRepos(@Path("user")String user);

}
