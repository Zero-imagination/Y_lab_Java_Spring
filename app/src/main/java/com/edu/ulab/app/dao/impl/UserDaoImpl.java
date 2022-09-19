package com.edu.ulab.app.dao.impl;

import com.edu.ulab.app.dao.UserDao;
import com.edu.ulab.app.entity.User;
import com.edu.ulab.app.storage.Storage;


public class UserDaoImpl implements UserDao {
    Storage storage = Storage.getInstance();
    @Override
    public User create(User user) {
        return storage.create(user);
    }

    @Override
    public User getUserById(Long userId) {
        return storage.getUserById(userId);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void deleteUserById(Long userId) {
        storage.deleteUser(userId);
    }
}
