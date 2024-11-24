package com.example.potato.repository;

import com.example.potato.model.UserLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLogRepo extends JpaRepository<UserLog, Long> {
}
