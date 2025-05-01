package com.sebastian.tienda_musical.repository;

import com.sebastian.tienda_musical.entity.GenderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<GenderEntity, Integer> {
}
