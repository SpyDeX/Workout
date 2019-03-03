package com.hfad.workout;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutDetailFragment extends Fragment {

    private long WorkoutId;

    public WorkoutDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong("wID", WorkoutId);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (null != savedInstanceState)
        {
            WorkoutId = savedInstanceState.getLong("wId");
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        View view = getView();
        if (null != view)
        {
            TextView ttl = view.findViewById(R.id.textTitle);
            ttl.setText( Workout.workouts[ (int) WorkoutId ].getName() );

            TextView txt = view.findViewById(R.id.textDescription);
            txt.setText( Workout.workouts[ (int) WorkoutId ].getDescription() );
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    public void setWorkoutId(long ID){
        this.WorkoutId = ID;
    }
}
