package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.services.ChocolateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/chocolates")
public class ChocolateController {

    @Autowired
    ChocolateService chocolateService;

    @GetMapping
    public ResponseEntity<List<Chocolate>> getAllNames(){
        List<Chocolate> chocolates= chocolateService.getAllChocolateName();
        return new ResponseEntity<>(chocolates,HttpStatus.OK);
//        List<Chocolate> chocolates;
//        if(isStock.isPresent()){
//            chocolates = chocolateService.getAllChocolateName();
//        } else {
//            chocolates = null;
//        }
//        return new ResponseEntity<>(chocolates, HttpStatus.OK);

    }
    
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Chocolate> getChocolateById(@PathVariable long id){
        Optional<Chocolate> chocolate = chocolateService.getChocolateById(id);
        if (chocolate.isPresent()){
            return new ResponseEntity<>(chocolate.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>( null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Chocolate> addChocolate(@RequestBody Chocolate chocolate){
        chocolateService.addChocolate(chocolate);
        return new ResponseEntity<>(chocolate, HttpStatus.CREATED);
    }





}
