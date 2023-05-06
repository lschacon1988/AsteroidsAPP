package com.luischacon.asteroidsinfo.db.entities;

public class Asteroit {

    private Integer _id;
    private String name;
    private Float absolute_magnitude_h;
    private Float estimated_diameter_m;
    private Integer is_potentially_hazardous_asteroid;
    private String first_observation_date;
    private String last_observation_date;
    private Integer user_id;


    public Asteroit() {
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getAbsolute_magnitude_h() {
        return absolute_magnitude_h;
    }

    public void setAbsolute_magnitude_h(Float absolute_magnitude_h) {
        this.absolute_magnitude_h = absolute_magnitude_h;
    }

    public Float getEstimated_diameter_m() {
        return estimated_diameter_m;
    }

    public void setEstimated_diameter_m(Float estimated_diameter_m) {
        this.estimated_diameter_m = estimated_diameter_m;
    }

    public Integer getIs_potentially_hazardous_asteroid() {
        return is_potentially_hazardous_asteroid;
    }

    public void setIs_potentially_hazardous_asteroid(Integer is_potentially_hazardous_asteroid) {
        this.is_potentially_hazardous_asteroid = is_potentially_hazardous_asteroid;
    }

    public String getFirst_observation_date() {
        return first_observation_date;
    }

    public void setFirst_observation_date(String first_observation_date) {
        this.first_observation_date = first_observation_date;
    }

    public String getLast_observation_date() {
        return last_observation_date;
    }

    public void setLast_observation_date(String last_observation_date) {
        this.last_observation_date = last_observation_date;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Asteroit{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", absolute_magnitude_h=" + absolute_magnitude_h +
                ", estimated_diameter_m=" + estimated_diameter_m +
                ", is_potentially_hazardous_asteroid=" + is_potentially_hazardous_asteroid +
                ", first_observation_date='" + first_observation_date + '\'' +
                ", last_observation_date='" + last_observation_date + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
