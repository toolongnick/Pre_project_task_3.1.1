package com.kata_academy.task_3_1_1.servise;

import com.kata_academy.task_3_1_1.dao.UserDao;
import com.kata_academy.task_3_1_1.dao.UserDaoImp;
import com.kata_academy.task_3_1_1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    UserDao userDao = new UserDaoImp();

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public List<User> listOfUsers() {
        return userDao.listOfUsers();
    }

    @Override
    public void remove(Integer id) {
        userDao.remove(id);
    }

    @Override
    public void edit(User user) {
        userDao.edit(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }
}
