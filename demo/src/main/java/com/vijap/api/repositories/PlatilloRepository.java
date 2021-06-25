package com.vijap.api.repositories;

import java.util.Optional;

import com.vijap.api.models.PlatilloModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatilloRepository extends CrudRepository<PlatilloModel,Long> {
    public abstract Optional<PlatilloModel> findByNombre(String nombre);
    public abstract Optional<PlatilloModel> findById(Long id);
    public abstract void deleteById(Long id);
}
