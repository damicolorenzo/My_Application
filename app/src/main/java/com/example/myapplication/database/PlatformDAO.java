package com.example.myapplication.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.myapplication.model.Platform;

import java.util.List;

@Dao
public interface PlatformDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(List<Platform> data);

    @Delete
    public void deleteAll();

    @Query("SELECT * FROM platforms ORDER BY denominazione DESC")
    public List<Platform> findAll();
}
