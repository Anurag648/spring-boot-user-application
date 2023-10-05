package com.user.UserApplication.controller.user;

import com.user.UserApplication.Service.user.UserService;
import com.user.UserApplication.domain.user.User;
import com.user.UserApplication.dto.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    final String USER_URL = "api/v1/user";
    @PostMapping(USER_URL)
    public String createUser(@RequestBody UserDto dto){
        Map<String, Object> response = userService.createUser(dto);
        if(!response.isEmpty()){
            return "User Created Successfully";
        } else {
            return "Something went wrong";
        }
    }
    @GetMapping(USER_URL)
    public User getUser(@RequestParam long id){
        return userService.getUser(id);
    }

}
