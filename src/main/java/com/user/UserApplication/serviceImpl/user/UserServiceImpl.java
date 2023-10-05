package com.user.UserApplication.serviceImpl.user;

import com.user.UserApplication.Repository.user.UserRepository;
import com.user.UserApplication.Repository.user.UserRoleRepository;
import com.user.UserApplication.Service.user.UserService;
import com.user.UserApplication.domain.user.User;
import com.user.UserApplication.domain.user.UserRole;
import com.user.UserApplication.dto.user.UserDto;
import com.user.UserApplication.dto.user.UserRoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    public Map<String, Object> createUser(UserDto dto){
        Map<String, Object> response = new HashMap<>();
        User user = new User();
        user.setName(dto.getName());
        user.setGrade(dto.getGrade());
        Optional<User> supervisor = userRepository.findById(dto.getSupervisorId());
        supervisor.ifPresent(user::setSupervisor);
        List<UserRole> roles = userRoleRepository.findAllByIdIn(dto.getRoleIds());
        if(!roles.isEmpty()){
            user.setRoles(roles);
        }
        List<User> team = userRepository.findAllByIdIn(dto.getTeam());
        if(!team.isEmpty()){
            user.setTeam(team);
        }
        userRepository.save(user);
        response.put("data","User Added Successfully");
        return response;
    }

    public User getUser(long  id){
        return userRepository.findById(id).orElse(null);
    }
}

