package com.devunivision.devunivision.Models.Univision;
import java.util.List;
import javax.management.relation.RelationNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value="/api/area")
@RequiredArgsConstructor
@CrossOrigin(origins="http://localhost:4200")

public class AreaController{

    private final AreaService areaService;

    @GetMapping()
    public ResponseEntity<List<Area>> getAreas() {
        
        List<Area> listAreas = areaService.getAreas();
        return ResponseEntity.ok(listAreas);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<AreaDTO> getAreaId(@PathVariable Integer id) {
        AreaDTO areaDTO = areaService.getArea(id);

        if(areaDTO == null){

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(areaDTO);
    }
       
    @PostMapping
    public Area createArea(@RequestBody Area area) {

        return areaService.createArea(area);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AreaResponse> putMethodName(@PathVariable int id, @RequestBody Area area) throws RelationNotFoundException {

        return ResponseEntity.ok(areaService.updateArea(id, area));
    }


    @DeleteMapping(value="{id}")
    public ResponseEntity<Void> deleteArea(@PathVariable Integer id) throws Exception{
        areaService.deleteArea(id);
        return ResponseEntity.noContent().build();
    }

}

