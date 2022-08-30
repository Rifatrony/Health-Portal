package com.binaryit.healthportal.Model;

public class DoctorModel {

    String name, qualification, specialist, chamber, appointment;
    int image;
    boolean visibility;

    public DoctorModel(String name, String qualification, String specialist, String chamber, String appointment, int image) {
        this.name = name;
        this.qualification = qualification;
        this.specialist = specialist;
        this.chamber = chamber;
        this.appointment = appointment;
        this.image = image;
        this.visibility = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public String getChamber() {
        return chamber;
    }

    public void setChamber(String chamber) {
        this.chamber = chamber;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
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
