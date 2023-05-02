package com.luischacon.asteroidsinfo.modelClass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AsteroidsFetchList {
    @SerializedName("near_earth_objects")
    @Expose
    private ArrayList results;

    public ArrayList getResults() {
        return results;
    }
}

