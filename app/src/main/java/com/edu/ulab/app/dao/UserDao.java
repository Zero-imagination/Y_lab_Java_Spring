package com.edu.ulab.app.dao;

import com.edu.ulab.app.entity.User;


public interface UserDao {
    User create(User user);
    User getUserById(Long id);
    User update(User user);
    void deleteUserById(Long id);
}
