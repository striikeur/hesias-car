package fr.hesias.car.service;

import fr.hesias.car.converter.RaceConverter;
import fr.hesias.car.dto.RaceDTO;
import fr.hesias.car.repository.RaceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class RaceService {

    private final RaceRepository raceRepository;
    private final RaceConverter raceConverter;

    public RaceService(RaceRepository raceRepository, RaceConverter raceConverter) {
        this.raceRepository = raceRepository;
        this.raceConverter = raceConverter;
    }

    @Transactional(rollbackFor = Exception.class)
    RaceDTO createRace(RaceDTO raceDTO) {
        return this.raceConverter.entityToDto(this.raceRepository.save(this.raceConverter.dtoToEntity(raceDTO)));
    }

    @Transactional(readOnly = true)
    public List<RaceDTO> findAll(UUID winnerId) {
        if(winnerId != null) {
            return this.raceConverter.listEntityToListDto(this.raceRepository.findByWinnerId(winnerId));
        }
        return this.raceConverter.listEntityToListDto(this.raceRepository.findAll());
    }

    @Transactional(readOnly = true)
    public RaceDTO findById(UUID id) {
        return this.raceConverter.entityToDto(
                this.raceRepository.findById(id).orElseThrow()
        );
    }
}
