package com.devunivision.devunivision.Models.Componente;



import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="Componente")
public class Componente{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_componente")
    Integer id_componente;

    @Column(nullable=false)
    String cveComponente;
    @Column(nullable=false)
    String nomComponente;
    @Column(nullable=false)
    String actaConstitutiva;
    @Column(nullable=false)
    String entregable;
    @Column(nullable=false)
    String descripcion;
    @Column(nullable=false)
    String criterioAceptacion;
    @Column(nullable=false)
    Date fechaPrevista;
    @Column(nullable=false)
    Date fechaConclusion;
    @Column(nullable=false)
    String observaciones;

}
