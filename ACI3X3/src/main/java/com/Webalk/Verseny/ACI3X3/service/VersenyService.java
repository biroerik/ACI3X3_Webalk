package com.Webalk.Verseny.ACI3X3.service;

import java.util.List;

import com.Webalk.Verseny.ACI3X3.models.Verseny;
import com.Webalk.Verseny.ACI3X3.repositories.VersenyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VersenyService {
    
    @Autowired
    private VersenyRepository versenyRepository;

    public List<Verseny> findAll() {
        return (List<Verseny>) versenyRepository.findAll();
    }

    public Verseny findById(long id){
        
       return versenyRepository.findById(id).get();
    }

    public void save(Verseny verseny){
        versenyRepository.save(verseny);
    }

    public void delete(Verseny verseny){
        versenyRepository.delete(verseny);
    }
}
