package com.example.regionaldata;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import java.util.List;

public class regionRepository {
    public LiveData<List<model>>getRegions;
    private final RegionDatabase database;

    public regionRepository(Application application){
        database = RegionDatabase.getInstance(application);
        getRegions = database.regionImgDao().getAllRegions();
        Log.d("main", "PersonRepository: " + getRegions);

    }

    public void insert(List<model> regions){

        new InsertAsyncTask(database).execute(regions);
    }


    public LiveData<List<model>>getAllRegions() {
        return getRegions;
    }

     static class InsertAsyncTask extends AsyncTask<List<model>,Void,Void>{
        private final regionImgDao regionImgDao;

        public InsertAsyncTask(RegionDatabase regionDatabase)
        {
            regionImgDao=regionDatabase.regionImgDao();
        }
        @SafeVarargs
        @Override
        protected final Void doInBackground(List<model>... lists) {
            regionImgDao.insert(lists[0]);
            return null;
        }
    }
}
