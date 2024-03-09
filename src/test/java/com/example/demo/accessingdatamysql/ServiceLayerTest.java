package com.example.demo.accessingdatamysql;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class ServiceLayerTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ServiceLayer serviceLayer;

    private static List<User> dummyUsers;

    @BeforeEach
    public void setUp(){
        // Create dummy data
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();

        user1.setFirstName(("John"));
        user2.setFirstName(("Mark"));
        user3.setFirstName(("Sara"));

        user1.setLastName(("Cena"));
        user2.setLastName(("Walter"));
        user3.setLastName(("Thorn"));
        dummyUsers = Arrays.asList(user1, user2, user3);
        when(userRepository.findAll()).thenReturn(dummyUsers); // mocking behaviour of user repository
    }

    @Test
    public void testGetAllUsers() {
        // Call the method under test
        Iterable<User> users = serviceLayer.getAllUsers();

        // Assert the size of the list
        assertThat(users).hasSize(3);
        assertThat(dummyUsers.get(0).getFirstName()).isEqualTo("John");
    }

//    @Test
//    public void addUser(){
//        User newUser = new User();
//        newUser.setFirstName("Helen");
//        serviceLayer.addUser(newUser);
//        Iterable<User> users = serviceLayer.getAllUsers();
//        assertThat(users).hasSize(4);
//    }
}