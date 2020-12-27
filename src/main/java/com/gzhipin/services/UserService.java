package com.gzhipin.services;

import com.gzhipin.beans.User;
import com.gzhipin.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public void createUser(User user){
        this.userRepository.save(user);
    }
}
