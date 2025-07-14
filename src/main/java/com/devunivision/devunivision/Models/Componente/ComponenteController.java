package com.devunivision.devunivision.Models.Componente;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value="/api/componente")
@RequiredArgsConstructor
@CrossOrigin(origins="http://localhost:4200")

public class ComponenteController {
     private final ComponenteService  componenteService;

    @GetMapping()
    public List<Componente> getComponente() {
        
        return  componenteService.getComponente();
    }

    @GetMapping(value="/{id}")
    public Componente getComponenteId(@PathVariable Integer id) {
        return componenteService.getComponente(id);
       
    }

    @PostMapping()
    public void postMethodName(@RequestBody List<Componente> componentes) { 
        componenteService.postListComponentes(componentes);
    }
    
}