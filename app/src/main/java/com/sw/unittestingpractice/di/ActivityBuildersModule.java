package com.sw.unittestingpractice.di;

import com.sw.unittestingpractice.NoteListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract NoteListActivity contributeNoteListActivity();

}
