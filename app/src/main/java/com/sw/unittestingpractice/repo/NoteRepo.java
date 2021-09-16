package com.sw.unittestingpractice.repo;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.sw.unittestingpractice.persistence.NoteDao;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class NoteRepo {


    @NonNull
    private final NoteDao noteDao;


    @Inject
    public NoteRepo(@NonNull NoteDao noteDao) {
        this.noteDao = noteDao;
    }
}
