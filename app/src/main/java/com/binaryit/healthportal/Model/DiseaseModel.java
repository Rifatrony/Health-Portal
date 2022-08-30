package com.binaryit.healthportal.Model;

public class DiseaseModel {

    String diseaseName;
    int image;

    public DiseaseModel() {
    }

    public DiseaseModel(String diseaseName, int image) {
        this.diseaseName = diseaseName;
        this.image = image;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
