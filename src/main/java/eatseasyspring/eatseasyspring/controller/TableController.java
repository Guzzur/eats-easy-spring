package eatseasyspring.eatseasyspring.controller;

import eatseasyspring.eatseasyspring.model.TableClass;
import eatseasyspring.eatseasyspring.repository.TableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@CrossOrigin(origins = "*")
@RestController
public class TableController {
    @Autowired
    private TableRepo tableRepo;

    // GET routes
    @GetMapping(value = "tables")
    public List<TableClass> getAllTables() {
        return tableRepo.findAll();
    }

    @GetMapping(value = "tables/{tableId}")
    public Optional<TableClass> getTableById(@PathVariable("tableId") int tableId) {
        return tableRepo.findById(tableId);
    }

    // POST routes
    @PostMapping(value = "tables")
    public TableClass addTable(@RequestBody TableClass table) {
        return tableRepo.save(table);
    }

    // PUT routes
    @PutMapping(value = "tables/{tableId}")
    public ResponseEntity<TableClass> updateTable(@RequestBody TableClass table, @PathVariable int tableId) {
        Optional<TableClass> tableOptional = tableRepo.findById(tableId);

        if(!tableOptional.isPresent())
            return ResponseEntity.notFound().build();

        table.setTableId(tableId);
        tableRepo.save(table);

        return ResponseEntity.ok(table);
    }

    // DELETE routes
    @DeleteMapping(value = "tables/{tableId}")
    public void deleteTable(@PathVariable int tableId) {
        tableRepo.deleteById(tableId);
    }
}
