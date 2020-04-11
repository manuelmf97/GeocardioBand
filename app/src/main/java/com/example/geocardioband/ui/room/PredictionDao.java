package com.example.geocardioband.ui.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.geocardioband.ui.historical.Prediction;

import java.util.List;

@Dao
public interface PredictionDao {
    @Query("SELECT * FROM Prediction ORDER BY date DESC")
    List<Prediction> getAll();

    @Insert
    void insertPrediction(Prediction prediction);
}
