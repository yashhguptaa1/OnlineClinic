package com.yg.OnlineClinic.services.springdatajpa;

import com.yg.OnlineClinic.model.Guardian;
import com.yg.OnlineClinic.repositories.GuardianRepository;
import com.yg.OnlineClinic.repositories.PetRepository;
import com.yg.OnlineClinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class GuardianSDJpaServiceTest {

    @Mock
    GuardianRepository guardianRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    GuardianSDJpaService guardianSDJpaService;

    Guardian returnGuardian;
    String LAST_NAME="Smith";


    @BeforeEach
    void setUp() {
        returnGuardian=Guardian.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        returnGuardian=Guardian.builder().id(1L).lastName("Smith").build();

        when(guardianSDJpaService.findByLastName(any())).thenReturn(returnGuardian);
        Guardian smith =guardianSDJpaService.findByLastName("Smith");

        assertEquals("Smith",smith.getLastName());

        verify(guardianRepository).findByLastName(any());

    }

    @Test
    void findAll() {

        Set<Guardian> returnGuardianSet=new HashSet<>();
        returnGuardianSet.add(Guardian.builder().id(1L).build());
        returnGuardianSet.add(Guardian.builder().id(2L).build());

        when(guardianRepository.findAll()).thenReturn(returnGuardianSet);

        Set<Guardian>guardians=guardianSDJpaService.findAll();

        assertNotNull(guardians);
        assertEquals(2,guardians.size());

    }

    @Test
    void findById() {


        when(guardianRepository.findById(anyLong())).thenReturn(Optional.of(returnGuardian));
        Guardian guardian=guardianSDJpaService.findById(1L);

        assertNotNull(guardian);

    }

    @Test
    void findByIdNotFound()
    {
        when(guardianRepository.findById(anyLong())).thenReturn(Optional.empty());

        Guardian guardian=guardianSDJpaService.findById(1L);

        assertNull(guardian);
    }

    @Test
    void save() {
        Guardian guardianToSave= Guardian.builder().id(1L).build();

        //save any object
        when(guardianRepository.save(any())).thenReturn(returnGuardian);

        Guardian savedGuardian=guardianSDJpaService.save(guardianToSave);

        assertNotNull(savedGuardian);

        verify(guardianRepository).save(any());
    }

    @Test
    void delete() {
        guardianSDJpaService.delete(returnGuardian);

        //default is 1 times
        verify(guardianRepository,times(1)).delete(any());

    }

    @Test
    void deleteById() {
        guardianSDJpaService.deleteById(1L);

        verify(guardianRepository).deleteById(anyLong());
    }
}

