package fr.hesias.car.converter;

import java.util.List;

public interface EntityToDtoConverter<Entity, DTO> {

    Entity dtoToEntity(DTO dto);
    DTO entityToDto(Entity entity);
    List<DTO> listEntityToListDto(List<Entity> entities);
    List<Entity> listDtoToListEntity(List<DTO> dtos);
}
