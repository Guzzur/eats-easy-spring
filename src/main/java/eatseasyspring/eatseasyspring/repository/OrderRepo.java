package eatseasyspring.eatseasyspring.repository;

import java.util.*;

import eatseasyspring.eatseasyspring.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
    List<Order> findOrdersByRestId(int restId);
}
