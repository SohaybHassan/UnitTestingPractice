package com.sw.unittestingpractice;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.sw.unittestingpractice.models.Note;
import com.sw.unittestingpractice.persistence.NoteDao;
import com.sw.unittestingpractice.persistence.NoteDataBase;
import com.sw.unittestingpractice.util.TestUtil;

import org.junit.After;
import org.junit.Before;

public abstract class NoteDatabaseTest {

    //system under test
    private NoteDataBase noteDataBase;


    public NoteDao getNoteDao() {
        return noteDataBase.getNoteDao();
    }


    @Before
    public void init() {
        noteDataBase = Room.inMemoryDatabaseBuilder(
                ApplicationProvider.getApplicationContext(),
                NoteDataBase.class
        ).build();
    }

    @After
    public void finish() {
        noteDataBase.close();
    }
}
