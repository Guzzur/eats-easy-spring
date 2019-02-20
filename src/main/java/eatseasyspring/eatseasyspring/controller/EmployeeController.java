package eatseasyspring.eatseasyspring.controller;


import eatseasyspring.eatseasyspring.model.Employee;
import eatseasyspring.eatseasyspring.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@CrossOrigin(origins = "*")
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepo employeeRepo;

    // GET routes
    @GetMapping(value = "employees")
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    // POST routes
    @PostMapping(value = "employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepo.save(employee);
    }

    // PUT routes
    @PutMapping(value = "employees/{employeeId}")
    public ResponseEntity<Employee> updateEmployees(@RequestBody Employee employee, @PathVariable int employeeId) {
        Optional<Employee> employeeOptional = employeeRepo.findById(employeeId);

        if(!employeeOptional.isPresent())
            return ResponseEntity.notFound().build();

        employee.setEmployeeId(employeeId);
        employeeRepo.save(employee);

        return ResponseEntity.ok(employee);
    }

    // DELETE routes
    @DeleteMapping(value = "employees/{employeeId}")
    public void deleteEmployees(@PathVariable int employeeId) {
        employeeRepo.deleteById(employeeId);
    }

}