package com.bnta.chocolate.services;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChocolateService {
    @Autowired
    ChocolateRepository chocolateRepository;

    public List<Chocolate> getAllChocolateName(){
        return chocolateRepository.findAll();
    }

    public Optional<Chocolate> getChocolateById(long id){
        return chocolateRepository.findById(id);
    }
    
    public Chocolate addChocolate(Chocolate chocolate){
        chocolateRepository.save(chocolate);
        return chocolate;
    }
    
//     public Boolean checkStock(Chocolate chocolate){
//         for(Chocolate chocolates : List<Chocolate>)
//     }



}
