package com.sebastian.tienda_musical.service.impl;

import com.sebastian.tienda_musical.entity.GenderEntity;
import com.sebastian.tienda_musical.exception.entity.EntityAlreadyExistsException;
import com.sebastian.tienda_musical.exception.entity.EntityNotFoundException;
import com.sebastian.tienda_musical.repository.GenderRepository;
import com.sebastian.tienda_musical.service.iface.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenderCrudService implements CrudService<GenderEntity, Integer> {

    private final GenderRepository genderRepository;

    @Override
    public void create(GenderEntity entity) {
        if (existsById(entity.getId())) {
            throw new EntityAlreadyExistsException("Gender with id " + entity.getId() + " already exists");
        }
        genderRepository.save(entity);
    }

    @Override
    public Optional<GenderEntity> getById(Integer id) {
        GenderEntity gender = genderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Gender with id " + id + " not found"));
        return Optional.of(gender);
    }

    @Override
    public List<GenderEntity> getAll() {
        return genderRepository.findAll();
    }

    @Override
    public void update(GenderEntity entity, Integer id) {
        if (getById(id).isPresent()) {
            genderRepository.save(entity);
        }
    }

    @Override
    public void delete(Integer id) {
        if (getById(id).isPresent()) {
            genderRepository.deleteById(id);
        }
    }

    @Override
    public boolean existsById(Integer id) {
        return genderRepository.existsById(id);
    }
}
