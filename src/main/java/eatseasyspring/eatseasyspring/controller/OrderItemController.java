package eatseasyspring.eatseasyspring.controller;

import eatseasyspring.eatseasyspring.model.OrderItem;
import eatseasyspring.eatseasyspring.repository.OrderItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RequestMapping("/api")
@CrossOrigin(origins = "*")
@RestController
public class OrderItemController {
    @Autowired
    private OrderItemRepo orderItemRepo;

    // GET routes
    @GetMapping(value = "orderitems")
    public List<OrderItem> getAllOrdersItems() {
        return orderItemRepo.findAll();
    }

    @GetMapping(value = "orderitems/{orderItemId}")
    public Optional<OrderItem> getOrderItemById(@PathVariable("orderItemId") int orderItemId) {
        return orderItemRepo.findById(orderItemId);
    }

    // POST routes
    @PostMapping(value = "orderitems")
    public OrderItem addOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemRepo.save(orderItem);
    }

    // PUT routes
    @PutMapping(value = "orderitems/{orderItemId}")
    public ResponseEntity<OrderItem> updateOrderItem(@RequestBody OrderItem orderItem, @PathVariable int orderItemId) {
        Optional<OrderItem> orderItemOptional = orderItemRepo.findById(orderItemId);

        if(!orderItemOptional.isPresent())
            return ResponseEntity.notFound().build();

        orderItem.setOrderItemId(orderItemId);
        orderItemRepo.save(orderItem);

        return ResponseEntity.ok(orderItem);
    }

    // DELETE routes
    @DeleteMapping(value = "orderitems/{orderItem}")
    public void deleteOrderItem(@PathVariable int orderItem) {
        orderItemRepo.deleteById(orderItem);
    }

}