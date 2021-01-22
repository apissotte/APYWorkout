package com.apy.apyworkout.ui.exerciseDetail;

import android.util.Log;
import android.view.View;

import com.apy.apyworkout.model.Room.database.APYWorkoutDatabase;
import com.apy.apyworkout.model.Room.entities.Exercise;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableCompletableObserver;

public class ExerciseDetailViewPresenter {
    private static final String TAG = "ExerciseDetailViewPrese";

    public void onClickExerciseButton(View view, Exercise exercise) {
        APYWorkoutDatabase.insertExercise(view.getContext(), exercise)
                .subscribe(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete() called");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        e.printStackTrace();
                    }
                });
    }
}
