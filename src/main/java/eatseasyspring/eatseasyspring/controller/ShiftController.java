package eatseasyspring.eatseasyspring.controller;


import eatseasyspring.eatseasyspring.model.Shift;
import eatseasyspring.eatseasyspring.repository.ShiftRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@CrossOrigin(origins = "*")
@RestController
public class ShiftController {
    @Autowired
    private ShiftRepo shiftRepo;

    // GET routes
    @GetMapping(value = "shifts")
    public List<Shift> getAllShifts() {
        return shiftRepo.findAll();
    }

    // POST routes
    @PostMapping(value = "shifts")
    public Shift addShift(@RequestBody Shift shift) {
        return shiftRepo.save(shift);
    }

    // PUT routes
    @PutMapping(value = "shifts/{shiftId}")
    public ResponseEntity<Shift> updateShift(@RequestBody Shift shift, @PathVariable int shiftId) {
        Optional<Shift> shiftOptional = shiftRepo.findById(shiftId);

        if(!shiftOptional.isPresent())
            return ResponseEntity.notFound().build();

        shift.setShiftId(shiftId);
        shiftRepo.save(shift);

        return ResponseEntity.ok(shift);
    }

    // DELETE routes
    @DeleteMapping(value = "shifts/{shiftId}")
    public void deleteShift(@PathVariable int shiftId) {
        shiftRepo.deleteById(shiftId);
    }

}