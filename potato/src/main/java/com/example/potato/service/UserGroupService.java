package com.example.potato.service;

import com.example.potato.model.UserGroup;
import com.example.potato.repository.UserGroupRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Service
public class UserGroupService {
    private final UserGroupRepo groupRepository;

    @Autowired
    public UserGroupService(UserGroupRepo groupRepository) {
        this.groupRepository = groupRepository;
    }

    public UserGroup createGroup(UserGroup group) {
        return groupRepository.save(group);
    }

    public List<UserGroup> getGroupsByUser(Long userId) {
        return groupRepository.findAll().stream()
                .filter(group -> group.getUsers().stream()
                        .anyMatch(user -> user.getUserId().equals(userId)))
                .collect(Collectors.toList());
    }

    public UserGroup updateGroup(Long groupId, UserGroup newGroupData) {
        return groupRepository.findById(groupId)
            .map(existingGroup -> {
                existingGroup.setUserGroupName(newGroupData.getUserGroupName());
                existingGroup.setRegister(newGroupData.getRegister());
                existingGroup.setRegDatetime(newGroupData.getRegDatetime());
                existingGroup.setLastModifier(newGroupData.getLastModifier());
                existingGroup.setLastModDatetime(newGroupData.getLastModDatetime());
                existingGroup.setState(newGroupData.getState());
                existingGroup.setDeleted(newGroupData.isDeleted());
                return groupRepository.save(existingGroup);
            })
            .orElseThrow(() -> new RuntimeException("Group not found"));
    }

    public void deleteGroup(Long groupId) {
        groupRepository.deleteById(groupId);
    }
}

