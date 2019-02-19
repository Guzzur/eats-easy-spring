package eatseasyspring.eatseasyspring.repository;

import eatseasyspring.eatseasyspring.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem, Integer> {
}
