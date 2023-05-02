package com.luischacon.asteroidsinfo.db.entities;


import com.google.gson.annotations.SerializedName;

public class NearEarthObject {
//    @SerializedName("id")
//    private long id;

    @SerializedName("name")
    private String name;

    @SerializedName("absolute_magnitude_h")
    private Double absoluteMagnitudeH;

    @SerializedName("estimated_diameter")
    private EstimatedDiameter estimatedDiameterM;

    @SerializedName("is_potentially_hazardous_asteroid")
    private Boolean isPotentiallyHazardousAsteroid;

    @SerializedName("first_observation_date")
    private String firstObservationDate;

    @SerializedName("last_observation_date")
    private String lastObservationDate;

    @SerializedName("user_id")
    private Integer userId;

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

    public EstimatedDiameter getEstimated_diameter() {
        return estimatedDiameterM;
    }

    public void setEstimatedDiameterM(EstimatedDiameter estimatedDiameterM) {
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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