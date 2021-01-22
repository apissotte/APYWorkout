package com.apy.apyworkout.ui.exerciseMaster;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.apy.apyworkout.R;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class ExerciseMasterFragment extends Fragment {

    public ExerciseMasterFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exercise_master, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView addExercise = view.findViewById(R.id.addExercise);
        addExercise.setOnClickListener(v -> NavHostFragment
                .findNavController(this)
                .navigate(R.id.action_exerciseMasterFragment_to_exerciseDetailFragment));
    }
}