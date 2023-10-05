package com.user.UserApplication.domain.user;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NonNull
    private String roles;
    @NonNull
    private int ranks;

    public UserRole() {

    }
}
