package fr.hesias.car.converter;

import fr.hesias.car.dto.PilotDTO;
import fr.hesias.car.model.Pilot;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PilotConverter extends EntityToDtoConverter<Pilot, PilotDTO> {
    @Override
    public Pilot dtoToEntity(PilotDTO pilotDTO) {
        return new Pilot(pilotDTO.getId(), pilotDTO.getName(), pilotDTO.getAge(), pilotDTO.getHeight());
    }

    @Override
    public PilotDTO entityToDto(Pilot pilot) {
        PilotDTO pilotDTO = new PilotDTO();
        pilotDTO.setId(pilot.getId());
        pilotDTO.setName(pilot.getName());
        pilotDTO.setAge(pilot.getAge());
        pilotDTO.setHeight(pilot.getHeight());
        return pilotDTO;
    }

    @Override
    public List<PilotDTO> listEntityToListDto(List<Pilot> pilots) {
        List<PilotDTO> pilotDTOS = new ArrayList<>();
        for (Pilot pilot : pilots) {
            pilotDTOS.add(this.entityToDto(pilot));
        }
        return pilotDTOS;
    }

    @Override
    public List<Pilot> listDtoToListEntity(List<PilotDTO> pilotDTOS) {
        List<Pilot> pilots = new ArrayList<>();
        for (PilotDTO pilotDTO : pilotDTOS) {
            pilots.add(this.dtoToEntity(pilotDTO));
        }
        return pilots;
    }
}
