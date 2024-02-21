package com.example.demo.accessingdatamysql;

import com.example.demo.ProteinNetApplication;
import com.example.demo.accessingdatamysql.MainController;
import com.example.demo.accessingdatamysql.ServiceLayer;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.demo.accessingdatamysql.User;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.containsString;


@WebMvcTest
@ContextConfiguration(classes= ProteinNetApplication.class)
public class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceLayer serviceLayer;

@Test
public void testGetAllUsers() throws Exception {

    List<User> users = new ArrayList<>();
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

    Mockito.when(serviceLayer.getAllUsers()).thenReturn(users);

    mockMvc.perform(get("/index/all")).andExpect(status().isOk())
            .andExpect(content().string(containsString("John Doe")))
            .andExpect(content().string(containsString("New York")))
            .andExpect(content().string(containsString("200")))
            .andExpect(content().string(containsString("180")))
            .andExpect(content().string(containsString("250")));
    }
}
