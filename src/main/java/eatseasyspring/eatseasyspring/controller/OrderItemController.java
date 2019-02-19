package eatseasyspring.eatseasyspring.controller;

import eatseasyspring.eatseasyspring.model.Order;
import eatseasyspring.eatseasyspring.model.OrderItem;
import eatseasyspring.eatseasyspring.repository.OrderItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RequestMapping("/api")
@CrossOrigin(origins = "*")
@RestController
public class OrderItemController {
    @Autowired
    private OrderItemRepo orderRepo;

    // GET routes
    @GetMapping(value = "orderitems")
    public List<OrderItem> getAllOrdersItems() {
        return orderRepo.findAll();
    }

    // POST routes
    @PostMapping(value = "orderitems")
    public OrderItem addOrderItem(@RequestBody OrderItem orderItem) {
        return orderRepo.save(orderItem);
    }
}