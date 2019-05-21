package eatseasyspring.eatseasyspring.repository;

import eatseasyspring.eatseasyspring.model.CallWaiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface CallWaiterRepo extends JpaRepository<CallWaiter, Integer> {
        List<CallWaiter> findCallWaitersByRestId(int restId);
}
