package com.sw.unittestingpractice.ui.notelist;


import android.os.Bundle;
import android.util.Log;

import com.sw.unittestingpractice.R;
import com.sw.unittestingpractice.repo.NoteRepo;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;


public class NoteListActivity extends DaggerAppCompatActivity {

    private static final String TAG = "NoteListActivity";
    @Inject
    NoteRepo noteRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);

        Log.d(TAG, "onCreate: " + noteRepo);


    }
}