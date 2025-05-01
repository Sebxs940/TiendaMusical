package com.sebastian.tienda_musical.service.impl;

import com.sebastian.tienda_musical.entity.LanguageEntity;
import com.sebastian.tienda_musical.exception.entity.EntityAlreadyExistsException;
import com.sebastian.tienda_musical.exception.entity.EntityNotFoundException;
import com.sebastian.tienda_musical.repository.LanguageRepository;
import com.sebastian.tienda_musical.service.iface.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LanguageCrudService implements CrudService<LanguageEntity, Integer> {

    private final LanguageRepository languageRepository;

    @Override
    public void create(LanguageEntity entity) {
        if (existsById(entity.getId())) {
            throw new EntityAlreadyExistsException("Language with id " + entity.getId() + " already exists");
        }
        languageRepository.save(entity);
    }

    @Override
    public Optional<LanguageEntity> getById(Integer id) {
        LanguageEntity language = languageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Language with id " + id + " not found"));
        return Optional.of(language);
    }

    @Override
    public List<LanguageEntity> getAll() {
        return languageRepository.findAll();
    }

    @Override
    public void update(LanguageEntity entity, Integer id) {
        if (getById(id).isPresent()) {
            languageRepository.save(entity);
        }
    }

    @Override
    public void delete(Integer id) {
        if (getById(id).isPresent()) {
            languageRepository.deleteById(id);
        }
    }

    @Override
    public boolean existsById(Integer id) {
        return languageRepository.existsById(id);
    }
}
