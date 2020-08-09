package com.vtb.zolotarev.spring.boot.services;

import com.vtb.zolotarev.spring.boot.exceptions.ObjectNotFoundException;
import com.vtb.zolotarev.spring.boot.model.User;
import com.vtb.zolotarev.spring.boot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
         return userRepository.save(user);
    }

    public User findUserById(long id) {
        return userRepository.findById(id).orElseThrow(ObjectNotFoundException::new);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }
}
