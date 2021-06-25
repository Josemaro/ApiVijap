package com.vijap.api.repositories;

//import java.util.ArrayList;
import java.util.Optional;

import com.vijap.api.models.UsuarioModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel,Long>{
    public abstract Optional<UsuarioModel> findByEmail(String email);
    public abstract Optional<UsuarioModel> findById(Long id);
    public abstract void deleteById(Long id);
    public abstract void deleteByEmail(String email);
    public abstract boolean existsByEmail(String email);
}
