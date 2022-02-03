package com.kata_academy.task_3_1_1.dao;

import com.kata_academy.task_3_1_1.model.*;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> listOfUsers();
    void remove(Integer id);
    void edit (User user);
    User getUserById(Integer id);

}
