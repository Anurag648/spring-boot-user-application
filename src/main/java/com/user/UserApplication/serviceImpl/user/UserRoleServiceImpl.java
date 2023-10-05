package com.user.UserApplication.serviceImpl.user;

import com.user.UserApplication.Repository.user.UserRoleRepository;
import com.user.UserApplication.Service.user.UserRoleService;
import com.user.UserApplication.domain.user.UserRole;
import com.user.UserApplication.dto.user.UserRoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleRepository userRoleRepository;

    public UserRole addUserRole(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    public UserRole updateUserRole(UserRole userRole) {
        UserRole role = userRoleRepository.findById(userRole.getId()).orElse(null);
        if (role != null) {
            role.setRanks(userRole.getRanks());
            role.setRoles(userRole.getRoles());
            return userRoleRepository.save(role);
        } else {
            return null;
        }
    }
    public UserRole getRole(long id){
        return userRoleRepository.findById(id).orElse(null);
    }

    public String removeRole(long id){
        UserRole role = userRoleRepository.findById(id).orElse(null);
        if(Objects.nonNull(role)){
            userRoleRepository.deleteById(id);
            return "Role Deleted Successfully";
        } else
            return "Data Not Found";
    }

}
