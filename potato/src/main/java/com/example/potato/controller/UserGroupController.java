package com.example.potato.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.potato.model.UserGroup;
import com.example.potato.service.UserGroupService;

@RestController
@RequestMapping("/user-groups")
public class UserGroupController {

    private final UserGroupService userGroupService;

    @Autowired
    public UserGroupController(UserGroupService userGroupService) {
        this.userGroupService = userGroupService;
    }

    @PostMapping
    public ResponseEntity<UserGroup> createUserGroup(@RequestBody UserGroup userGroup) {
        UserGroup createdGroup = userGroupService.createGroup(userGroup);
        return ResponseEntity.ok(createdGroup);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserGroup>> getUserGroupsByUserId(@PathVariable Long userId) {
        List<UserGroup> userGroups = userGroupService.getGroupsByUser(userId);
        if (userGroups.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(userGroups);
    }

    @PutMapping("/{groupId}")
    public ResponseEntity<UserGroup> updateUserGroup(@PathVariable Long groupId, @RequestBody UserGroup userGroup) {
        UserGroup updatedGroup = userGroupService.updateGroup(groupId, userGroup);
        return ResponseEntity.ok(updatedGroup);
    }

    @DeleteMapping("/{groupId}")
    public ResponseEntity<Void> deleteUserGroup(@PathVariable Long groupId) {
        userGroupService.deleteGroup(groupId);
        return ResponseEntity.noContent().build();
    }
}
