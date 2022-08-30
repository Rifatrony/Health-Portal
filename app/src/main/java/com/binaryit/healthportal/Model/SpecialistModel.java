package com.binaryit.healthportal.Model;

public class SpecialistModel {

    String categoryName;
    int image;

    public SpecialistModel() {
    }

    public SpecialistModel(String categoryName, int image) {
        this.categoryName = categoryName;
        this.image = image;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


}
