package com.binaryit.healthportal.Model;

public class DiagnosticModel {

    String name, details, location, number;
    int image;
    boolean visibility;

    public DiagnosticModel() {
    }

    public DiagnosticModel(String name, String details, String location, String number, int image) {
        this.name = name;
        this.details = details;
        this.location = location;
        this.number = number;
        this.image = image;
        this.visibility = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
