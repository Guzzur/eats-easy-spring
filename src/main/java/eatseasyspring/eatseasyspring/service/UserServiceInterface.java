package eatseasyspring.eatseasyspring.service;


import java.util.List;

import eatseasyspring.eatseasyspring.model.User;

public interface UserServiceInterface {

    User findById(long id);

    User findByName(String name);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(long id);

    List<User> findAllUsers();

    void deleteAllUsers();

    boolean isUserExist(User user);

}