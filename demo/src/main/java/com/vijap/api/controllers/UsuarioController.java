package com.vijap.api.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.vijap.api.dto.Message;

//import javax.persistence.Access;

import com.vijap.api.models.UsuarioModel;
import com.vijap.api.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:15638/")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    //Decorador para autorizar solo usuario logeados
    //@PreAuthorize("hasAuthority('USER')")
    @GetMapping("/listar")
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }


    @PostMapping("/guardar")
    public ResponseEntity<?> guardarUsuario(@RequestBody UsuarioModel usuario){
        if(usuarioService.existsByEmail(usuario.getEmail())){
            return new ResponseEntity(new Message("Correo ya existente"), HttpStatus.BAD_REQUEST);
        }
        this.usuarioService.guardarUsuario(usuario);
        return new ResponseEntity(new Message("Usuario Insertado"), HttpStatus.OK);
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
