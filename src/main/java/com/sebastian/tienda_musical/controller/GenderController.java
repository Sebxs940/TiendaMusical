package com.sebastian.tienda_musical.controller;

import com.sebastian.tienda_musical.entity.GenderEntity;
import com.sebastian.tienda_musical.facade.GenderFacade;
import com.sebastian.tienda_musical.service.iface.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genders")
@RequiredArgsConstructor
public class GenderController {
    private final GenderFacade genderFacade;

    @PostMapping
    public ResponseEntity create(@RequestBody GenderEntity gender){
        genderFacade.create(gender);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<GenderEntity>> getGenders(){
        return ResponseEntity.ok(genderFacade.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenderEntity> getGenderById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(genderFacade.getById(id).get());
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody GenderEntity gender, @PathVariable("id") Integer id){
        genderFacade.update(gender, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        genderFacade.delete(id);
        return ResponseEntity.ok().build();
    }
}
