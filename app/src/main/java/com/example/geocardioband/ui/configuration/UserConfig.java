package com.example.geocardioband.ui.configuration;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserConfig {
    // User configuration stored in database
    @PrimaryKey
    @NonNull
    private int mid;
    @ColumnInfo(name = "age")
    private String age;
    @ColumnInfo(name = "cholesterol")
    private String cholesterol;
    @ColumnInfo(name = "bmi")
    private String bmi;
    @ColumnInfo(name = "sex")
    private String sex;
    @ColumnInfo(name = "smoker")
    private Boolean smoker;
    @ColumnInfo(name = "hypertension")
    private Boolean hypertension;

    public UserConfig(int mid, String age, String cholesterol, String bmi, String sex, Boolean smoker, Boolean hypertension) {
        this.mid = mid;
        this.age = age;
        this.cholesterol = cholesterol;
        this.bmi = bmi;
        this.sex = sex;
        this.smoker = smoker;
        this.hypertension = hypertension;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(String cholesterol) {
        this.cholesterol = cholesterol;
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Boolean getSmoker() {
        return smoker;
    }

    public void setSmoker(Boolean smoker) {
        this.smoker = smoker;
    }

    public Boolean getHypertension() {
        return hypertension;
    }

    public void setHypertension(Boolean hypertension) {
        this.hypertension = hypertension;
    }

    @Override
    public String toString() {
        return "UserConfig{" +
                "mid=" + mid +
                ", age='" + age + '\'' +
                ", cholesterol='" + cholesterol + '\'' +
                ", bmi='" + bmi + '\'' +
                ", sex='" + sex + '\'' +
                ", smoker=" + smoker +
                ", hypertension=" + hypertension +
                '}';
    }
}
