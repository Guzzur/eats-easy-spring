package eatseasyspring.eatseasyspring.repository;

import eatseasyspring.eatseasyspring.model.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ShiftRepo extends JpaRepository<Shift, Integer> {
}
