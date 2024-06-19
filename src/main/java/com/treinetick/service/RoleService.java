package com.treinetick.service;

import com.treinetick.model.Role;
import com.treinetick.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

//    public Role getRoleById(int id) {
//        return roleRepository.findById(id).orElse(null);
//    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

//    public void deleteRole(int id) {
//        roleRepository.deleteById(id);
//    }
}

