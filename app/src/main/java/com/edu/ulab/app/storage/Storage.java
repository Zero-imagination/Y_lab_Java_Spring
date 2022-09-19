package com.edu.ulab.app.storage;

import com.edu.ulab.app.entity.Book;
import com.edu.ulab.app.entity.User;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Storage {
    static Storage instance;
    private ConcurrentHashMap<Long, User> storageUser = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Long, Book> storageBook = new ConcurrentHashMap<>();

    private Storage(){

    }
    public static Storage getInstance(){
        if (instance==null){
            instance =new Storage();
        }
        return instance;
    }
    public User create(User user){
        if (!Objects.nonNull(user)){
            return null;
        }
        user.setId((long) user.hashCode());
        storageUser.put(user.getId(), user);
        return user;
    }
    public Book create(Book book){
        if (!Objects.nonNull(book)){
            return null;
        }
        book.setId((long) book.hashCode());
        storageBook.put(book.getId(), book);
        return book;
    }

    public void deleteUser(Long userId){
        if (storageUser.containsKey(userId) && Objects.nonNull(userId)){
            storageUser.remove(userId);
        }
    }
    public void deleteBook(Long bookId){
        if (storageBook.containsKey(bookId) && Objects.nonNull(bookId)){
            storageUser.remove(bookId);
        }
    }
    public User getUserById(Long userId){
        if (!storageUser.containsKey(userId) || !Objects.nonNull(userId)){
            return null;
        }
        return storageUser.get(userId);
    }
    public User updateUser(User user){
        if (!Objects.nonNull(user)){
            return null;
        }
        if (!storageUser.containsKey(user.getId())){
            return null;
        }
        storageUser.replace(user.getId(), user);
        return user;
    }
    public Book updateBook(Book book){
        if (!Objects.nonNull(book)){
            return null;
        }
        if (!storageBook.containsKey(book.getId())){
            return null;
        }
        storageBook.replace(book.getId(), book);
        return book;
    }

    //todo создать хранилище в котором будут содержаться данные
    // сделать абстракции через которые можно будет производить операции с хранилищем
    // продумать логику поиска и сохранения
    // продумать возможные ошибки
    // учесть, что при сохранеии юзера или книги, должен генерироваться идентификатор
    // продумать что у узера может быть много книг и нужно создать эту связь
    // так же учесть, что методы хранилища принимают друго тип данных - учесть это в абстракции
}