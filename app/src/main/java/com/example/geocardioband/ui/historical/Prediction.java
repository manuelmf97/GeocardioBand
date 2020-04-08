package com.example.geocardioband.ui.historical;

public class Prediction {
    private int probability;
    private String date;

    public Prediction(int _probability, String _date){
        this.probability = _probability;
        this.date = _date;

    }

    public int getProbability(){
        return this.probability;
    }

    public String getDate(){
        return this.date;
    }


    public void setProbability(int _probability ){
        this.probability = _probability;
    }

    public void setDate(String _date){
        this.date = _date;
    }

}
