package com.alura.jornadaMilhas.controllers;

import com.alura.jornadaMilhas.entities.Testimony;
import com.alura.jornadaMilhas.services.TestimonyService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping( "depoimentos" )
public class TestimonyController {
    @Autowired
    private TestimonyService testimonyService;

    @PostMapping
    @ApiResponse(responseCode = "201" )
    public ResponseEntity<Long> create(@RequestBody Testimony testimony){
        Testimony testimonyResponse = testimonyService.create(testimony);
        return ResponseEntity.status(HttpStatus.CREATED).body(testimonyResponse.getId());
    }
    
    @GetMapping
    @ApiResponse(responseCode = "200")
    public ResponseEntity<List<Testimony>> getTestimonies() {
        List<Testimony> testimonyList = testimonyService.findAll();
        if(testimonyList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(testimonyList);
    }

    @GetMapping( "/depoimentos-home" )
    @ApiResponse(responseCode = "200")
    public ResponseEntity<List<Testimony>> getRandomTestimony(){
        List<Testimony> testimonyList = testimonyService.selectRandomTestimony(3);
        if(testimonyList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(testimonyList);
    }

    @PutMapping("/{id}" )
    @ApiResponse(responseCode = "200")
    public ResponseEntity<Long> updateTestimony(@PathVariable(name ="id") Long id, @RequestBody Testimony testimony ){
        testimony.setId(id);
        Testimony testimonyUpdated = testimonyService.update(testimony);
        return ResponseEntity.status(HttpStatus.OK).body(testimonyUpdated.getId());
    }

    @DeleteMapping( "/{id}" )
    @ApiResponse(responseCode = "200")
    public ResponseEntity<String> deleteTestimony(@PathVariable(name="id") Long id){
        testimonyService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();

    }
    
}
