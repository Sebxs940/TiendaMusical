package com.sebastian.tienda_musical.controller;

import com.sebastian.tienda_musical.entity.LanguageEntity;
import com.sebastian.tienda_musical.service.iface.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/languages")
@RequiredArgsConstructor
public class LanguageController {
    private final CrudService<LanguageEntity, Integer> crudLanguage;

    @PostMapping
    public ResponseEntity create(@RequestBody LanguageEntity language){
        crudLanguage.create(language);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<LanguageEntity>> getLanguages(){
        return ResponseEntity.ok(crudLanguage.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LanguageEntity> getLanguagesById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(crudLanguage.getById(id).get());
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody LanguageEntity language, @PathVariable("id") Integer id){
        crudLanguage.update(language, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        crudLanguage.delete(id);
        return ResponseEntity.ok().build();
    }
}
