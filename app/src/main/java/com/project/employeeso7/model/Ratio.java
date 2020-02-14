package com.project.employeeso7.model;

public class Ratio {
    float male_ratio;
    float female_ratio;

    public Ratio(float male_ratio, float female_ratio) {
        this.male_ratio = male_ratio;
        this.female_ratio = female_ratio;
    }

    public float getMale_ratio() {
        return male_ratio;
    }

    public void setMale_ratio(float male_ratio) {
        this.male_ratio = male_ratio;
    }

    public float getFemale_ratio() {
        return female_ratio;
    }

    public void setFemale_ratio(float female_ratio) {
        this.female_ratio = female_ratio;
    }
}
