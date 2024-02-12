package com.example.demo.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceLayer {
    private final UserRepository userRepository;

    @Autowired
    public ServiceLayer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public void updateUser(User updateUser) {
        userRepository.save(updateUser);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

}