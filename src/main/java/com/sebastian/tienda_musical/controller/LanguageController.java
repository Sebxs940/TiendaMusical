package com.sebastian.tienda_musical.controller;

import com.sebastian.tienda_musical.entity.LanguageEntity;
import com.sebastian.tienda_musical.facade.LanguageFacade;
import com.sebastian.tienda_musical.service.iface.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/languages")
@RequiredArgsConstructor
public class LanguageController {
    private final LanguageFacade languageFacade;

    @PostMapping
    public ResponseEntity create(@RequestBody LanguageEntity language){
        languageFacade.create(language);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<LanguageEntity>> getLanguages(){
        return ResponseEntity.ok(languageFacade.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LanguageEntity> getLanguagesById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(languageFacade.getById(id).get());
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody LanguageEntity language, @PathVariable("id") Integer id){
        languageFacade.update(language, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        languageFacade.delete(id);
        return ResponseEntity.ok().build();
    }
}
