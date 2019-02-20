package eatseasyspring.eatseasyspring.controller;


import eatseasyspring.eatseasyspring.model.CallWaiter;
import eatseasyspring.eatseasyspring.repository.CallWaiterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@CrossOrigin(origins = "*")
@RestController
public class CallWaiterController {
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
        return callWaiterRepo.save(callWaiter);
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