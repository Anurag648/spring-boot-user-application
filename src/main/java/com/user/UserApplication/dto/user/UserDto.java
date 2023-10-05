package com.user.UserApplication.dto.user;

import lombok.Data;

import java.util.List;
@Data
public class UserDto {

    private String name;
    private long supervisorId;
    private List<Long> team;
    private String grade;
    private List<Long> roleIds;

}
