package fr.hesias.car.service;

import fr.hesias.car.converter.PilotConverter;
import fr.hesias.car.dto.PilotDTO;
import fr.hesias.car.repository.PilotRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PilotService {

    private final PilotRepository pilotRepository;
    private final PilotConverter pilotConverter;

    public PilotService(PilotRepository pilotRepository, PilotConverter pilotConverter) {
        this.pilotRepository = pilotRepository;
        this.pilotConverter = pilotConverter;
    }

    @Transactional(readOnly = true)
    public List<PilotDTO> findAllByRace(String raceTrack) {
        return this.pilotConverter.listEntityToListDto(this.pilotRepository.findByRace(raceTrack));
    }

    @Transactional(rollbackFor = Exception.class)
    public PilotDTO createPilot(PilotDTO pilotDTO) {
        return this.pilotConverter.entityToDto(this.pilotRepository.save(this.pilotConverter.dtoToEntity(pilotDTO)));
    }
}
