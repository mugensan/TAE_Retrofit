package com.example.tae_retrofit.network;

import com.example.tae_retrofit.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance(){
        //initialize the retrofit var
        if(retrofit == null){
            //do something
            retrofit = new Retrofit.Builder()
                    //NEED TO CONCATINATE THE BASE_URL
                    .baseUrl(Constants.BASE_URL)
                    //NOW NEED TO CONVERT TO GSON
                    .addConverterFactory(GsonConverterFactory.create())
                    //FOR IT TO WORK NEED TO CLOSE IT
                    .build();

        }

        return retrofit;
    }
}
