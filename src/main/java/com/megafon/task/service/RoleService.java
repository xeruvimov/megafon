package com.megafon.task.service;

import com.megafon.task.domain.Role;
import com.megafon.task.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    @Transactional
    public Role getByName(String name) {
        return roleRepository.findByName(name);
    }
}
