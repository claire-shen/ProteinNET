package com.example.demo.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import java.util.List;
import java.util.ArrayList;


@Controller
@RequestMapping(value="/index") // This is the controller for the /index URL
public class MainController {

    private ServiceLayer serviceLayer;

    @Autowired
    public MainController(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }

    @GetMapping(value="/all")
    public String getAllUsers(Model model) {
        Iterable<User> users = serviceLayer.getAllUsers();
        model.addAttribute("users", users);
        return "index"; //
    }

    @PostMapping(value="/add")
    public String addNewUser (@ModelAttribute User user) {
        serviceLayer.addUser(user);
        return "redirect:/index/all";
    }

    @PutMapping(value="/update/{id}")
    public String updateUser(@PathVariable Integer id, @ModelAttribute User updateUser) {
        User existingUser = serviceLayer.getUserById(id);
        if (existingUser != null) {
            if (updateUser.getFirstName() != null) {
                existingUser.setFirstName(updateUser.getFirstName());
            }
            if (updateUser.getLastName() != null) {
                existingUser.setLastName(updateUser.getLastName());
            }
            if (updateUser.getAddress() != null) {
                existingUser.setAddress(updateUser.getAddress());
            }
            if (updateUser.getCity() != null) {
                existingUser.setCity(updateUser.getCity());
            }
            if (updateUser.getFreePass() != null) {
                existingUser.setFreePass(updateUser.getFreePass());
            }
            if (updateUser.getFee() != null) {
                existingUser.setFee(updateUser.getFee());
            }
            if (updateUser.getBirthDate() != null) {
                existingUser.setBirthDate(updateUser.getBirthDate());
            }
            if (updateUser.getSquat() != null) {
                existingUser.setSquat(updateUser.getSquat());
            }
            if (updateUser.getDeadlift() != null) {
                existingUser.setDeadlift(updateUser.getDeadlift());
            }
            if (updateUser.getBench() != null) {
                existingUser.setBench(updateUser.getBench());
            }
            if (updateUser.getHeight() != null) {
                existingUser.setHeight(updateUser.getHeight());
            }
            // Save the updated user
            serviceLayer.updateUser(existingUser);
            return "redirect:/index/all";
        } else {
            // Handle case where user with given id doesn't exist
            return "User Id Invalid";
        }
    }

    @DeleteMapping(value="/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        User existingUser = serviceLayer.getUserById(id);
        if (existingUser != null) {
            serviceLayer.deleteUser(id);
            return "redirect:/index/all";
        } else {
            return "User not found";
        }
    }

    @GetMapping(value="/search")
    public String searchUsers(@RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String lastName,
                              Model model) {
        List<User> users;

        // Check if both first name and last name are provided
        if (firstName != null && lastName != null) {
            users = serviceLayer.searchByFirstNameAndLastName(firstName, lastName);
        }
        // Check if only first name is provided
        else if (firstName != null) {
            users = serviceLayer.searchByFirstName(firstName);
        }
        // Check if only last name is provided
        else if (lastName != null) {
            users = serviceLayer.searchByLastName(lastName);
        }
        // If no search parameters provided, retrieve all users
        else {
            Iterable<User> usersIterable = serviceLayer.getAllUsers();
            users = new ArrayList<>();
            usersIterable.forEach(users::add);
        }

        model.addAttribute("users", users);
        return "index";
    }

}