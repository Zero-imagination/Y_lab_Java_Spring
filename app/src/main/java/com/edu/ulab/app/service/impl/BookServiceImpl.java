package com.edu.ulab.app.service.impl;

import com.edu.ulab.app.dao.impl.BookDaoImpl;
import com.edu.ulab.app.dto.BookDto;
import com.edu.ulab.app.entity.Book;
import com.edu.ulab.app.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BookServiceImpl implements BookService {
    private final BookDaoImpl bookDao = new BookDaoImpl();
    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = new Book();
        book.setAuthor(bookDto.getAuthor());
        book.setTitle(bookDto.getTitle());
        book.setUserId(bookDto.getUserId());
        book.setPageCount(bookDto.getPageCount());
        bookDto.setId(bookDao.createBook(book).getId());
        return bookDto;
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        return null;
    }

    @Override
    public BookDto getBookById(Long id) {
        return null;
    }

    @Override
    public void deleteBookById(Long id) {
        bookDao.deleteBookById(id);
    }


}