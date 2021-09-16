package com.sw.unittestingpractice.repo;

import static com.sw.unittestingpractice.repo.NoteRepo.INSERT_FAILURE;
import static com.sw.unittestingpractice.repo.NoteRepo.INSERT_SUCCESS;
import static com.sw.unittestingpractice.repo.NoteRepo.NOTE_TITLE_NULL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import com.sw.unittestingpractice.models.Note;
import com.sw.unittestingpractice.persistence.NoteDao;
import com.sw.unittestingpractice.ui.Resource;
import com.sw.unittestingpractice.util.TestUtil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import io.reactivex.Single;


public class NoteRepoTest {

    private static final Note NOTE1 = new Note(TestUtil.TEST_NOTE_1);


    // system under test
    private NoteRepo noteRepo;

    private NoteDao noteDao;

    @BeforeEach
    public void initEach() {
        noteDao = mock(NoteDao.class);
        noteRepo = new NoteRepo(noteDao);
    }

    /*
        insert note
        verify the correct method is called
        confirm observer is triggered
        confirm new rows inserted
     */
    @Test
    void insertNote_returnRow() throws Exception {
        //Arrange
        final long insertRow = 1L;
        final Single<Long> returnedData = Single.just(insertRow);
        when(noteDao.insertNote(any(Note.class))).thenReturn(returnedData);
        //Act
        final Resource<Integer> returnedValue = noteRepo.inserttNote(NOTE1).blockingSingle();
        //Assert
        verify(noteDao).insertNote(any(Note.class));
        verifyNoMoreInteractions(noteDao);

        System.out.println("Returned Value: " + returnedValue.data);
        assertEquals(Resource.success(1, INSERT_SUCCESS), returnedValue);

        // or test Using RxJava
//        noteRepo.inserttNote(NOTE1)
//                .test()
//                .await()
//                .assertValue(Resource.success(1, INSERT_SUCCESS));


    }

    /*
        Insert note
        Failure (return -1)
     */
    @Test
    void insertNote_returnFailure() throws Exception {
        //Arrange
        final long failedInsert = -1L;
        final Single<Long> returnedData = Single.just(failedInsert);
        when(noteDao.insertNote(any(Note.class))).thenReturn(returnedData);
        //Act
        final Resource<Integer> returnedValue = noteRepo.inserttNote(NOTE1).blockingFirst();
        //Assert
        verify(noteDao).insertNote(any(Note.class));
        verifyNoMoreInteractions(noteDao);


        assertEquals(Resource.error(null, INSERT_FAILURE), returnedValue);
    }
    /*
        insert note
        null title
        confirm throw exception
     */

    @Test
    void insertNote_nullTitle_throwException() throws Exception {
        Exception exception = assertThrows(Exception.class, new Executable() {
            @Override
            public void execute() throws Throwable {

                Note note = new Note(TestUtil.TEST_NOTE_1);
                note.setTitle(null);
                noteRepo.inserttNote(note);
            }
        });
        assertEquals(NOTE_TITLE_NULL, exception.getMessage());
    }
    /*
        update note
        verify correct method is called
        confirm observer is trigger
        confirm number of rows updated
     */
    /*
        update note
        Failure (-1)
     */


    /*
        update note
        null title
        throw exception
     */
      /*
        delete note
        null id
        throw exception
     */
     /*
        delete note
        delete success
        return Resource.success with deleted row
     */

     /*
        delete note
        delete failure
        return Resource.error
     */
    /*
        retrieve notes
        return list of notes
     */

    /*
        retrieve notes
        return empty list
     */
}
