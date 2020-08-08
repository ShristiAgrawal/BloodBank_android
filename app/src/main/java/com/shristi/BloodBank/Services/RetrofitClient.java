package com.shristi.BloodBank.Services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;
    private static String base_url="https://bloodbank-sa.herokuapp.com/";

    public static Retrofit getinstance(){
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
        //  if(retrofit==null)
        //    retrofit=new retrofit2.Retrofit.Builder().baseUrl(base_url).addConverterFactory(new GsonConverterFactory().create()).build();
    }
}
