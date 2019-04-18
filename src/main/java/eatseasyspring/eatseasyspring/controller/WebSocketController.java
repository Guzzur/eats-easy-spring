package eatseasyspring.eatseasyspring.controller;

import eatseasyspring.eatseasyspring.config.Greeting;
import eatseasyspring.eatseasyspring.config.HelloMessage;
import eatseasyspring.eatseasyspring.model.CallWaiter;
import eatseasyspring.eatseasyspring.model.Order;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;



import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.util.HtmlUtils;

/*@Controller
public class WebSocketController {

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;



    @MessageMapping("/message")
    @SendToUser("/queue/reply")
    public String processMessageFromClient(
            @Payload String message,
            Principal principal) throws Exception {
        return "4fd";
    }

}*/

/*@Controller
public class WebSocketController {


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

}*/

/*
@Controller
public class WebSocketController {

    private final SimpMessagingTemplate template;

    @Autowired
    WebSocketController(SimpMessagingTemplate template){
        this.template = template;
    }

    @MessageMapping("/api/send/message")
    public void onReceivedMesage(String message){

        this.template.convertAndSend("/topic",  message);
    }
}*/
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@CrossOrigin(origins = "*")
@Controller
public class WebSocketController {

    @MessageMapping("/socket/orderStatus")
    @SendTo("/Orders/statusUpdate")
    public String OrderStatusUpdate(Order order)
    {
        return (Integer.toString(order.getOrderId()) + order.getOrderStatus());
    }

    @MessageMapping("/socket/newOrder")
    @SendTo("/Orders/new")
    public int NewOrder(Order order)
    {
        return order.getOrderId();
    }

    @MessageMapping("/socket/newCallWaiter")
    @SendTo("/CallWaiter/new")
    public int NewCallWaiter(CallWaiter callWaiter)
    {
        return callWaiter.getCallId();
    }


   /* public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");*/

   /* @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }*/

}