package com.vijap.api.services;


import java.util.ArrayList;
import java.util.Optional;

import com.vijap.api.models.PlatilloModel;
import com.vijap.api.repositories.PlatilloRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlatilloService {
    
    @Autowired
    PlatilloRepository platilloRepository;

    public ArrayList<PlatilloModel> obtenerPlatillos(){
        return (ArrayList<PlatilloModel>)platilloRepository.findAll();
    }

    public PlatilloModel guardarPlatillo(PlatilloModel platillo){
        return platilloRepository.save(platillo);
    }

    public Optional<PlatilloModel> obtenerPorId(Long id){
        return platilloRepository.findById(id);
    }

    public Optional<PlatilloModel> obtenerPorNombre(String nombre){
        return platilloRepository.findByNombre(nombre);
    }

    public boolean eliminarPlatillo(Long id){
        try {
            platilloRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

}
