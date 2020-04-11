package com.example.geocardioband.ui.io.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PredictResponse {

    @SerializedName("infarto")
    @Expose
    private Boolean infarto;
    @SerializedName("prob_infarto")
    @Expose
    private Double probInfarto;
    @SerializedName("prob_no_infarto")
    @Expose
    private Double probNoInfarto;

    public Boolean getInfarto() {
        return infarto;
    }

    public void setInfarto(Boolean infarto) {
        this.infarto = infarto;
    }

    public Double getProbInfarto() {
        return probInfarto;
    }

    public void setProbInfarto(Double probInfarto) {
        this.probInfarto = probInfarto;
    }

    public Double getProbNoInfarto() {
        return probNoInfarto;
    }

    public void setProbNoInfarto(Double probNoInfarto) {
        this.probNoInfarto = probNoInfarto;
    }

}
