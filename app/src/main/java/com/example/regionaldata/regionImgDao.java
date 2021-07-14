package com.example.regionaldata;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;


@Dao
public interface regionImgDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<model> regions);

    @Query("SELECT  * FROM regionImg")
    LiveData<List<model>> getAllRegions();

    @Query("DELETE FROM regionImg")
    void deleteAll();
}
