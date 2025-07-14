package com.devunivision.devunivision.Models.Rol;

import java.util.List;
import java.util.Set;

import javax.management.relation.RelationNotFoundException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devunivision.devunivision.Models.Componente.Componente;

import com.devunivision.devunivision.Shared.Response;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value="/api/rol")
@RequiredArgsConstructor
@CrossOrigin(origins="http://localhost:4200")

public class RolController {
     private final RolService rolService;

    @GetMapping()
    public List<Rol> getRol() {
        
        return  rolService.getRoles();
       // return ResponseEntity.ok(listAreas);
    }

    @GetMapping(value="/componentes/{id}")
    public Set<Componente> getComponentesRol(@PathVariable Integer id) {
        
        return rolService.getComponentesbyRol(id);
       // return ResponseEntity.ok(listComponentes);
    }
       

    @GetMapping(value="/{id}")
    public Rol getRolId(@PathVariable Integer id) {
        return rolService.getRol(id);

    }
       
    @PostMapping
    public Rol createRol(@RequestBody Rol rol) {

        return rolService.createRol(rol);
    }

    @PostMapping (value="/componentes/{id}")
    public void putRolComponentes(@PathVariable int id, @RequestBody List<Integer> componentesId) {
        
        rolService.registrarRolComponente(id, componentesId);
        
    }
    

    @PutMapping("/{id}")
    public Response updateRol(@PathVariable int id, @RequestBody Rol rol) throws RelationNotFoundException {

        return rolService.updateRol2(id, rol);
    }


    @DeleteMapping(value="{id}")
    public Void deleteRol(@PathVariable Integer id){
        return rolService.deleteRol(id);
    }

}