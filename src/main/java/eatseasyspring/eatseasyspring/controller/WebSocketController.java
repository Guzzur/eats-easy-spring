package eatseasyspring.eatseasyspring.controller;

import eatseasyspring.eatseasyspring.model.CallWaiter;
import eatseasyspring.eatseasyspring.model.Order;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.util.HtmlUtils;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class WebSocketController {
    @MessageMapping("/socket/orderStatus")
    @SendTo("/orders/statusUpdate")
    public String OrderStatusUpdate(Order order)
    {
        return (Integer.toString(order.getOrderId()) + order.getOrderStatus());
    }

    @MessageMapping("/socket/newOrder")
    @SendTo("/orders/new")
    public int NewOrder(Order order)
    {
        return order.getOrderId();
    }

    @MessageMapping("/socket/newCallWaiter")
    @SendTo("/callWaiter/new")
    public int NewCallWaiter(CallWaiter callWaiter)
    {
        return callWaiter.getCallId();
    }

    @MessageMapping("/all")
    @SendTo("/topic/all")
    public String post(@Payload String message) {
        return message;
    }
}