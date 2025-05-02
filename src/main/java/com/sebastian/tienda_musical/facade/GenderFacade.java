package com.sebastian.tienda_musical.facade;

import com.sebastian.tienda_musical.entity.GenderEntity;
import com.sebastian.tienda_musical.model.gender.dto.Gender;
import com.sebastian.tienda_musical.model.gender.mapper.GenderMapper;
import com.sebastian.tienda_musical.model.nationality.dto.Nationality;
import com.sebastian.tienda_musical.service.iface.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenderFacade {
    private final CrudService<GenderEntity, Integer> genderCrud;
    private final GenderMapper mapper;

    public void create(Gender dto) {
        genderCrud.create(mapper.toEntity(dto));
    }

    public List<Gender> getAll() {
        return mapper.toDtoList(genderCrud.getAll());
    }

    public Optional<GenderEntity> getById(Integer id) {
        return genderCrud.getById(id);
    }

    public void update(Gender dto, Integer id) {
        genderCrud.getById(id).ifPresent(entity -> {
            mapper.updateEntityFromDto(dto, entity);
            genderCrud.update(entity, id);
        });
    }

    public void delete(Integer id) {
        genderCrud.delete(id);
    }
}
