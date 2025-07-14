package com.devunivision.devunivision.Models.Rol;


import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Entity;



@Repository
public interface RolRepository extends JpaRepository<Rol,Integer> {
    Optional<Rol> findById(Integer id);
    List<Rol> findAll() ;  


    @Modifying()

    @Query("update Rol u set u.clave=:clave, u.descripcion=:descripcion, u.fechaCreacion=:fechaCreacion, u.incorporacion=:incorporacion where u.id_rol = :id_rol")
    void updateRol(@Param(value = "id_rol") Integer id_rol,   @Param(value = "clave") String clave,  @Param(value = "descripcion") String descripcion, @Param(value = "fechaCreacion") Date fechaCreacion 
    , @Param(value = "incorporacion") boolean incorporacion);

    Rol save(Entity rol);
    
} 