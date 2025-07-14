package com.devunivision.devunivision.Models.Rol;



import java.sql.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.devunivision.devunivision.Models.Componente.Componente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class RolDTO {
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    Integer id_rol;
   // Integer id_organizacion;
    String clave;
   // Integer id_areasuperior;
    String descripcion;
    Date fecha_creacion;
    boolean incorporacion;
    Set<Componente> componentes;
}
