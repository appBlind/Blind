package com.example.potato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.potato.model.UserGroup;

public interface UserGroupRepo extends JpaRepository<UserGroup, Long> {

}
