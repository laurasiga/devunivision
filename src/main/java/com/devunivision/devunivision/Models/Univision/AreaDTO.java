package com.devunivision.devunivision.Models.Univision;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class AreaDTO {
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    Integer id_area;
    String claveArea;
    String nomCorto;
    String nomArea;
}
