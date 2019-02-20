package eatseasyspring.eatseasyspring.repository;

import eatseasyspring.eatseasyspring.model.CallResolve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface CallResolveRepo extends JpaRepository<CallResolve, Integer> {
}
