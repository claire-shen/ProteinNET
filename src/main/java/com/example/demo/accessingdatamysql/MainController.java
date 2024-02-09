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
        //return "user added";
    }


//    @PostMapping(value="/add")
//    public String addNewUser (@ModelAttribute User user) {
//        userRepository.addUser(user);
//        return "redirect:/index/all"; // Redirect to the endpoint to display all users
//    }

//
//    @PostMapping(value="/add") // Map ONLY POST Requests
//    public @ResponseBody String addNewUser (
//            @RequestParam String lastName,
//            @RequestParam String firstName,
//            @RequestParam String address,
//            @RequestParam String city,
//            @RequestParam Boolean freePass,
//            @RequestParam Integer squat,
//            @RequestParam Integer bench,
//            @RequestParam Integer deadlift,
//            @RequestParam String height,
//            @RequestParam Float fee,
//            @RequestParam("birthDate")
//            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthDate) {
//
//
//        // Create a new User object and set its properties
//        User user = new User();
//        user.setFirstName(firstName);
//        user.setLastName(lastName);
//        user.setAddress(address);
//        user.setCity(city);
//        user.setFreePass(freePass);
//        user.setFee(fee);
//        user.setSquat(squat);
//        user.setBench(bench);
//        user.setDeadlift(deadlift);
//        user.setHeight(height);
//        user.setBirthDate(birthDate);
//
//        // Save the user object to the database
//        userRepository.save(user);
//
//        // Return a response
//        return "User saved successfully!";
//    }
//
//    //return everything
//    @GetMapping(value="/all")
//    public @ResponseBody Iterable<User> getAllUsers() {
//        // This returns a JSON or XML with the users
//        return userRepository.findAll();
//    }
//
//    @GetMapping("/data")
//    public String getData(Model model) {
//
//
//        return "index";
//    }
}