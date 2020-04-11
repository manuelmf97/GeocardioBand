package com.example.geocardioband.ui.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.geocardioband.ui.configuration.UserConfig;

/**
 * Interface for DB access
 */
@Dao
public interface UserConfigDao {
    @Query("SELECT * FROM UserConfig WHERE mid LIKE :uuid LIMIT 1")
    UserConfig getUserConfig(int uuid);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addUserConfig(UserConfig userConfig);

    @Delete
    void deleteUserConfig(UserConfig userConfig);

    @Update
    void updateUserConfig(UserConfig userConfig);
}
