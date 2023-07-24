package com.alura.jornadaMilhas.controllers;

import com.alura.jornadaMilhas.entities.Testimony;
import com.alura.jornadaMilhas.services.TestimonyService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
