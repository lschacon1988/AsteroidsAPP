package com.luischacon.asteroidsinfo.db.entities;


import com.google.gson.annotations.SerializedName;

public class NearEarthObject {
//    @SerializedName("id")
//    private long id;

    @SerializedName("name")
    private String name;

    @SerializedName("absolute_magnitude_h")
    private double absoluteMagnitudeH;

    @SerializedName("estimated_diameter_m")
    private double estimatedDiameterM;

    @SerializedName("is_potentially_hazardous_asteroid")
    private boolean isPotentiallyHazardousAsteroid;

    @SerializedName("first_observation_date")
    private String firstObservationDate;

    @SerializedName("last_observation_date")
    private String lastObservationDate;

    @SerializedName("user_id")
    private long userId;

    public NearEarthObject() {
    }

//    public long getId() {
//        return id;
//    }

//    public void setId(long id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAbsoluteMagnitudeH() {
        return absoluteMagnitudeH;
    }

    public void setAbsoluteMagnitudeH(double absoluteMagnitudeH) {
        this.absoluteMagnitudeH = absoluteMagnitudeH;
    }

    public double getEstimatedDiameterM() {
        return estimatedDiameterM;
    }

    public void setEstimatedDiameterM(double estimatedDiameterM) {
        this.estimatedDiameterM = estimatedDiameterM;
    }

    public boolean isPotentiallyHazardousAsteroid() {
        return isPotentiallyHazardousAsteroid;
    }

    public void setPotentiallyHazardousAsteroid(boolean potentiallyHazardousAsteroid) {
        isPotentiallyHazardousAsteroid = potentiallyHazardousAsteroid;
    }

    public String getFirstObservationDate() {
        return firstObservationDate;
    }

    public void setFirstObservationDate(String firstObservationDate) {
        this.firstObservationDate = firstObservationDate;
    }

    public String getLastObservationDate() {
        return lastObservationDate;
    }

    public void setLastObservationDate(String lastObservationDate) {
        this.lastObservationDate = lastObservationDate;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "NearEarthObject{" +

                ", name='" + name + '\'' +
                ", absoluteMagnitudeH=" + absoluteMagnitudeH +
                ", estimatedDiameterM=" + estimatedDiameterM +
                ", isPotentiallyHazardousAsteroid=" + isPotentiallyHazardousAsteroid +
                ", firstObservationDate='" + firstObservationDate + '\'' +
                ", lastObservationDate='" + lastObservationDate + '\'' +
                ", userId=" + userId +
                '}';
    }
}