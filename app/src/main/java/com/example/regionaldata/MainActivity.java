package com.example.regionaldata;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private regionViewModel regionViewModel;
    private List<model> regions;
    private regionAdapter regionAdapter;
    private RecyclerView recyclerView;
    private regionRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeRequest();

       repository = new regionRepository(getApplication());
       regions = new ArrayList<>();
       recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
       recyclerView.setLayoutManager(new LinearLayoutManager(this));
       recyclerView.setHasFixedSize(true);
       regionViewModel = new ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(regionViewModel.class);
       regionAdapter = new regionAdapter(this,regions);
        //important
        regionViewModel.getAllRegions().observe(this, new Observer<List<model>>() {
            @Override
            public void onChanged(List<model> regions) {
                recyclerView.setAdapter(regionAdapter);
                regionAdapter.setAllRegions(regions);
                Log.d("main", "viewModelOnChanged:"+regions);
            }
        });
    }

    private  void makeRequest(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://restcountries.eu/rest/v2/region/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        regionApi api = retrofit.create(regionApi.class);
        Call<List<model>> call = api.getAllRegions();
        call.enqueue(new Callback<List<model>>() {
            @Override
            public void onResponse(@NotNull Call<List<model>> call, Response<List<model>> response) {
                if(response.isSuccessful()) {
                    Log.d("main", "onChanged:"+response.body());

                  repository.insert(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<model>> call, Throwable t) {
                Log.d("main", "onChanged:"+regions);

                Toast.makeText(MainActivity.this,"SOMETHING IS WRONG",Toast.LENGTH_LONG).show();
            }
        });
    }

}