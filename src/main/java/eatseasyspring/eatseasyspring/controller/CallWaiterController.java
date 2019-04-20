package eatseasyspring.eatseasyspring.controller;


import eatseasyspring.eatseasyspring.model.CallWaiter;
import eatseasyspring.eatseasyspring.repository.CallWaiterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@CrossOrigin(origins = "*")
@RestController
public class CallWaiterController {
    @Autowired
    private SimpMessagingTemplate webSocket;

    @Autowired
    private CallWaiterRepo callWaiterRepo;

    // GET routes
    @GetMapping(value = "callwaiter")
    public List<CallWaiter> getAllCallsForWaiter() {
        return callWaiterRepo.findAll();
    }

    // POST routes
    @PostMapping(value = "callwaiter")
    public CallWaiter addWaiterCall(@RequestBody CallWaiter callWaiter) {
        CallWaiter saved = callWaiterRepo.save(callWaiter);

        String obj = "{";
        obj += "\n  \"type\": " + "\"callWaiter\"" + ",";
        obj += "\n  \"callId\": " + "\"" + saved.getCallId() + "\"" +  ",";
        obj += "\n  \"reason\": " + "\"" + saved.getReason() + "\"";
        obj += "\n}";

        this.webSocket.convertAndSend("/topic/all", obj);
        return saved;
    }

    // PUT routes
    @PutMapping(value = "callwaiter/{callWaiterId}")
    public ResponseEntity<CallWaiter> updateWaiterCall(@RequestBody CallWaiter callWaiter, @PathVariable int callWaiterId) {
        Optional<CallWaiter> callWaiterOptional = callWaiterRepo.findById(callWaiterId);

        if(!callWaiterOptional.isPresent())
            return ResponseEntity.notFound().build();

        callWaiter.setCallId(callWaiterId);
        callWaiterRepo.save(callWaiter);

        return ResponseEntity.ok(callWaiter);
    }

    // DELETE routes
    @DeleteMapping(value = "callwaiter/{callWaiterId}")
    public void deleteCallWaiter(@PathVariable int callWaiterId) {
        callWaiterRepo.deleteById(callWaiterId);
    }

}