package eatseasyspring.eatseasyspring.repository;

import eatseasyspring.eatseasyspring.model.Working;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface WorkingRepo extends JpaRepository<Working, Integer> {
}
