package com.kata_academy.task_3_1_1.servise;

import com.kata_academy.task_3_1_1.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listOfUsers();
    void remove(Integer id);
    void edit (User user);
    User getUserById(Integer id);

}
