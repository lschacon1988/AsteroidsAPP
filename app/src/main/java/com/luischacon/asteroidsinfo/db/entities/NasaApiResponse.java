package com.luischacon.asteroidsinfo.db.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class NasaApiResponse {
    @SerializedName("element_count")
    private int elementCount;
    @SerializedName("near_earth_objects")
    private Map<String, List<NearEarthObject>> nearEarthObjects;

    public int getElementCount() {
        return elementCount;
    }

    public void setElementCount(int elementCount) {
        this.elementCount = elementCount;
    }

    public Map<String, List<NearEarthObject>> getNearEarthObjects() {
        return nearEarthObjects;
    }

    public void setNearEarthObjects(Map<String, List<NearEarthObject>> nearEarthObjects) {
        this.nearEarthObjects = nearEarthObjects;
    }
}
