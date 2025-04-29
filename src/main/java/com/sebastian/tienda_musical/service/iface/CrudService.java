package com.sebastian.tienda_musical.service.iface;

import java.util.List;
import java.util.Optional;

public interface CrudService<E, K> {
    void create(E entity);
    Optional<E> getById(K id);
    List<E> getAll();
    void update(E entity, K id);
    void delete(K id);
    boolean existsById(K id);
}
