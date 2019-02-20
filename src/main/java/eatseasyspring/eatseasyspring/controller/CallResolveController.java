package eatseasyspring.eatseasyspring.controller;


import eatseasyspring.eatseasyspring.model.CallResolve;
import eatseasyspring.eatseasyspring.repository.CallResolveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@CrossOrigin(origins = "*")
@RestController
public class CallResolveController {
    @Autowired
    private CallResolveRepo callResolveRepo;

    // GET routes
    @GetMapping(value = "callresolve")
    public List<CallResolve> getAllCallsResolved() {
        return callResolveRepo.findAll();
    }

    // POST routes
    @PostMapping(value = "callresolve")
    public CallResolve addCallResolved(@RequestBody CallResolve callResolve) {
        return callResolveRepo.save(callResolve);
    }

    // PUT routes
    @PutMapping(value = "callresolve/{callResolveId}")
    public ResponseEntity<CallResolve> updateCallResolve(@RequestBody CallResolve callResolve, @PathVariable int callResolveId) {
        Optional<CallResolve> callResolveOptional = callResolveRepo.findById(callResolveId);

        if(!callResolveOptional.isPresent())
            return ResponseEntity.notFound().build();

        callResolve.setCallResolveId(callResolveId);
        callResolveRepo.save(callResolve);

        return ResponseEntity.ok(callResolve);
    }

    // DELETE routes
    @DeleteMapping(value = "callresolve/{callResolveId}")
    public void deleteCallResolve(@PathVariable int callResolveId) {
        callResolveRepo.deleteById(callResolveId);
    }

}