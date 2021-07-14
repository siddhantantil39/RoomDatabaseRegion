package com.example.regionaldata;

import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {model.class}, version = 1, exportSchema = false)

public abstract class RegionDatabase extends RoomDatabase{
    private  static  final String DATABASE_NAME = "region";
    public  abstract regionImgDao regionImgDao();
    public  static  volatile  RegionDatabase INSTANCE;

    public static  RegionDatabase getInstance(Context context)
    {
        if (INSTANCE == null){
            synchronized(RegionDatabase.class){
                if (INSTANCE ==null){
                    Room.databaseBuilder(context,RegionDatabase.class, DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            .addCallback(callback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    //callback method to a SQLIte DB
    public static Callback callback = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new  PopulateDbAsyn(INSTANCE);
        }
    };

    static  class PopulateDbAsyn extends AsyncTask<Void,Void,Void>{
        private final regionImgDao regionImgDao;
        PopulateDbAsyn(RegionDatabase regionDatabase){
            regionImgDao=regionDatabase.regionImgDao();
            //super important
        }

        @Override
        protected Void doInBackground(Void... voids) {
            regionImgDao.deleteAll();
            return null;
        }
    }


}
