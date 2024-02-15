package com.example.demo.accessingdatamysql;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class MainControllerTest {
    @Mock
    private ServiceLayer serviceLayer;  // mocks a service layer

    @Mock
    private Model model; // mocks a model

    @InjectMocks
    private MainController mainController; // Those two are then injected into the main controller

    @Test
    public void testGetAllUsers() {
        // Given
        List<User> users = Arrays.asList(new User(), new User());
        when(serviceLayer.getAllUsers()).thenReturn(users); //this should return the list of users

        // When
        String viewName = mainController.getAllUsers(model); //calling the function to test with mock model

        // Then
        assertEquals("index", viewName); // Ensure the correct view name is returned
        verify(model).addAttribute("users", users); // Ensure the model contains the expected "users" attribute
    }

    @Test
    public void updateUser() {

    }

}

