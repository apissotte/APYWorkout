package com.apy.apyworkout.model.Room.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.apy.apyworkout.model.Room.entities.Exercise;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface ExerciseDAO {
    @Query("SELECT * FROM EXERCISE")
    Single<List<Exercise>> getEntities();

    @Insert
    Completable insertEntity(Exercise exercise);
}
