package com.edu.ulab.app.service.impl;

import com.edu.ulab.app.dao.impl.UserDaoImpl;
import com.edu.ulab.app.dto.UserDto;
import com.edu.ulab.app.entity.User;
import com.edu.ulab.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserDaoImpl userDao = new UserDaoImpl();
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = new User();
        user.setAge(userDto.getAge());
        user.setFullName(userDto.getFullName());
        user.setTitle(userDto.getTitle());
        user.setListBookId(userDto.getListBooksId());
        // сгенерировать идентификатор
        // создать пользователя
        // вернуть сохраненного пользователя со всеми необходимыми полями id
        userDto.setId(userDao.create(user).getId());
        return userDto;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userDao.getUserById(userId);
        UserDto userDto=new UserDto();
        userDto.setAge(user.getAge());
        userDto.setFullName(user.getFullName());
        userDto.setTitle(user.getTitle());
        userDto.setListBooksId(user.getListBookId());
        return userDto;
    }

    @Override
    public void deleteUserById(Long userId) {
        userDao.deleteUserById(userId);
    }
}
