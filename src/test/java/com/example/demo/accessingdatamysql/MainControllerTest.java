package com.example.demo.accessingdatamysql;

import com.example.demo.ProteinNetApplication;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.containsString;


@WebMvcTest
@ContextConfiguration(classes= ProteinNetApplication.class)
public class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean //bean allows your to connect global instances of an object and connect them everywhere
            //avoids having to have a bunch of import statements
    private ServiceLayer serviceLayer;

    private static List<User> users; // static means it's associated with this class
    @BeforeAll
    static void setUp() {
        users = new ArrayList<>();

        User userOne = new User();
        userOne.setLastName("Doe");
        userOne.setFirstName("John");
        userOne.setBirthDate(LocalDate.of(1999, 1, 1));
        userOne.setHeight("6'2");
        userOne.setCity("New York");
        userOne.setSquat(200);
        userOne.setBench(180);
        userOne.setDeadlift(250);
        users.add(userOne);

        User userTwo = new User();
        userTwo.setLastName("Scott");
        userTwo.setFirstName("Mike");
        userTwo.setBirthDate(LocalDate.of(1997, 2, 20));
        userTwo.setHeight("6'1");
        userTwo.setCity("Mississauga");
        userTwo.setSquat(210);
        userTwo.setBench(190);
        userTwo.setDeadlift(260); // Fixed assignment for userTwo
        users.add(userTwo); // Corrected adding userTwo to users list


        User userThree = new User();
        userThree.setLastName("Johnson");
        userThree.setFirstName("Emily");
        userThree.setBirthDate(LocalDate.of(2000, 5, 15));
        userThree.setHeight("5'10");
        userThree.setCity("Los Angeles");
        userThree.setSquat(190);
        userThree.setBench(170);
        userThree.setDeadlift(220);
        users.add(userThree);
    }
@Test
public void testGetAllUsers() throws Exception {
    Mockito.when(serviceLayer.getAllUsers()).thenReturn(users);

    mockMvc.perform(get("/index/all")).andExpect(status().isOk())
            .andExpect(content().string(containsString("John")))
            .andExpect(content().string(containsString("New York")))
            .andExpect(content().string(containsString("200")))
            .andExpect(content().string(containsString("180")))
            .andExpect(content().string(containsString("250")));
    }


@Test
public void testAddNewUser() throws Exception {
    User newUser = new User();
    newUser.setLastName("North");
    newUser.setFirstName("Selene");
    newUser.setBirthDate(LocalDate.of(1999, 1, 1));
    newUser.setHeight("6'2");
    newUser.setCity("Chicago");
    newUser.setSquat(200);
    newUser.setBench(180);
    newUser.setDeadlift(250);
    users.add(newUser);

    Mockito.doNothing().when(serviceLayer).addUser(newUser);

    mockMvc.perform(post("/index/add"))
            .andExpect(redirectedUrl("/index/all"));
}





}
