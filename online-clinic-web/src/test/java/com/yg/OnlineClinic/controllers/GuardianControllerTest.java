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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
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
    void findGuardians() throws Exception {

        mockMvc.perform(get("/guardians/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("guardians/findGuardians"))
                .andExpect(model().attributeExists("guardian"));

        verifyNoInteractions(guardianService);
    }

    @Test
    void processFindFormReturnMany() throws Exception {
        when(guardianService.findAllByLastNameLike(anyString()))
                .thenReturn(Arrays.asList(Guardian.builder().id(1l).build(),
                        Guardian.builder().id(2l).build()));

        mockMvc.perform(get("/guardians"))
                .andExpect(status().isOk())
                .andExpect(view().name("guardians/guardiansList"))
                .andExpect(model().attribute("selections", hasSize(2)));
    }

    @Test
    void processFindFormReturnOne() throws Exception {
        when(guardianService.findAllByLastNameLike(anyString())).thenReturn(Arrays.asList(Guardian.builder().id(1l).build()));

        mockMvc.perform(get("/guardians"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/guardians/1"));
    }


    @Test
    void displayOwner() throws Exception {

        when(guardianService.findById(anyLong())).thenReturn(Guardian.builder().id(1L).build());

        mockMvc.perform(get("/guardians/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("guardians/guardianDetails"))
                .andExpect(model().attribute("guardian",hasProperty("id",is(1L))));

    }

}