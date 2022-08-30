package com.binaryit.healthportal.Model;

public class DiseaseModel {

    String diseaseName, causes, symptoms, treatment;
    int image;
    boolean visibility;

    public DiseaseModel() {
    }

    public DiseaseModel(String diseaseName, String causes, String symptoms, String treatment, int image) {
        this.diseaseName = diseaseName;
        this.causes = causes;
        this.symptoms = symptoms;
        this.treatment = treatment;
        this.image = image;
        this.visibility = false;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getCauses() {
        return causes;
    }

    public void setCauses(String causes) {
        this.causes = causes;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
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
