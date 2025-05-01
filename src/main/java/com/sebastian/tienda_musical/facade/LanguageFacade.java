package com.sebastian.tienda_musical.facade;

import com.sebastian.tienda_musical.entity.LanguageEntity;
import com.sebastian.tienda_musical.service.iface.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LanguageFacade {
    private final CrudService<LanguageEntity, Integer> languageCrud;

    public void create(LanguageEntity gender) {
        languageCrud.create(gender);
    }

    public List<LanguageEntity> getAll() {
        return languageCrud.getAll();
    }

    public Optional<LanguageEntity> getById(Integer id) {
        return languageCrud.getById(id);
    }

    public void update(LanguageEntity gender, Integer id) {
        languageCrud.update(gender, id);
    }

    public void delete(Integer id) {
        languageCrud.delete(id);
    }
}
