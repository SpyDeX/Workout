package com.hfad.workout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    public static String EXTRA_WORKOUT_ID = "Workout_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        WorkoutDetailFragment frag = (WorkoutDetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_fragment);

        int workout_Id = getIntent().getExtras().getInt(EXTRA_WORKOUT_ID);
        frag.setWorkoutId(workout_Id);

        this.setTitle( Workout.workouts[workout_Id].getName() );
    }
}
