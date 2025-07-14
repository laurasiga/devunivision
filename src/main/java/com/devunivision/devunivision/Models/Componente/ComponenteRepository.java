package com.devunivision.devunivision.Models.Componente;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ComponenteRepository extends JpaRepository<Componente,Integer> {
    Optional<Componente> findById(Integer id);
    List<Componente> findAll() ;
    
}