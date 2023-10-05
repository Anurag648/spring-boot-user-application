package com.user.UserApplication.Service.user;

import com.user.UserApplication.domain.user.User;
import com.user.UserApplication.dto.user.UserDto;
import com.user.UserApplication.dto.user.UserRoleDto;

import java.util.Map;

public interface UserService {

      Map<String, Object> createUser(UserDto dto);
      User getUser(long id);
}
