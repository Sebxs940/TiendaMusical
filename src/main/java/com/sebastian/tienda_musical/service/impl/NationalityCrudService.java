package com.sebastian.tienda_musical.service.impl;

import com.sebastian.tienda_musical.entity.NationalityEntity;
import com.sebastian.tienda_musical.exception.entity.EntityAlreadyExistsException;
import com.sebastian.tienda_musical.exception.entity.EntityNotFoundException;
import com.sebastian.tienda_musical.repository.NationalityRepository;
import com.sebastian.tienda_musical.service.iface.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NationalityCrudService implements CrudService<NationalityEntity, Integer> {

    private final NationalityRepository nationalityRepository;

    @Override
    public void create(NationalityEntity entity) {
        if (existsById(entity.getId())) {
            throw new EntityAlreadyExistsException("Nationality with id " + entity.getId() + " already exists");
        }
        nationalityRepository.save(entity);
    }

    @Override
    public Optional<NationalityEntity> getById(Integer id) {
        NationalityEntity nationality = nationalityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Nationality with id " + id + " not found"));
        return Optional.of(nationality);
    }


    @Override
    public List<NationalityEntity> getAll() {
        return nationalityRepository.findAll();
    }

    @Override
    public void update(NationalityEntity entity, Integer id) {
        if (getById(id).isPresent()) {
            nationalityRepository.save(entity);
        }
    }

    @Override
    public void delete(Integer id) {
        if (getById(id).isPresent()) {
            nationalityRepository.deleteById(id);
        }
    }

    @Override
    public boolean existsById(Integer id) {
        return nationalityRepository.existsById(id);
    }
}
