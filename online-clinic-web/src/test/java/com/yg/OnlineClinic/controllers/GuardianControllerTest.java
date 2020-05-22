package com.yg.OnlineClinic.controllers;

import com.yg.OnlineClinic.model.Guardian;
import com.yg.OnlineClinic.services.GuardianService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;



@ExtendWith(MockitoExtension.class)
class GuardianControllerTest {

    GuardianService guardianService;
    GuardianController controller;

    Set<Guardian>guardians;

    //initializing spring mvc
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        guardians=new HashSet<>();
        guardians.add(Guardian.builder().id(1L).build());
        guardians.add((Guardian.builder().id(2L).build()));

        mockMvc= MockMvcBuilders.standaloneSetup(controller).build();

    }

    @Test
    void listGuardians() {


    }

    @Test
    void findGuardians() {
    }
}