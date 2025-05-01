package com.sebastian.tienda_musical.facade;

import com.sebastian.tienda_musical.entity.GenderEntity;
import com.sebastian.tienda_musical.service.iface.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenderFacade {
    private final CrudService<GenderEntity, Integer> genderCrud;

    public void create(GenderEntity gender) {
        genderCrud.create(gender);
    }

    public List<GenderEntity> getAll() {
        return genderCrud.getAll();
    }

    public Optional<GenderEntity> getById(Integer id) {
        return genderCrud.getById(id);
    }

    public void update(GenderEntity gender, Integer id) {
        genderCrud.update(gender, id);
    }

    public void delete(Integer id) {
        genderCrud.delete(id);
    }
}
