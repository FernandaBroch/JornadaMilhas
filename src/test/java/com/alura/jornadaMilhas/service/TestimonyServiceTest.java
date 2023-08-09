package com.alura.jornadaMilhas.service;

import com.alura.jornadaMilhas.entities.Testimony;
import com.alura.jornadaMilhas.repositories.TestimonyRepository;
import com.alura.jornadaMilhas.services.TestimonyService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class TestimonyServiceTest {
    @Autowired
    TestimonyService testimonyService;
    @MockBean
    TestimonyRepository testimonyRepository;
    public List<Testimony> setScenery(){
        List<Testimony> testimonyList = new ArrayList<>();

        Testimony testimony = new Testimony();
        testimony.setId(1L);
        testimony.setCustomerName("Xera");
        testimony.setDescription("Go ahead—make the first move.");
        testimony.setPicture("https://wiki.guildwars2.com/images/5/53/Xera_%28Illusion%29.jpg");
        testimonyList.add(testimony);

        Testimony testimony2 = new Testimony();
        testimony2.setId(2L);
        testimony2.setCustomerName("Mathias Gabrel");
        testimony2.setDescription("I am the scythe, the bringer of salvation.");
        testimony2.setPicture("https://wiki.guildwars2.com/images/2/28/Matthias_abomination.jpg");
        testimonyList.add(testimony2);

        Testimony testimony3 = new Testimony();
        testimony3.setId(3L);
        testimony3.setCustomerName("Saul D'Alessio");
        testimony3.setDescription("All I wanted was Kryta to be free");
        testimony3.setPicture("https://wiki.guildwars2.com/images/e/ec/The_Prisoner.jpg");
        testimonyList.add(testimony3);

        Testimony testimony4 = new Testimony();
        testimony4.setId(4L);
        testimony4.setCustomerName("Sabetha the Saboteur");
        testimony4.setDescription("Useless! What do I pay you for?");
        testimony4.setPicture("https://wiki.guildwars2.com/images/4/48/Sabetha_the_Saboteur.jpg");
        testimonyList.add(testimony4);

        return testimonyList;

    }
    @Test
    public void givenAListOfTestimoniesWhenSelectShouldReturnARandomList(){
        List<Testimony> testimonyList = setScenery();

        Mockito.when(testimonyRepository.findAll()).thenReturn(testimonyList);

        List<Testimony> randomTestimonyList = testimonyService.selectRandomTestimony(3);

        assertThat(randomTestimonyList).isNotEqualTo(testimonyList);

    }
    @Test
    public void givenAListOfTestimoniesWhenSelectThreeShouldReturnARandomListWithThree(){
        List<Testimony> testimonyList = setScenery();
        Integer listSize = 3;

        Mockito.when(testimonyRepository.findAll()).thenReturn(testimonyList);

        List<Testimony> randomTestimonyList = testimonyService.selectRandomTestimony(listSize);

        assertThat(randomTestimonyList.size()).isEqualTo(listSize);

    }
}
