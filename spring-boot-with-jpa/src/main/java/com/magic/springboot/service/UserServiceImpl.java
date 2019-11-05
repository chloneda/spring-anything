package com.magic.springboot.service;

import com.magic.springboot.model.User;
import com.magic.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Created by chloneda
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User createUser(User user) {
        User u = userRepository.saveAndFlush(user);
        return u;
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User updateUser(User user) {
        Optional<User> userOptional = userRepository.findById(user.getId());
        if (userOptional.isPresent()) {
            User userObj = userOptional.get();
            userObj.setUsername(user.getUsername());
            userObj.setPassword(user.getPassword());
            userObj.setSex(user.getSex());
            return userRepository.saveAndFlush(userObj);
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> userList=userRepository.findAll();
        return userList;
    }

}
