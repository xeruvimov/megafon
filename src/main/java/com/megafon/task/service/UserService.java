package com.megafon.task.service;

import com.megafon.task.domain.User;
import com.megafon.task.dto.UserDTO;
import com.megafon.task.mapper.UserMapper;
import com.megafon.task.repository.UserRepository;
import com.megafon.task.util.RoleConstant;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User registerNewUserAccount(UserDTO userDto) throws IllegalArgumentException {
        if (userRepository.existsByUsernameAndDeletedFalse(userDto.getUsername())) {
            throw new IllegalArgumentException("There is an account with that username: " + userDto.getUsername());
        }
        User user = userMapper.toEntity(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRoles(Collections.singleton(roleService.getByName(RoleConstant.USER_ROLE)));
        return userRepository.save(user);
    }

    @Transactional
    public User getByUsername(String username) {
        return userRepository.findByUsernameAndDeletedFalse(username)
                .orElseThrow(() -> new UsernameNotFoundException("No user found with username: " + username));
    }
}
