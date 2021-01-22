package com.apy.apyworkout.ui.exerciseList;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.apy.apyworkout.R;
import com.apy.apyworkout.model.Room.database.APYWorkoutDatabase;
import com.apy.apyworkout.model.Room.entities.Exercise;

import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableSingleObserver;

/**
 * A fragment representing a list of Items.
 */
public class ExerciseListFragment extends Fragment {
    private static final String TAG = "ExerciseListFragment";

    public ExerciseListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exercise_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            Log.d(TAG, "onCreateView: ");

            APYWorkoutDatabase.getExercises(requireContext()).subscribe(new DisposableSingleObserver<List<Exercise>>() {
                @Override
                public void onSuccess(@NonNull List<Exercise> exercises) {
                    Log.d(TAG, "onSuccess() called with: exercises = [" + exercises + "]");
                    recyclerView.setAdapter(new ExerciseRecyclerViewAdapter(exercises));
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    Log.d(TAG, "onError() called with: e = [" + e + "]");
                    e.printStackTrace();
                }
            });
        }

        return view;
    }
}