package com.vijap.api.services;
import com.vijap.api.models.CustomUserDetails;
import com.vijap.api.models.UsuarioModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
    @Autowired
    UsuarioService usuarioService;
    
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UsuarioModel usuario = usuarioService.obtenerPorEmail(s).get();
        if(usuario == null){
            throw new UsernameNotFoundException("User Not Found");
        }
        System.out.println(usuario.getEmail());
        return new CustomUserDetails(usuario);
    }
}