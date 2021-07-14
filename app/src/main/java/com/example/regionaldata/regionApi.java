package com.example.regionaldata;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface regionApi {
    @GET("asia")
    Call<List<model>> getAllRegions();
}
