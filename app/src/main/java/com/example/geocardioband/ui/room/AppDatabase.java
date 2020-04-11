package com.example.geocardioband.ui.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.geocardioband.ui.configuration.UserConfig;
import com.example.geocardioband.ui.historical.Prediction;

@Database(entities = {UserConfig.class, Prediction.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserConfigDao UserConfigDao();
    public abstract PredictionDao PredictionDao();
}
