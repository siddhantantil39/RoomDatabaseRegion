package com.example.regionaldata;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface regionApi {
    @GET("europe")
    Call<List<model>> getAllRegions();
}
