package com.sw.unittestingpractice.di;

import static com.sw.unittestingpractice.persistence.NoteDataBase.DATABASE_NAME;

import android.app.Application;

import androidx.room.Room;

import com.sw.unittestingpractice.models.Note;
import com.sw.unittestingpractice.persistence.NoteDao;
import com.sw.unittestingpractice.persistence.NoteDataBase;
import com.sw.unittestingpractice.repo.NoteRepo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {


    @Singleton
    @Provides
    static NoteDataBase provideNoteDataBase(Application application) {
        return Room.databaseBuilder(application,
                NoteDataBase.class,
                DATABASE_NAME)
                .build();
    }

    @Singleton
    @Provides
    static NoteDao provideNoteDao(NoteDataBase noteDataBase) {
        return noteDataBase.getNoteDao();
    }

    @Singleton
    @Provides
    static NoteRepo provideNoteRepo(NoteDao noteDao) {
        return new NoteRepo(noteDao);
    }


}
