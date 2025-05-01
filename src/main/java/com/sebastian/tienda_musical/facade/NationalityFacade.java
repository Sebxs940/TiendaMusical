package com.sebastian.tienda_musical.facade;

import com.sebastian.tienda_musical.entity.NationalityEntity;
import com.sebastian.tienda_musical.service.iface.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NationalityFacade {
    private final CrudService<NationalityEntity, Integer> nationalityCrud;

    public void create(NationalityEntity nationality) {
        nationalityCrud.create(nationality);
    }

    public List<NationalityEntity> getAll() {
        return nationalityCrud.getAll();
    }

    public Optional<NationalityEntity> getById(Integer id) {
        return nationalityCrud.getById(id);
    }

    public void update(NationalityEntity nationality, Integer id) {
        nationalityCrud.update(nationality, id);
    }

    public void delete(Integer id) {
        nationalityCrud.delete(id);
    }
}
