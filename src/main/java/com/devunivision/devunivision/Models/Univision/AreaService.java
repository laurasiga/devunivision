package com.devunivision.devunivision.Models.Univision;

import java.util.List;
import javax.management.relation.RelationNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AreaService {
    private final AreaRepository areaRepository;

    public List<Area> getAreas(){
        return areaRepository.findAll();
    }

    public AreaDTO getArea(int id){
        Area area = areaRepository.findById(id).orElse(null);

        if(area != null){
            AreaDTO areaDTO = AreaDTO.builder()
            .id_area(area.id_area)
            .claveArea(area.claveArea)
            .nomCorto(area.nomCorto)
            .nomArea(area.nomArea)
            .build();

            return areaDTO;
        }
        return null;

    }

    public Area createArea( Area area){

        return areaRepository.save(area);
        
    }

    public void deleteArea (int id){
        if(areaRepository.existsById(id)){
            areaRepository.deleteById(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

      @Transactional
    public AreaResponse updateArea (int id, Area area) throws RelationNotFoundException{
        areaRepository.findById(id).orElseThrow(() -> new RelationNotFoundException("Employee not exist with id: "));

        AreaDTO areaDTO = AreaDTO.builder()
        .id_area(area.id_area)
        .claveArea(area.claveArea)
        .nomCorto(area.nomCorto)
        .nomArea(area.nomArea)
        .build();
         

        areaRepository.updateArea(areaDTO.id_area, areaDTO.claveArea, areaDTO.nomCorto, areaDTO.nomArea);
        return new AreaResponse("Se guardo saisfactoriamente");

    }

}
