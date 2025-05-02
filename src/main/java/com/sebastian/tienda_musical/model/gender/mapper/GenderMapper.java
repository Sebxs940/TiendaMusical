package com.sebastian.tienda_musical.model.gender.mapper;

import com.sebastian.tienda_musical.entity.GenderEntity;
import com.sebastian.tienda_musical.entity.NationalityEntity;
import com.sebastian.tienda_musical.model.gender.dto.Gender;
import com.sebastian.tienda_musical.model.nationality.dto.Nationality;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenderMapper {
    Gender toDto(GenderEntity entity);

    GenderEntity toEntity(Gender dto);

    List<Gender> toDtoList(List<GenderEntity> entities);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(Gender dto, @MappingTarget GenderEntity entity);
}
