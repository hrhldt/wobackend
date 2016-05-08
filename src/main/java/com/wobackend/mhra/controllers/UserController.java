package com.wobackend.mhra.controllers;

import com.wobackend.mhra.models.User;
import com.wobackend.mhra.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

@Controller
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    public @ResponseBody SessionStatus addUser(@RequestBody User user, SessionStatus status)
    {
        userService.persistUser(user);
        //TODO Fix some better response handling
        status.setComplete();
        return status;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAll() {
        return userService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public @ResponseBody User update(@PathVariable long id, @RequestBody User user) {
        User model = userService.findUserById(id);
        if ( model != null ) {
            return userService.updateUser(id,user);
        }
        return model;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public @ResponseBody User findUserById(@PathVariable int id) {
        User user = userService.findUserById(id);
        return user;
    }
}
