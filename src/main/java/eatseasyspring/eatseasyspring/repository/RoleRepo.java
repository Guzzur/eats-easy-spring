package eatseasyspring.eatseasyspring.repository;

import java.util.*;

import eatseasyspring.eatseasyspring.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {
}
