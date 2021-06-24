package com.vijap.api.controllers;

import java.util.ArrayList;
import java.util.Optional;

//import javax.persistence.Access;

import com.vijap.api.models.UsuarioModel;
import com.vijap.api.services.UsuarioService;

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



@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @CrossOrigin(origins = "http://localhost:10250")
    @GetMapping("/listar")
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }


    @PostMapping("/guardar")
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

    
    @GetMapping(path ="/getId/{id}")
    public Optional <UsuarioModel> obtenerUsuarioPorId(@PathVariable("id")Long id){
        return this.usuarioService.obtenerPorId(id);
    }

    @GetMapping(path ="/getCorreo/{email}")
    public Optional <UsuarioModel> obtenerUsuarioPorEmail(@PathVariable("email")String email){
        return this.usuarioService.obtenerPorEmail(email);
    }


    @DeleteMapping(path = "/eliminar/{id}")
    public String eliminarPorId(@PathVariable("id")Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if(ok){
            return "Se eliminó el usuario con id" + id;
        }else{
            return "No se pudo eliminar el usuario con id" + id;
        }
    }




    

}
