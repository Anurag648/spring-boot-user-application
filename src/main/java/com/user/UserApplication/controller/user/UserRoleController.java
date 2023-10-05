package com.user.UserApplication.controller.user;

import com.user.UserApplication.Service.user.UserRoleService;
import com.user.UserApplication.domain.user.UserRole;
import com.user.UserApplication.dto.user.UserRoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserRoleController {
    @Autowired
    UserRoleService userRoleService;

    final String ROLE_URL = "api/v1/user/role";
    final String NOT_FOUND = "Role Not Found";

    @PostMapping(ROLE_URL)
    public UserRole addRole(@RequestBody UserRole userRole) {
        return userRoleService.addUserRole(userRole);
    }
    @PutMapping(ROLE_URL)
    public Object updateRole(@RequestBody UserRole userRole){
        return userRoleService.updateUserRole(userRole)!=null?userRoleService.updateUserRole(userRole):NOT_FOUND;
    }
    @GetMapping(ROLE_URL)
    public Object getRole(@RequestParam long id){
        return userRoleService.getRole(id)!=null?userRoleService.getRole(id):NOT_FOUND;
    }
    @DeleteMapping(ROLE_URL)
    public String removeRole(@RequestParam long id) {
        return userRoleService.removeRole(id);
    }
}
