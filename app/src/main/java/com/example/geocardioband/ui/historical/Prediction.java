package com.example.geocardioband.ui.historical;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Prediction {
    @PrimaryKey (autoGenerate = true)
    @NonNull
    private int mid;
    @ColumnInfo(name = "probability")
    private double probability;
    @ColumnInfo(name = "date")
    private String date;

    public Prediction(double probability, String date) {
        this.probability = probability;
        this.date = date;
    }
    @Ignore
    public Prediction(int mid, double probability, String date) {
        this.mid = mid;
        this.probability = probability;
        this.date = date;
    }

    public double getProbability(){
        return this.probability;
    }

    public String getDate(){
        return this.date;
    }


    public void setProbability(double _probability ){
        this.probability = _probability;
    }

    public void setDate(String _date){
        this.date = _date;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }
}
