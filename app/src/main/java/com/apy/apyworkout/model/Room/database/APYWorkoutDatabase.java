package com.apy.apyworkout.model.Room.database;

import android.content.Context;

import com.apy.apyworkout.model.Room.entities.Exercise;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class APYWorkoutDatabase {
    public static Single<List<Exercise>> getExercises(Context context) {
        return AppDatabase
                .getInstance(context)
                .getExerciseDAO()
                .getEntities()
                .subscribeOn(Schedulers.io()) // Execute query on another thread
                .observeOn(AndroidSchedulers.mainThread()); // Notify main thread

    }

    public static Completable insertExercise(Context context, Exercise exercise) {
        return AppDatabase
                .getInstance(context)
                .getExerciseDAO()
                .insertEntity(exercise)
                .subscribeOn(Schedulers.io()) // Execute query on another thread
                .observeOn(AndroidSchedulers.mainThread()); // Notify main thread
    }
}
