package com.sw.unittestingpractice.repo;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.sw.unittestingpractice.models.Note;
import com.sw.unittestingpractice.persistence.NoteDao;
import com.sw.unittestingpractice.ui.Resource;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class NoteRepo {

    private static final String TAG = "NoteRepo";
    public static final String NOTE_TITLE_NULL = "Note title cannot be null";
    public static final String INVALID_NOTE_ID = "Invalid id. Can't delete note";
    public static final String DELETE_SUCCESS = "Delete success";
    public static final String DELETE_FAILURE = "Delete failure";
    public static final String UPDATE_SUCCESS = "Update success";
    public static final String UPDATE_FAILURE = "Update failure";
    public static final String INSERT_SUCCESS = "Insert success";
    public static final String INSERT_FAILURE = "Insert failure";

    private int timeDelay = 0;
    private TimeUnit timeUnit = TimeUnit.SECONDS;

    @NonNull
    private final NoteDao noteDao;

    @Inject
    public NoteRepo(@NonNull NoteDao noteDao) {
        this.noteDao = noteDao;
    }


    public Flowable<Resource<Integer>> inserttNote(Note note) throws Exception {

        checkTitle(note);

        return noteDao.insertNote(note)
                .delaySubscription(timeDelay, timeUnit)
                .map(new Function<Long, Integer>() {
                    @Override
                    public Integer apply(@NonNull Long aLong) throws Exception {
                        long l = aLong;
                        return (int) l;
                    }
                })
                .onErrorReturn(new Function<Throwable, Integer>() {
                    @Override
                    public Integer apply(@NonNull Throwable throwable) throws Exception {
                        return -1;
                    }
                })
                .map(new Function<Integer, Resource<Integer>>() {
                    @Override
                    public Resource<Integer> apply(@NonNull Integer integer) throws Exception {

                        if (integer > 0) {
                            return Resource.success(integer, INSERT_SUCCESS);
                        }
                        return Resource.error(null, INSERT_FAILURE);
                    }
                })
                .subscribeOn(Schedulers.io())
                .toFlowable();
    }

    private void checkTitle(Note note) throws Exception {
        if (note.getTitle() == null) {
            throw new Exception(NOTE_TITLE_NULL);
        }
    }


}
