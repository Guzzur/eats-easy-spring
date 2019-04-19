package eatseasyspring.eatseasyspring.controller;

import eatseasyspring.eatseasyspring.model.Order;
import eatseasyspring.eatseasyspring.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@CrossOrigin(origins = "*")
@RestController
public class OrderController {
    @Autowired
    private SimpMessagingTemplate webSocket;
  
    @Autowired
    private OrderRepo orderRepo;

    // GET routes
    @GetMapping(value = "orders")
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @GetMapping(value = "orders/{orderId}")
    public Optional<Order> getOrderById(@PathVariable("orderId") int orderId) {
        return orderRepo.findById(orderId);
    }

    //advanceOrderStatus using WS
    @GetMapping(value = "orders/advanceorderstatus/{orderId}")
    public Optional<Order> advanceOrderStatus(@PathVariable("orderId") int orderId) {

        Optional<Order> maybeOrder = getOrderById(orderId);
        if (maybeOrder.isPresent()) {
            Order order = maybeOrder.get();
            int orderStatus = order.getOrderStatus();
            if (orderStatus < 5)
                orderStatus++;
            order.setOrderStatus(orderStatus);
        }

        return orderRepo.findById(orderId);
    }


    // POST routes
    @PostMapping(value = "orders")
    public Order addOrder(@RequestBody Order order) {
        Order saved = orderRepo.save(order);

        String obj = "{";
        obj += "\n  type: " + "newOrder" + ",";
        obj += "\n  orderId: " + saved.getOrderId() + ",";
        obj += "\n  orderStatus: " + saved.getOrderStatus();
        obj += "\n}";

        this.webSocket.convertAndSend("/topic/all", obj);
        return saved;
    }

    // PUT routes
    @PutMapping(value = "orders/{orderId}")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order, @PathVariable int orderId) {
        Optional<Order> orderOptional = orderRepo.findById(orderId);

        if(!orderOptional.isPresent())
            return ResponseEntity.notFound().build();

        order.setOrderId(orderId);
        orderRepo.save(order);

        return ResponseEntity.ok(order);
    }

    // DELETE routes
    @DeleteMapping(value = "orders/{orderId}")
    public void deleteOrder(@PathVariable int orderId) {
        orderRepo.deleteById(orderId);
    }
}
