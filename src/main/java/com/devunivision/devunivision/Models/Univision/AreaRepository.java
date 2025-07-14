package com.devunivision.devunivision.Models.Univision;


import java.util.List;
import java.util.Optional;

import javax.swing.text.html.parser.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface AreaRepository extends JpaRepository<Area,Integer> {
    Optional<Area> findById(Integer id);
    List<Area> findAll() ;       

    @Modifying()
   /* @Query("update Area u set u.id_organizacion=:id_organizacion, u.id_areasuperior=: id_areasuperior, u.claveArea=:claveArea, u.nomCorto=:nomCorto, u.nomArea=:nomArea where u.id_area = :id_area")
    void updateArea(@Param(value = "id_area") Integer id_area,   @Param(value = "id_organizacion") Integer id_organizacion,  @Param(value = "id_areasuperior") Integer id_areasuperior,@Param(value = "claveArea") String claveArea 
    , @Param(value = "nomCorto") String nomCorto , @Param(value = "nomArea") String nomArea);
*/

@Query("update Area u set u.claveArea=:claveArea, u.nomCorto=:nomCorto, u.nomArea=:nomArea where u.id_area = :id_area")
void updateArea(@Param(value = "id_area") Integer id_area,@Param(value = "claveArea") String claveArea 
, @Param(value = "nomCorto") String nomCorto , @Param(value = "nomArea") String nomArea);

    Area save(Entity area);
    
} 