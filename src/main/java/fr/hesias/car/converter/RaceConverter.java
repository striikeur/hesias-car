package fr.hesias.car.converter;

import fr.hesias.car.dto.RaceDTO;
import fr.hesias.car.model.Race;

import java.util.List;

public class RaceConverter extends EntityToDtoConverter<Race, RaceDTO> {
    @Override
    public Race dtoToEntity(RaceDTO raceDTO) {
        return null;
    }

    @Override
    public RaceDTO entityToDto(Race race) {
        return null;
    }

    @Override
    public List<RaceDTO> listEntityToListDto(List<Race> races) {
        return null;
    }

    @Override
    public List<Race> listDtoToListEntity(List<RaceDTO> raceDTOS) {
        return null;
    }
}
