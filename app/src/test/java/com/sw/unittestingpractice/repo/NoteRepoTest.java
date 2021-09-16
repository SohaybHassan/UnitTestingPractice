package com.sw.unittestingpractice.repo;

import static org.mockito.Mockito.*;

import com.sw.unittestingpractice.persistence.NoteDao;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


public class NoteRepoTest {

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

        //Act

        //Assert

    }

    /*
        Insert note
        Failure (return -1)
     */

    @Test
    void insertNote_returnFailure() throws Exception {
        //Arrange

        //Act

        //Assert

    }
    /*
        insert note
        null title
        confirm throw exception
     */

    @Test
    void insertNote_nullTitle_throwException() throws Exception {
        //Arrange

        //Act

        //Assert

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
