package com.example.regionaldata;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

public class regionViewModel extends AndroidViewModel{
    private final regionRepository repository;
    public LiveData<List<model>>getAllRegions;

    public regionViewModel(@NonNull @org.jetbrains.annotations.NotNull Application application) {
        super(application);
        repository = new regionRepository(application);
        getAllRegions = repository.getAllRegions();

    }
    public  void insert(List<model> regions){

        repository.insert(regions);
    }

    public  LiveData<List<model>> getAllRegions() {

        return getAllRegions;
    }
}
