package eatseasyspring.eatseasyspring.repository;

import java.util.*;

import eatseasyspring.eatseasyspring.model.TableClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepo extends JpaRepository<TableClass, Integer> {
    List<TableClass> findTablesByRestId(int restId);
}
