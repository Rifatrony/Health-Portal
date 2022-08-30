package com.binaryit.healthportal.Model;

public class PharmacyModel {

    String pharmacyName, time, address, number;
    int image;
    boolean visibility;

    public PharmacyModel() {
    }

    public PharmacyModel(String pharmacyName, String time, String address, String number, int image) {
        this.pharmacyName = pharmacyName;
        this.time = time;
        this.address = address;
        this.number = number;
        this.image = image;
        this.visibility = false;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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
