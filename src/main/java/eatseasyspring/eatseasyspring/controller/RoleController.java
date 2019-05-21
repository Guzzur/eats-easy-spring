package eatseasyspring.eatseasyspring.controller;


import eatseasyspring.eatseasyspring.model.Role;
import eatseasyspring.eatseasyspring.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@CrossOrigin(origins = "*")
@RestController
public class RoleController {
    @Autowired
    private RoleRepo roleRepo;

    // GET routes
    @GetMapping(value = "roles")
    public List<Role> getAllRoles() {
        return roleRepo.findAll();
    }

    // POST routes
    @PostMapping(value = "roles")
    public Role addRole(@RequestBody Role role) {
        return roleRepo.save(role);
    }

    // PUT routes
    @PutMapping(value = "roles/{roleId}")
    public ResponseEntity<Role> updateRoles(@RequestBody Role role, @PathVariable int roleId) {
        Optional<Role> roleOptional = roleRepo.findById(roleId);

        if(!roleOptional.isPresent())
            return ResponseEntity.notFound().build();

        role.setRoleId(roleId);
        roleRepo.save(role);

        return ResponseEntity.ok(role);
    }

    // DELETE routes
    @DeleteMapping(value = "roles/{roleId}")
    public void deleteRoles(@PathVariable int roleId) {
        roleRepo.deleteById(roleId);
    }

}