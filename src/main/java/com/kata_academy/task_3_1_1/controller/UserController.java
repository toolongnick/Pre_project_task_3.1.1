package com.kata_academy.task_3_1_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.kata_academy.task_3_1_1.model.User;
import com.kata_academy.task_3_1_1.servise.UserServiceImp;

import java.util.List;

@Controller
public class UserController {

    @Value("Spring Boot & MVC")
    private String welcome;

    @Autowired
    private UserServiceImp userServiceImp;

    @GetMapping(value = "/")
    public ModelAndView welcomePage (ModelAndView model) {
        model.setViewName("welcome_page");
        model.addObject("welcome", welcome);
        return model;
    }

    @GetMapping(value = "/users")
    public ModelAndView listOfUsers(ModelAndView model) {
        List<User> list = userServiceImp.listOfUsers();
        model.setViewName("user-list");
        model.addObject("ListOfUsers", list);
        return model;
    }

    @GetMapping(value = "/user-create")
    public ModelAndView createUserForm(User user, ModelAndView model) {
        model.setViewName("user-create");
        model.addObject("user", user);
        return model;
    }

    @PostMapping(value = "/user-create")
    public String createUser(@ModelAttribute User user) {
        userServiceImp.add(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/user-edit/{id}")
    public ModelAndView editPage (@PathVariable ("id") Integer id, ModelAndView modelAndView) {
        User user = userServiceImp.getUserById(id);
        modelAndView.setViewName("user-edit");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping(value = "/user-edit/{id}")
    public ModelAndView editFilm(@ModelAttribute User user, @PathVariable("id") Integer id, ModelAndView modelAndView) {
        user.setId(id);
        modelAndView.setViewName("redirect:/users");
        userServiceImp.edit(user);
        return modelAndView;
    }

    @GetMapping(value = "/user-delete/{id}")
    public ModelAndView deleteUser(@PathVariable ("id") Integer id, ModelAndView modelAndView){
        modelAndView.setViewName("redirect:/users");
        userServiceImp.remove(id);
        return modelAndView;
    }

}