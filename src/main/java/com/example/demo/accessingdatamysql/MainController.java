package com.example.demo.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;


@Controller
@RequestMapping(value="/index") // This means URL's start with /demo (after Application path)
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
        return "index"; // Thymeleaf template name (allUsers.html)
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

}