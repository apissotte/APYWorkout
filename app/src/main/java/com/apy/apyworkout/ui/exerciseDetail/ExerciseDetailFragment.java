package com.apy.apyworkout.ui.exerciseDetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.apy.apyworkout.databinding.FragmentExerciseDetailBinding;

public class ExerciseDetailFragment extends Fragment {

    private FragmentExerciseDetailBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = FragmentExerciseDetailBinding.inflate(inflater, container, false);
        mBinding.setPresenter(new ExerciseDetailViewPresenter());
        mBinding.setViewModel(new ViewModelProvider(this).get(ExerciseDetailViewModel.class));

        return mBinding.getRoot();
    }

}