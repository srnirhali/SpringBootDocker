package com.example.demo.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AuthControllerTest {

    @Autowired
    private MockMvc api;

    @Test
    public  void testLoginFails() throws Exception {
        api.perform(get("/auth/details"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser
    public  void testLoginSuccess() throws Exception {
        api.perform(get("/auth/details"))
                .andExpect(status().isOk());
    }

}
