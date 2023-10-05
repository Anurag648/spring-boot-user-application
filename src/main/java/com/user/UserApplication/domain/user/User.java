package com.user.UserApplication.domain.user;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

import java.util.List;
@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String grade;
    private int salary;
    @OneToOne
    private User supervisor;
    @OneToMany(cascade = CascadeType.ALL)
    private List<User> team;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<UserRole> roles;

    public User() {

    }
}
