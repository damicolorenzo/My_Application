package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE id IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE username = :userName AND password = :password")
    List<User> findByUserPass(String userName, String password);

    @Insert(onConflict = OnConflictStrategy.NONE)
    void insertUsers(User users);

    @Update
    void updateUsers(User user);

    @Delete
    void deleteUsers(User user);

}