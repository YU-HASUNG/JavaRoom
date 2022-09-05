package com.example.myjavaroom;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface MainDao
{
    @Insert(onConflict = REPLACE)
    void insert(MainData mainData);

    @Delete
    void delete(MainData mainData);

    @Delete
    void reset(List<MainData> mainData);

    @Query("UPDATE players SET spid = :sText WHERE ID = :sID")
    void update(int sID, String sText);

    @Query("SELECT * FROM players")
    List<MainData> getAll();
}