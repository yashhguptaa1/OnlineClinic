package com.yg.OnlineClinic.controllers;

import com.yg.OnlineClinic.model.Guardian;
import com.yg.OnlineClinic.services.GuardianService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(MockitoExtension.class)
class GuardianControllerTest {

    @Mock
    GuardianService guardianService;

    @InjectMocks
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
    void listGuardians() throws Exception {

        when(guardianService.findAll()).thenReturn(guardians);
        mockMvc.perform(get("/guardians"))
                .andExpect(status().is(200))
                .andExpect(view().name("guardians/index"))
                .andExpect(model().attribute("guardians",hasSize(2)));

    }


    @Test
    void findGuardians() throws Exception {

        mockMvc.perform(get("/guardians/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("notimplemented"));

        //verifyZeroInteractions(guardianService);
    }
}