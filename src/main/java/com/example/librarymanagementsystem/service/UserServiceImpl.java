package com.example.librarymanagementsystem.service;


import com.example.librarymanagementsystem.dto.UserDto;
import com.example.librarymanagementsystem.entity.Role;
import com.example.librarymanagementsystem.entity.User;
import com.example.librarymanagementsystem.exceptions.ResourceConflictException;
import com.example.librarymanagementsystem.exceptions.ResourceNotFoundException;
import com.example.librarymanagementsystem.repository.RoleRepository;
import com.example.librarymanagementsystem.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
   private final UserRepository userRepository;
   private final RoleRepository roleRepository;

    @Override
    @Transactional
    public UserDto assignRoleToUser(String username, Long roleId) {
        User user = userRepository.findById(username);
              //  .orElseThrow(() -> ResourceNotFoundException.createForUser(username));

        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> ResourceNotFoundException.createForRole(roleId));

        // Check if user already has this role
        if (user.getRoles().contains(role)) {
            throw new ResourceConflictException("Role is already assigned to this user");
        }

        user.addRole(role);
        User updatedUser = userRepository.save(user);
        return userMapper.toDto(updatedUser);
    }

    // ...
}