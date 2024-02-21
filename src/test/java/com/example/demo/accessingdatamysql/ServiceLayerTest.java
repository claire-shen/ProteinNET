package com.example.demo.accessingdatamysql;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
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

    @Test
    public void testGetAllUsers() {
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

        // Create a list of users
        List<User> dummyUsers = Arrays.asList(user1, user2, user3);

        // Mock the behavior of the userRepository
        when(userRepository.findAll()).thenReturn(dummyUsers);

        // Call the method under test
        Iterable<User> users = serviceLayer.getAllUsers();

        // Assert the size of the list
        assertThat(users).hasSize(3);
        assertThat(user1.getFirstName()).isEqualTo("John");
    }
}