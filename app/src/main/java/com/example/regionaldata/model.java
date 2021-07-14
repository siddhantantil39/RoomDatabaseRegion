package com.example.regionaldata;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

//for use of serialized names to avoid confusion
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

@Entity(tableName = "regionImg")

public class model {
    @PrimaryKey@NonNull
    @SerializedName("name")
    @ColumnInfo(name = "name")
    String name;

    @SerializedName("flag")
    @ColumnInfo(name = "image")
    String flag;

    @SerializedName("capital")
    @ColumnInfo(name = "capital")
    String capital;

    @SerializedName("region")
    @ColumnInfo(name = "region")
    String region;

    @SerializedName("subregion")
    @ColumnInfo(name = "subregion")
    String subregion;

    @SerializedName("population")
    @ColumnInfo(name = "population")
    String population;

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }
}
