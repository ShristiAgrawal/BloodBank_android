package com.shristi.BloodBank.Services;

import com.shristi.BloodBank.Models.DonorDetails;

import com.google.gson.annotations.Expose;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitService {
    //@GET("")

    // Call <List<RetroPhoto>> getphoto();
   // String API_ROUTE = "Apositive/";
    @Headers({

            "Content-type: application/json"

    })
    @POST("{bloodgroup}/")
    Call<DonorDetails> sendPosts(@Path ("bloodgroup") String bloodgroup,@Body DonorDetails posts);
}
