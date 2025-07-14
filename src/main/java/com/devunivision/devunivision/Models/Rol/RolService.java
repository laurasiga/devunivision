package com.devunivision.devunivision.Models.Rol;

import java.util.List;

import java.util.Set;

import javax.management.relation.RelationNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.devunivision.devunivision.Models.Componente.Componente;
import com.devunivision.devunivision.Models.Componente.ComponenteRepository;
import com.devunivision.devunivision.Shared.Response;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RolService {
    private final RolRepository rolRepository;
    private final ComponenteRepository componenteRepository;

    public List<Rol> getRoles(){
        return rolRepository.findAll();

    }
   
    public Rol getRol(int id){
        return rolRepository.findById(id).orElse(null);

    }

    public Rol createRol( Rol rol){

        return rolRepository.save(rol);
    }

    public Void deleteRol(int id){
        if(rolRepository.existsById(id)){
            rolRepository.deleteById(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return null;
    }

    @Transactional
  public Response updateRol2(int id, Rol rol) {
     
    rolRepository
              .findById(id) // returns Optional<User>
              .ifPresent(r -> {
                  r.setId_rol(rol.id_rol);
                  r.setClave(rol.getClave());
                  r.setDescripcion(rol.getDescripcion());
                  r.setFechaCreacion(rol.getFechaCreacion());
                  r.setIncorporacion(false);
                  r.setComponentes(rol.getComponentes());
                  rolRepository.save(r);
              });
              return new Response("Se guardó saisfactoriamente");
  }


      @Transactional
    public Response updateRol (int id, Rol rol) throws RelationNotFoundException{
        rolRepository.findById(id).orElseThrow(() -> new RelationNotFoundException("Employee not exist with id: "));

        RolDTO rolDTO = RolDTO.builder()
        .id_rol(rol.id_rol)
        .clave(rol.getClave())
        .descripcion(rol.getDescripcion())
        .fecha_creacion(rol.getFechaCreacion())
        .incorporacion(rol.incorporacion)
        .build();
       

        rolRepository.updateRol(rolDTO.id_rol, rolDTO.clave, rolDTO.descripcion, rolDTO.fecha_creacion, 
        rolDTO.incorporacion);
        return new Response("Se guardo saisfactoriamente");

    }

    @Transactional
    public void registrarRolComponente(Integer rolId, List<Integer> componentesId) {
        Rol rol = rolRepository.findById(rolId).orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        List<Componente> componentes = componenteRepository.findAllById(componentesId);

        rol.getComponentes().addAll(componentes);
        rolRepository.save(rol);
    }

    public Set<Componente> getComponentesbyRol(Integer idRol){
        Rol rol = rolRepository.findById(idRol).orElse(null);
        if (rol != null){

            return rol.getComponentes();
        }
        return null;

    }

}

