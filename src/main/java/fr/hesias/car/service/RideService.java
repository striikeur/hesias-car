package fr.hesias.car.service;

import fr.hesias.car.converter.RideConverter;
import fr.hesias.car.dto.RideDTO;
import fr.hesias.car.repository.RideRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class RideService {
    private final RideRepository rideRepository;
    private final RideConverter rideConverter;

    public RideService(RideRepository rideRepository, RideConverter rideConverter) {
        this.rideRepository = rideRepository;
        this.rideConverter = rideConverter;
    }

    @Transactional(readOnly = true)
    public List<RideDTO> findAll() {
        return this.rideConverter.listEntityToListDto(
                this.rideRepository.findAll()
        );
    }

    @Transactional(readOnly = true)
    public RideDTO findById(UUID id) {
        return this.rideConverter.entityToDto(
                this.rideRepository.findById(id).orElseThrow()
        );
    }

    @Transactional(rollbackFor = Exception.class)
    public RideDTO createRide(RideDTO rideDTO) {
        return this.rideConverter.entityToDto(
                this.rideRepository.save(this.rideConverter.dtoToEntity(rideDTO))
        );
    }
}
