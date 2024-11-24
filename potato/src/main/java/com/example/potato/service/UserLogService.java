package com.example.potato.service;

import com.example.potato.model.UserLog;
import com.example.potato.repository.UserLogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserLogService {
    private final UserLogRepo userLogRepository;

    @Autowired
    public UserLogService(UserLogRepo userLogRepository) {
        this.userLogRepository = userLogRepository;
    }

    public UserLog saveUserLog(UserLog userLog) {
        return userLogRepository.save(userLog);
    }

    public List<UserLog> getAllUserLogs() {
        return userLogRepository.findAll();
    }

    public Optional<UserLog> getUserLogById(Long logId) {
        return userLogRepository.findById(logId);
    }

    public void deleteUserLog(Long logId) {
        userLogRepository.deleteById(logId);
    }
}
