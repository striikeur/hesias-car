package fr.hesias.car.converter;

import java.util.ArrayList;
import java.util.List;

public abstract class EntityToDtoConverter<Entity, DTO> {

    public abstract Entity dtoToEntity(DTO dto);
    public abstract DTO entityToDto(Entity entity);
    public List<DTO> listEntityToListDto(List<Entity> entities) {
        List<DTO> dtos = new ArrayList<>();
        for(Entity entity: entities) {
            dtos.add(this.entityToDto(entity));
        }
        return dtos;
    }
    public List<Entity> listDtoToListEntity(List<DTO> dtos) {
        List<Entity> entities = new ArrayList<>();
        for(DTO dto: dtos) {
            entities.add(this.dtoToEntity(dto));
        }
        return entities;
    }
}
