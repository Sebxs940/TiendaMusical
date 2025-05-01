package com.sebastian.tienda_musical.facade;

import com.sebastian.tienda_musical.entity.NationalityEntity;
import com.sebastian.tienda_musical.model.nationality.dto.Nationality;
import com.sebastian.tienda_musical.model.nationality.mapper.NationalityMapper;
import com.sebastian.tienda_musical.service.iface.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NationalityFacade {

    private final CrudService<NationalityEntity, Integer> nationalityCrud;
    private final NationalityMapper mapper;

    public void create(Nationality dto) {
        nationalityCrud.create(mapper.toEntity(dto));
    }

    public List<Nationality> getAll() {
        return mapper.toDtoList(nationalityCrud.getAll());
    }

    public Optional<Nationality> getById(Integer id) {
        return nationalityCrud.getById(id).map(mapper::toDto);
    }

    public void update(Nationality dto, Integer id) {
        nationalityCrud.getById(id).ifPresent(entity -> {
            mapper.updateEntityFromDto(dto, entity);
            nationalityCrud.update(entity, id);
        });
    }

    public void delete(Integer id) {
        nationalityCrud.delete(id);
    }
}
