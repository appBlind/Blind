package com.example.potato.controller;

import com.example.potato.model.UserLog;
import com.example.potato.service.UserLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //indicates that this class is a Spring MVC controller
@RequestMapping("/user-logs")
public class UserLogController {
    // To handle the business logic for UserLog
    private final UserLogService userLogService;

    @Autowired
    public UserLogController(UserLogService userLogService) {
        this.userLogService = userLogService;
    }

    @PostMapping
    public ResponseEntity<UserLog> createUserLog(@RequestBody UserLog userLog) {
        UserLog savedLog = userLogService.saveUserLog(userLog);
        return ResponseEntity.ok(savedLog);
    }

    @GetMapping
    public ResponseEntity<List<UserLog>> getAllUserLogs() {
        List<UserLog> logs = userLogService.getAllUserLogs();
        return ResponseEntity.ok(logs);
    }

    @GetMapping("/{logId}")
    public  ResponseEntity<UserLog> getUserLogById(@PathVariable Long logId) {
        // a GET request to '/user-logs/1' will call this method with 'logId' is equal to '1'
        Optional<UserLog> log = userLogService.getUserLogById(logId);
        return log.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        // notFound() has already set the status code to 404, calling .build()
    }


    @DeleteMapping("/{logId}")
    public ResponseEntity<Void> deleteUserLog(@PathVariable Long logId) {
        userLogService.deleteUserLog(logId);
        return ResponseEntity.noContent().build();
    }


}
