package com.vijap.api.services;
import java.util.ArrayList;
import java.util.Optional;

import com.vijap.api.models.UsuarioModel;
import com.vijap.api.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>)usuarioRepository.findAll();
    }
    
    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> obtenerPorId (Long id){
        return usuarioRepository.findById(id);
    }

    public Optional<UsuarioModel> obtenerPorEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    public boolean eliminarUsuario(Long id){
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public boolean eliminarUsuarioEmail(String email){
        try {
            usuarioRepository.deleteByEmail(email);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
