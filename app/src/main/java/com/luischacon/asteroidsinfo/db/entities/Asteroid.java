package com.luischacon.asteroidsinfo.db.entities;

import com.google.gson.annotations.SerializedName;

public class Asteroid {
    public String id;
    public String name;
//    public Double absoluteMagnitudeH;
//    public Double estimatedDiameterMeters;
//    public Boolean isPotentiallyHazardousAsteroid;
//    public String firstObservationDate;
//    public String lastObservationDate;

    public Asteroid() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
