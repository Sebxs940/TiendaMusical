package com.sebastian.tienda_musical.repository;

import com.sebastian.tienda_musical.entity.NationalityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NationalityRepository extends JpaRepository<NationalityEntity, Integer> {
}
