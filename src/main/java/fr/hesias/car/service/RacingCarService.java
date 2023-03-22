package fr.hesias.car.service;

import fr.hesias.car.converter.RacingCarConverter;
import fr.hesias.car.dto.RacingCarDTO;
import fr.hesias.car.dto.SedanCarDTO;
import fr.hesias.car.model.RacingCar;
import fr.hesias.car.model.SedanCar;
import fr.hesias.car.repository.RacingCarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class RacingCarService {

    private final RacingCarRepository racingCarRepository;
    private final RacingCarConverter racingCarConverter;

    public RacingCarService(RacingCarRepository racingCarRepository, RacingCarConverter racingCarConverter) {
        this.racingCarRepository = racingCarRepository;
        this.racingCarConverter = racingCarConverter;
    }

    @Transactional(readOnly = true)
    public List<RacingCarDTO> findAll(Float topSpeed) {
        if(topSpeed != null) {
            return this.racingCarConverter.listEntityToListDto(
                    this.racingCarRepository.findByTopSpeedGreaterThanEqual(topSpeed)
            );
        }
        return this.racingCarConverter.listEntityToListDto(
                this.racingCarRepository.findAll()
        );
    }

    @Transactional(rollbackFor = Exception.class)
    public RacingCarDTO createRacingCar(RacingCarDTO racingCarDTO) {
        return this.racingCarConverter.entityToDto(
                this.racingCarRepository.save(
                        this.racingCarConverter.dtoToEntity(racingCarDTO)
                ));
    }

    @Transactional(readOnly = true)
    public RacingCarDTO findById(UUID id) {
        return this.racingCarConverter.entityToDto(
                this.racingCarRepository.findById(id).orElseThrow()
        );
    }
}
