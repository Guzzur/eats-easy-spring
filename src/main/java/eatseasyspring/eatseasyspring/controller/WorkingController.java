package eatseasyspring.eatseasyspring.controller;


import eatseasyspring.eatseasyspring.model.Shift;
import eatseasyspring.eatseasyspring.model.Working;
import eatseasyspring.eatseasyspring.repository.ShiftRepo;
import eatseasyspring.eatseasyspring.repository.WorkingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@CrossOrigin(origins = "*")
@RestController
public class WorkingController {
    @Autowired
    private WorkingRepo workingRepo;

    // GET routes
    @GetMapping(value = "working")
    public List<Working> getAllWorking() {
        return workingRepo.findAll();
    }

    // POST routes
    @PostMapping(value = "working")
    public Working addWorking(@RequestBody Working working) {
        return workingRepo.save(working);
    }

    // PUT routes
    @PutMapping(value = "working/{workingId}")
    public ResponseEntity<Working> updateWorking(@RequestBody Working working, @PathVariable int workingId) {
        Optional<Working> workingOptional = workingRepo.findById(workingId);

        if(!workingOptional.isPresent())
            return ResponseEntity.notFound().build();

        working.setWorkingId(workingId);
        workingRepo.save(working);

        return ResponseEntity.ok(working);
    }

    // DELETE routes
    @DeleteMapping(value = "working/{workingId}")
    public void deleteWorking(@PathVariable int workingId) {
        workingRepo.deleteById(workingId);
    }

}