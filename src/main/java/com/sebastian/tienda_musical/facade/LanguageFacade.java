package com.sebastian.tienda_musical.facade;

import com.sebastian.tienda_musical.entity.LanguageEntity;
import com.sebastian.tienda_musical.model.gender.dto.Language;
import com.sebastian.tienda_musical.model.language.mapper.LanguageMapper;
import com.sebastian.tienda_musical.service.iface.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LanguageFacade {
    private final CrudService<LanguageEntity, Integer> languageCrud;
    private final LanguageMapper mapper;

    public void create(Language dto) {

        languageCrud.create(mapper.toEntity(dto));
    }

    public List<Language> getAll() {

        return mapper.toDtoList(languageCrud.getAll());
    }

    public Optional<LanguageEntity> getById(Integer id) {
        return languageCrud.getById(id);
    }

    public void update(Language dto, Integer id) {

        languageCrud.getById(id).ifPresent(entity -> {
            mapper.updateEntityFromDto(dto, entity);
            languageCrud.update(entity, id);
        });
    }

    public void delete(Integer id) {
        languageCrud.delete(id);
    }
}
