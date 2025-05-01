package com.sebastian.tienda_musical.model.nationality.mapper;

import com.sebastian.tienda_musical.entity.NationalityEntity;
import com.sebastian.tienda_musical.model.nationality.dto.Nationality;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NationalityMapper {
    Nationality toDto(NationalityEntity entity);

    NationalityEntity toEntity(Nationality dto);

    List<Nationality> toDtoList(List<NationalityEntity> entities);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(Nationality dto, @MappingTarget NationalityEntity entity);
}
