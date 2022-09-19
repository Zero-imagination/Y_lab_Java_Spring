package com.edu.ulab.app.dao.impl;

import com.edu.ulab.app.dao.BookDao;
import com.edu.ulab.app.entity.Book;
import com.edu.ulab.app.storage.Storage;


public class BookDaoImpl implements BookDao {

    Storage storage = Storage.getInstance();

    @Override
    public Book createBook(Book book) {
        return storage.create(book);
    }

    @Override
    public Book updateBook(Book book) {
        return storage.updateBook(book);
    }

    @Override
    public Book getBookById(Long id) {
        return null;
    }

    @Override
    public void deleteBookById(Long id) {
        storage.deleteBook(id);
    }

}
