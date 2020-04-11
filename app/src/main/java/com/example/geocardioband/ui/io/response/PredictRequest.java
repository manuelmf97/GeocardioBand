package com.example.geocardioband.ui.io.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PredictRequest {

    @SerializedName("male")
    @Expose
    private Integer male;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("currentSmoker")
    @Expose
    private Integer currentSmoker;
    @SerializedName("prevalentHyp")
    @Expose
    private Integer prevalentHyp;
    @SerializedName("totChol")
    @Expose
    private Double totChol;
    @SerializedName("BMI")
    @Expose
    private Double bMI;
    @SerializedName("heartRate")
    @Expose
    private Double heartRate;

    public Integer getMale() {
        return male;
    }

    public void setMale(Integer male) {
        this.male = male;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getCurrentSmoker() {
        return currentSmoker;
    }

    public void setCurrentSmoker(Integer currentSmoker) {
        this.currentSmoker = currentSmoker;
    }

    public Integer getPrevalentHyp() {
        return prevalentHyp;
    }

    public void setPrevalentHyp(Integer prevalentHyp) {
        this.prevalentHyp = prevalentHyp;
    }

    public Double getTotChol() {
        return totChol;
    }

    public void setTotChol(Double totChol) {
        this.totChol = totChol;
    }

    public Double getBMI() {
        return bMI;
    }

    public void setBMI(Double bMI) {
        this.bMI = bMI;
    }

    public Double getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Double heartRate) {
        this.heartRate = heartRate;
    }

    public PredictRequest(Integer male, Integer age, Integer currentSmoker, Integer prevalentHyp, Double totChol, Double bMI, Double heartRate) {
        this.male = male;
        this.age = age;
        this.currentSmoker = currentSmoker;
        this.prevalentHyp = prevalentHyp;
        this.totChol = totChol;
        this.bMI = bMI;
        this.heartRate = heartRate;
    }

    @Override
    public String toString() {
        return "PredictRequest{" +
                "male=" + male +
                ", age=" + age +
                ", currentSmoker=" + currentSmoker +
                ", prevalentHyp=" + prevalentHyp +
                ", totChol=" + totChol +
                ", bMI=" + bMI +
                ", heartRate=" + heartRate +
                '}';
    }
}
