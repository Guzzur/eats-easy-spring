package eatseasyspring.eatseasyspring.controller;

import java.util.*;

import java.net.URI;


import com.github.tennaito.rsql.jpa.JpaCriteriaQueryVisitor;
import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import cz.jirutka.rsql.parser.ast.RSQLVisitor;
import eatseasyspring.eatseasyspring.model.Dish;
import eatseasyspring.eatseasyspring.model.TableClass;
import eatseasyspring.eatseasyspring.repository.TableRepo;
import eatseasyspring.eatseasyspring.service.RestaurantService;
import org.hibernate.annotations.Tables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import eatseasyspring.eatseasyspring.repository.DishRepo;
import eatseasyspring.eatseasyspring.model.Restaurant;
import eatseasyspring.eatseasyspring.repository.RestaurantRepo;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

@RequestMapping("/api")
@CrossOrigin(origins = "*")
@RestController
public class RestaurantController {
    @Autowired
    private TableRepo tableRepo;
    @Autowired
    private RestaurantRepo restRepo;
    @Autowired
    private DishRepo dishRepo;
    @Autowired
    private RestaurantService restaurantService;

    @PersistenceContext
    EntityManager manager;
    RSQLVisitor<CriteriaQuery<Restaurant>, EntityManager> visitor = new JpaCriteriaQueryVisitor<Restaurant>();

    // GET routes
    @GetMapping(value = "restaurants")
    public Iterable<Restaurant> getAllRestaurants() {
        return restRepo.findAll();
    }


    @GetMapping(value = "restaurants/filtered")
    public List<Restaurant> findAllByRsql(@RequestParam(value = "search") String search) {
    Node rootNode = new RSQLParser().parse(search);
    CriteriaQuery<Restaurant> query = rootNode.accept(visitor, manager);
    query.getOrderList();
    return manager.createQuery(query).getResultList();
    }


    @GetMapping(value = "restaurants/{restId}")
    public Optional<Restaurant> getRestaurantById(@PathVariable("restId") int restId) {
        return restRepo.findById(restId);
    }

    @GetMapping(value = "restaurants/{restId}/menu")
    public List<Dish> getMenu(@PathVariable("restId") int restId) {
        return dishRepo.findDishesByRestId(restId);
    }

    @GetMapping(value = "restaurants/{restId}/freeTables")
    public List<TableClass> getFreeTables(@PathVariable("restId") int restId) {
        return tableRepo.findAllByRestIdAndUserIdAtTableNull(restId);
    }


    // POST routes
    @PostMapping(value = "restaurants")
    public Restaurant addRest(@RequestBody Restaurant restaurant) {
        return restRepo.save(restaurant);
    }

    // PUT routes
    @PutMapping(value = "restaurants/{restId}")
    public ResponseEntity<Restaurant> updateRest(@RequestBody Restaurant restaurant, @PathVariable int restId) {
        Optional<Restaurant> restaurantOptional = restRepo.findById(restId);

        if(!restaurantOptional.isPresent())
            return ResponseEntity.notFound().build();

        restaurant.setRestaurantId(restId);
        restRepo.save(restaurant);

        return ResponseEntity.ok(restaurant);
    }

    // DELETE routes
    @DeleteMapping(value = "restaurants/{restId}")
    public void deleteRest(@PathVariable int restId) {
        restRepo.deleteById(restId);
    }
}
