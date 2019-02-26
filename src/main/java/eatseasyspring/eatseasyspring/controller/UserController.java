package eatseasyspring.eatseasyspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import eatseasyspring.eatseasyspring.model.User;
import eatseasyspring.eatseasyspring.repository.UserRepo;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@CrossOrigin(origins = "*")
@RestController
public class UserController {
    @Autowired
    private UserRepo userRepo;

    // GET routes
    @GetMapping(value = "users")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @GetMapping(value = "users/{userId}")
    public Optional<User> getUserById(@PathVariable int userId) {
        return userRepo.findById(userId);
    }

    // POST routes
    @PostMapping(value = "users")
    public User addUser(@RequestBody User user) {
        return userRepo.save(user);
    }

    //signIn returns userId if the user successfully signed in, if user doesn't exist, the return value is -100
/*
    @PostMapping(value = "users/signin")
    public int userSignIn(@RequestBody String phone,String hashedPass) {
        if (userRepo.findUserByPhoneAndHashedPasswd(phone,hashedPass) == null)
            return -100;
        return userRepo.findUserByPhoneAndHashedPasswd(phone,hashedPass).getUserID();

    }
*/

    @PostMapping(value = "users/signin")
    public int userSignIn(@RequestBody User user) {
        if (userRepo.findUserByPhoneAndHashedPasswd(user.getPhone(),user.getHashedPasswd()) == null)
            return -100;
        return (userRepo.findUserByPhoneAndHashedPasswd(user.getPhone(),user.getHashedPasswd()).getUserID());

    }

    //signUp returns userId if the user successfully signed up, if user already exists, the return value is -100
    @PostMapping(value = "users/signup")
    public int userSignUp(@RequestBody User user) {
        if (userRepo.findUserByPhoneAndHashedPasswd(user.getPhone(),user.getHashedPasswd()) != null)
            return -100;
        return userRepo.save(user).getUserID();
    }


    // PUT routes
    @PutMapping(value = "users/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable int userId) {
        Optional<User> dishOptional = userRepo.findById(userId);

        if(!dishOptional.isPresent())
            return ResponseEntity.notFound().build();

        user.setUserID(userId);
        userRepo.save(user);

        return ResponseEntity.ok(user);
    }

    // DELETE routes
    @DeleteMapping(value = "users/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userRepo.deleteById(userId);
    }
}
