package com.vijap.api.controllers;
import java.util.ArrayList;
import java.util.Optional;

import com.vijap.api.models.PlatilloModel;

//import javax.persistence.Access
import com.vijap.api.services.PlatilloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:1319/")
@RestController
@RequestMapping("/platillo")
public class PlatilloController {
    @Autowired
    PlatilloService platilloService;

    
    @GetMapping("/listar")
    public ArrayList<PlatilloModel> obtenerPlatillos(){
        return platilloService.obtenerPlatillos();
    }

    @PostMapping("/guardar")
    public PlatilloModel guardarPlatillo(@RequestBody PlatilloModel platillo){
        return this.platilloService.guardarPlatillo(platillo);
    }

    @GetMapping(path ="/getById/{id}")
    public Optional<PlatilloModel> obtenerPlatilloPorId(@PathVariable("id")Long id){
        return this.platilloService.obtenerPorId(id);
    }

    @DeleteMapping(path = "/eliminar/{id}")
    public String eliminarPorId(@PathVariable("id")Long id){
        boolean ok = this.platilloService.eliminarPlatillo(id);
        if(ok){
            return "Se eliminó el usuario con id" + id;
        }else{
            return "No se pudo eliminar el usuario con id" + id;
        }
    }


}