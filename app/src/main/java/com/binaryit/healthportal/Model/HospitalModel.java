package com.binaryit.healthportal.Model;

public class HospitalModel {

    String hospitalName, details, location;
    int image;
    boolean visibility;

    public HospitalModel(String hospitalName, String details, String location, int image) {
        this.hospitalName = hospitalName;
        this.details = details;
        this.location = location;
        this.image = image;
        this.visibility = false;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }
}
