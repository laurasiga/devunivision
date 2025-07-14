package com.devunivision.devunivision.Models.Univision;

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
@Table(name="Area")
public class Area{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_area")
    Integer id_area;


    @Column(nullable=false)
    String claveArea;
    @Column(nullable=false)
    String nomCorto;
    @Column(nullable=false)
    String nomArea;
}