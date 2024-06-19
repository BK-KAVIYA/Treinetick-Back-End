package com.treinetick.controller;

import com.treinetick.model.Role;
import com.treinetick.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

//    @GetMapping("/{id}")
//    public Role getRoleById(@PathVariable int id) {
//        return roleService.getRoleById(id);
//    }

    @PostMapping
    public Role createRole(@RequestBody Role role) {
        return roleService.saveRole(role);
    }

//    @DeleteMapping("/{id}")
//    public void deleteRole(@PathVariable int id) {
//        roleService.deleteRole(id);
//    }
}

