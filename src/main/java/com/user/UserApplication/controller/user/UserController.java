package com.user.UserApplication.controller.user;

import Util.ResponseHandler;
import com.user.UserApplication.Service.user.UserService;
import com.user.UserApplication.domain.user.User;
import com.user.UserApplication.dto.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    final String USER_URL = "api/v1/user";
    @PostMapping(USER_URL)
    public ResponseEntity<Object> createUser(@RequestBody UserDto dto) {
        Map<String, Object> response = userService.createUser(dto);
        if (!response.isEmpty())
           return ResponseHandler.generateResponse(HttpStatus.CREATED, true, "User Created Successfully", response);
         else
           return ResponseHandler.generateResponse(HttpStatus.EXPECTATION_FAILED, false, "Something went Wrong", null);
    }

    @GetMapping(USER_URL)
    public ResponseEntity<Object> getUser(@RequestParam long id){
        User user = userService.getUser(id);
        if(Objects.nonNull(user)){
            return ResponseHandler.generateResponse(HttpStatus.OK, true, "Data Fetched Successfully", user);
        } else {
            return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, false, "Something went Wrong", null);
        }
    }

}
