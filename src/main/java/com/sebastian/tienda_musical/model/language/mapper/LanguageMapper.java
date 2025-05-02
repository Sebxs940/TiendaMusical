package com.sebastian.tienda_musical.model.language.mapper;

import com.sebastian.tienda_musical.entity.LanguageEntity;
import com.sebastian.tienda_musical.model.gender.dto.Language;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LanguageMapper {
    Language toDto(LanguageEntity entity);

    LanguageEntity toEntity(Language dto);

    List<Language> toDtoList(List<LanguageEntity> entities);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(Language dto, @MappingTarget LanguageEntity entity);
}
