package com.alura.jornadaMilhas.services;

import com.alura.jornadaMilhas.entities.Testimony;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alura.jornadaMilhas.repositories.TestimonyRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TestimonyService {
    @Autowired
    TestimonyRepository testimonyRepository;

    public Testimony create(Testimony testimony){
        testimonyRepository.save(testimony);
        return testimony;
    }
    public Testimony findOne(Long id){
        Optional<Testimony> testimony = testimonyRepository.findById(id);
        return testimony.get();
    }
    public List<Testimony> findAll(){
        return testimonyRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }

    public List<Testimony> selectRandomTestimony(Integer quantity){
        List testimonies = findAll();
        if ( testimonies.size() < quantity )
            quantity = testimonies.size();
        Collections.shuffle(testimonies);
        return testimonies.subList(0,quantity);
    }

    public Testimony update(Testimony testimony){
        testimonyRepository.save(testimony);
        return testimony;
    }

    public void deleteById(Long id){
        testimonyRepository.deleteById(id);
    }


}
