package com.olegsagenadatrytwo.w3_w_amazon;

import com.olegsagenadatrytwo.w3_w_amazon.model.Book;

import java.util.ArrayList;

/**
 * Created by omcna on 8/20/2017.
 */

public class BooksLab {

    //create private variable
    private static BooksLab booklab;
    private ArrayList<Book> mBooks;

    //this method returns an Instance of this class
    public static BooksLab get(){
        if(booklab == null){
            booklab = new BooksLab();
        }
        return booklab;
    }

    //private constructor
    private BooksLab(){
        mBooks = new ArrayList<>();
    }
    //returns the list of Books
    public ArrayList<Book> getBooks(){
        return mBooks;
    }
    //sets Book list
    public void setBookList(ArrayList<Book> list){
        mBooks = list;
    }

}
