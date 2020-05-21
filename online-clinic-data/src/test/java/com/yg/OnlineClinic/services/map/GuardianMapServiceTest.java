package com.yg.OnlineClinic.services.map;

import com.yg.OnlineClinic.model.Guardian;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

//https://springframework.guru/gang-of-four-design-patterns/builder-pattern/
class GuardianMapServiceTest {

    GuardianMapService guardianMapService;

    final Long guardianId=1L;
    final String lastName="Smith";

    // Mimicking what spring would have done
    @BeforeEach
    void setUp() {
        guardianMapService=new GuardianMapService(new PetTypeMapService(),new PetMapService());
        guardianMapService.save(Guardian.builder().id(guardianId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Guardian>guardianSet= guardianMapService.findAll();

        assertEquals(1,guardianSet.size());
    }

    @Test
    void findById() {

        Guardian guardian=guardianMapService.findById(guardianId);
        assertEquals(guardianId,guardian.getId());
    }

    @Test
    void saveExistingId() {
        Long id2=2L;
        Guardian guardian2=Guardian.builder().id(id2).build();
        Guardian savedGuardian=guardianMapService.save(guardian2);
        assertEquals(id2,savedGuardian.getId());
    }

    @Test
    void saveNoId() {

        Guardian savedGuardian=guardianMapService.save(Guardian.builder().build());

        assertNotNull(savedGuardian);
        assertNotNull(savedGuardian.getId());
    }

    @Test
    void findByLastName() {

        Guardian smith=guardianMapService.findByLastName(lastName);
        assertNotNull(smith);
        assertEquals(guardianId,smith.getId());
    }

   @Test
    void findByLastNameNotFound() {
        Guardian smith1=guardianMapService.findByLastName("foo");
        assertNull(smith1);
    }

    @Test
    void delete() {
        guardianMapService.delete(guardianMapService.findById(guardianId));
        assertEquals(0,guardianMapService.findAll().size());
    }

    @Test
    void deleteById() {
        guardianMapService.deleteById(guardianId);
        assertEquals(0,guardianMapService.findAll().size());
    }
}