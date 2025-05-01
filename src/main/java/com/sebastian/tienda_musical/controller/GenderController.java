package com.sebastian.tienda_musical.controller;

import com.sebastian.tienda_musical.entity.GenderEntity;
import com.sebastian.tienda_musical.service.iface.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gender")
@RequiredArgsConstructor
public class GenderController {
    private final CrudService<GenderEntity, Integer> crudGender;

    @PostMapping
    public ResponseEntity create(@RequestBody GenderEntity gender){
        crudGender.create(gender);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<GenderEntity>> getGender(){
        return ResponseEntity.ok(crudGender.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenderEntity> getGenderById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(crudGender.getById(id).get());
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody GenderEntity gender, @PathVariable("id") Integer id){
        crudGender.update(gender, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        crudGender.delete(id);
        return ResponseEntity.ok().build();
    }
}
