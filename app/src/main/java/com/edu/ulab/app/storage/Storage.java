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
        user.setId((long) user.hashCode());
        storageUser.put(user.getId(), user);
        return user;
    }
    public Book create(Book book){
        book.setId((long) book.hashCode());
        storageBook.put(book.getId(), book);
        return book;
    }


    /*public void update(User user){
        if (storageUser.containsKey(user.getId())){
            storageUser.put(user.getId(), user);
        }
    }*/
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

    //todo создать хранилище в котором будут содержаться данные
    // сделать абстракции через которые можно будет производить операции с хранилищем
    // продумать логику поиска и сохранения
    // продумать возможные ошибки
    // учесть, что при сохранеии юзера или книги, должен генерироваться идентификатор
    // продумать что у узера может быть много книг и нужно создать эту связь
    // так же учесть, что методы хранилища принимают друго тип данных - учесть это в абстракции
}