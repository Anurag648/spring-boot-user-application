package com.user.UserApplication.Repository.user;

import com.user.UserApplication.domain.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {


    List<UserRole> findAllByIdIn(List<Long> roleId);
}
