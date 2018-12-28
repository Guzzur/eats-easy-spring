package eatseasyspring.eatseasyspring.service;

import eatseasyspring.eatseasyspring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
}
