package com.user.UserApplication.Service.user;

import com.user.UserApplication.domain.user.UserRole;
import com.user.UserApplication.dto.user.UserRoleDto;

import java.util.Map;

public interface UserRoleService {

    UserRole addUserRole(UserRole userRole);
    UserRole updateUserRole(UserRole userRole);
    UserRole getRole(long id);
    String removeRole(long id);

}
