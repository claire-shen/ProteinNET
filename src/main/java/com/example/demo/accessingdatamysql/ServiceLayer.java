package com.example.demo.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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

    public List<User> searchByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    public List<User> searchByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    public List<User> searchByFirstNameAndLastName(String firstName, String lastName) {
        return userRepository.findByFirstNameAndLastName(firstName, lastName);
    }
}