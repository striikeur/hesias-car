package fr.hesias.car.service;

import fr.hesias.car.converter.SedanCarConverter;
import fr.hesias.car.dto.SedanCarDTO;
import fr.hesias.car.model.SedanCar;
import fr.hesias.car.repository.SedanCarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SedanCarService {
    private final SedanCarRepository sedanCarRepository;
    private final SedanCarConverter sedanCarConverter;

    public SedanCarService(SedanCarRepository sedanCarRepository, SedanCarConverter sedanCarConverter) {
        this.sedanCarRepository = sedanCarRepository;
        this.sedanCarConverter = sedanCarConverter;
    }

    @Transactional(rollbackFor = Exception.class)
    public SedanCarDTO createSedanCar(SedanCarDTO sedanCarDTO) {
        SedanCar sedanCar = this.sedanCarRepository.save(this.sedanCarConverter.dtoToEntity(sedanCarDTO));
        return this.sedanCarConverter.entityToDto(sedanCar);
    }

    @Transactional(readOnly = true)
    public List<SedanCarDTO> findAll() {
        return this.sedanCarConverter.listEntityToListDto(this.sedanCarRepository.findAll());
    }

    @Transactional(readOnly = true)
    public List<SedanCarDTO> findByTrunkSpaceGreaterThan(Float trunkSpace) {
        return this.sedanCarConverter.listEntityToListDto(this.sedanCarRepository.findByTrunkSpaceGreaterThan(trunkSpace));
    }

    @Transactional(readOnly = true)
    public List<SedanCarDTO> findByTrunkSpace(Float trunkSpace) {
        return this.sedanCarConverter.listEntityToListDto(this.sedanCarRepository.findFirstByTrunkSpace(trunkSpace));
    }

}
