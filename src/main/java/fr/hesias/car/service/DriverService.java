package fr.hesias.car.service;

import fr.hesias.car.converter.DriverConverter;
import fr.hesias.car.dto.CarDTO;
import fr.hesias.car.dto.DriverDTO;
import fr.hesias.car.dto.RacingCarDTO;
import fr.hesias.car.dto.SedanCarDTO;
import fr.hesias.car.model.Driver;
import fr.hesias.car.model.RacingCar;
import fr.hesias.car.model.SedanCar;
import fr.hesias.car.repository.DriverRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class DriverService {

    private final DriverRepository driverRepository;
    private final DriverConverter driverConverter;

    public DriverService(DriverRepository driverRepo, DriverConverter driverConverter) {
        this.driverRepository = driverRepo;
        this.driverConverter = driverConverter;
    }
    @Transactional(readOnly = true)
    public List<DriverDTO> findAll() {
        List<Driver> drivers = this.driverRepository.findAll();
        List<DriverDTO> driverDTOS = this.driverConverter.listEntityToListDto(drivers);
        return driverDTOS;
    }

    @Transactional(rollbackFor = Exception.class)
    public DriverDTO createDriver(DriverDTO driverDTO) {
        Driver driver = this.driverConverter.dtoToEntity(driverDTO);
        driver = this.driverRepository.save(driver);
        return this.driverConverter.entityToDto(driver);
    }

    @Transactional(rollbackFor = Exception.class)
    public void createDriverSedanCar(UUID driverID, SedanCarDTO carDTO) {
        this.driverRepository.addCarToDriver(driverID, new SedanCar(carDTO.getId()));
    }

    @Transactional(rollbackFor = Exception.class)
    public void createDriverRacingCar(UUID driverID, RacingCarDTO carDTO) {
        this.driverRepository.addCarToDriver(driverID, new RacingCar(carDTO.getId()));
    }
}
