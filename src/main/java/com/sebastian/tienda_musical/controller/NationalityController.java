package com.sebastian.tienda_musical.controller;

import com.sebastian.tienda_musical.entity.NationalityEntity;
import com.sebastian.tienda_musical.service.iface.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nationalities")
@RequiredArgsConstructor
public class NationalityController {
    private final CrudService<NationalityEntity, Integer> crudNationality;

    @PostMapping
    public ResponseEntity create(@RequestBody NationalityEntity nationality){
        crudNationality.create(nationality);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<NationalityEntity>> getNationalities(){
        return ResponseEntity.ok(crudNationality.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NationalityEntity> getNationalityById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(crudNationality.getById(id).get());
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody NationalityEntity nationality, @PathVariable("id") Integer id){
        crudNationality.update(nationality, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        crudNationality.delete(id);
        return ResponseEntity.ok().build();
    }
}
