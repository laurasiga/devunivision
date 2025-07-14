package com.devunivision.devunivision.Models.Rol;


import java.sql.Date;
import java.util.HashSet;

import java.util.Set;


import com.devunivision.devunivision.Models.Componente.Componente;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Rol")
public class Rol{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_rol")
    Integer id_rol;
  
    @Column(nullable=false)
    String clave;
    @Column(nullable=false)
    String descripcion;
    @Column(nullable=false)
    Date fechaCreacion;
    @Column(nullable=false)
    boolean incorporacion;


    
     @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "rol_componentes",
            joinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "id_rol"),
            inverseJoinColumns = @JoinColumn(name = "id_componente", referencedColumnName = "id_componente"))
    private Set<Componente> componentes = new HashSet<>();
    


}