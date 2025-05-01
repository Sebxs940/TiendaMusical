package com.sebastian.tienda_musical.service.iface;

import java.util.List;
import java.util.Optional;

public interface CrudService<E, ID> {
    void create(E entity);
    Optional<E> getById(ID id);
    List<E> getAll();
    void update(E entity, ID id);
    void delete(ID id);
    boolean existsById(ID id);
}
