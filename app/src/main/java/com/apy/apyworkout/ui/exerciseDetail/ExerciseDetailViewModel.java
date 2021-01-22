package com.apy.apyworkout.ui.exerciseDetail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.apy.apyworkout.model.Room.entities.Exercise;

public class ExerciseDetailViewModel extends ViewModel {
    private final MutableLiveData<Exercise> exercise;

    public ExerciseDetailViewModel() {
        this.exercise = new MutableLiveData<>();
    }

    public LiveData<Exercise> getExercise() {
        if (exercise.getValue() == null) {
            exercise.setValue(new Exercise());
        }
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise.setValue(exercise);
    }
}