package com.devunivision.devunivision.Models.Componente;

import java.util.List;

import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComponenteService {
    private final ComponenteRepository componenteRepository;
 

    public List<Componente> getComponente(){
        return componenteRepository.findAll();
    }

    public void postListComponentes(List<Componente> componentes) {
        componenteRepository.saveAll(componentes);
    }



    public Componente getComponente(int id){
        return componenteRepository.findById(id).orElse(null);
    }
}
