package com.hfad.workout;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
                          implements Listener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void itemClicked(long ID) {

        View container = findViewById(R.id.fragment_container);
        if (null == container) {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, (int) ID);
            startActivity(intent);
        }
        else {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            WorkoutDetailFragment fragment = new WorkoutDetailFragment();
            fragment.setWorkoutId( ID );
            transaction.replace(R.id.fragment_container, fragment);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}
