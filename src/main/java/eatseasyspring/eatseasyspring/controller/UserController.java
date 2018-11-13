package eatseasyspring.eatseasyspring.controller;

import java.util.List;

import eatseasyspring.eatseasyspring.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import eatseasyspring.eatseasyspring.model.User;
import eatseasyspring.eatseasyspring.service.UserServiceInterface;
import eatseasyspring.eatseasyspring.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class UserController {

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserServiceInterface userService; //Service which will do all data retrieval/manipulation work

    // -------------------Retrieve All Users---------------------------------------------

    @GetMapping("/user/")
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userService.findAllUsers();
        if (users == null || users.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You may decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    // -------------------Retrieve Single User------------------------------------------

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") long id) {
        logger.info("Fetching User with id {}", id);
        User user = userService.findById(id);
        if (user == null) {
            logger.error("User with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("User with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    // -------------------Create a User-------------------------------------------

    @PostMapping("/user/")
    public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        logger.info("Creating User : {}", user);

        if (userService.isUserExist(user)) {
            logger.error("Unable to create. A User with name {} already exist", user.getName());
            return new ResponseEntity(new CustomErrorType("Unable to create. A User with name " +
                    user.getName() + " already exist."), HttpStatus.CONFLICT);
        }
        userService.saveUser(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    // ------------------- Update a User ------------------------------------------------

    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody User user) {
        logger.info("Updating User with id {}", id);

        User currentUser = userService.findById(id);

        if (currentUser == null) {
            logger.error("Unable to update. User with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to update. User with id " + id +
                    " not found."), HttpStatus.NOT_FOUND);
        }

        currentUser.setName(user.getName());

        userService.updateUser(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }

    // ------------------- Delete a User-----------------------------------------

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting User with id {}", id);

        User user = userService.findById(id);
        if (user == null) {
            logger.error("Unable to delete. User with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to delete. User with id " + id +
                    " not found."), HttpStatus.NOT_FOUND);
        }
        userService.deleteUserById(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

    // ------------------- Delete All Users-----------------------------

    @DeleteMapping("/user/")
    public ResponseEntity<User> deleteAllUsers() {
        logger.info("Deleting All Users");

        userService.deleteAllUsers();
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
}