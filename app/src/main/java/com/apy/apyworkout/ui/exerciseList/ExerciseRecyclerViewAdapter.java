package com.apy.apyworkout.ui.exerciseList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.recyclerview.widget.RecyclerView;

import com.apy.apyworkout.R;
import com.apy.apyworkout.model.Room.entities.Exercise;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link com.apy.apyworkout.model.Room.entities.Exercise}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ExerciseRecyclerViewAdapter extends RecyclerView.Adapter<ExerciseRecyclerViewAdapter.ViewHolder> {

    private final List<Exercise> mValues;

    public ExerciseRecyclerViewAdapter(List<Exercise> items) {
        mValues = items;
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_exercise_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mExerciseNameEditText.setText(mValues.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final EditText mExerciseNameEditText;
        public Exercise mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mExerciseNameEditText = (EditText) view.findViewById(R.id.exercise_name);
        }

    }
}