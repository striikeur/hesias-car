package fr.hesias.car.converter;

import fr.hesias.car.dto.PilotDTO;
import fr.hesias.car.dto.RaceDTO;
import fr.hesias.car.model.Pilot;
import fr.hesias.car.model.Race;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RaceConverter extends EntityToDtoConverter<Race, RaceDTO> {
    @Override
    public Race dtoToEntity(RaceDTO raceDTO) {
        return new Race(raceDTO.getId(), raceDTO.getName(), raceDTO.getDeparture(), raceDTO.getArrival(), raceDTO.getDate(), raceDTO.getRaceTrack(), new Pilot(raceDTO.getWinner().getId()));
    }

    @Override
    public RaceDTO entityToDto(Race race) {
        RaceDTO raceDTO = new RaceDTO();
        BeanUtils.copyProperties(race, raceDTO);
        PilotDTO pilotDTO = new PilotDTO();
        pilotDTO.setId(race.getWinner().getId());
        raceDTO.setWinner(pilotDTO);
        return raceDTO;
    }
}
