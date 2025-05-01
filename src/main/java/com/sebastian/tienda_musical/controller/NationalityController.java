package com.sebastian.tienda_musical.controller;

import com.sebastian.tienda_musical.facade.NationalityFacade;
import com.sebastian.tienda_musical.model.nationality.dto.Nationality;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nationalities")
@RequiredArgsConstructor
public class NationalityController {
    private final NationalityFacade nationalityFacade;

    @PostMapping
    public ResponseEntity create(@RequestBody Nationality nationality){
        nationalityFacade.create(nationality);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Nationality>> getNationalities(){
        return ResponseEntity.ok(nationalityFacade.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nationality> getNationalityById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(nationalityFacade.getById(id).get());
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody Nationality nationality, @PathVariable("id") Integer id){
        nationalityFacade.update(nationality, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        nationalityFacade.delete(id);
        return ResponseEntity.ok().build();
    }
}
