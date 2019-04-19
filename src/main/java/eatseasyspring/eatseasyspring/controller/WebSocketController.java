package eatseasyspring.eatseasyspring.controller;
import eatseasyspring.eatseasyspring.model.CallWaiter;
import eatseasyspring.eatseasyspring.model.Order;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketController {
    //    @MessageMapping("/orderStatus")
    //    @SendTo("/orders/statusUpdate")
    //    public String OrderStatusUpdate(Order order)
    //    {
    //        return (Integer.toString(order.getOrderId()) + order.getOrderStatus());
    //    }
    //
    //    @MessageMapping("/newOrder")
    //    @SendTo("/orders/new")
    //    public int NewOrder(Order order)
    //    {
    //        return order.getOrderId();
    //    }
    //
    //    @MessageMapping("/newCallWaiter")
    //    @SendTo("/callWaiter/new")
    //    public int NewCallWaiter(CallWaiter callWaiter)
    //    {
    //        return callWaiter.getCallId();
    //    }

    @MessageMapping("/all")
    @SendTo("/topic/all")
    public String post(@Payload String message) {
        return message;
    }
}