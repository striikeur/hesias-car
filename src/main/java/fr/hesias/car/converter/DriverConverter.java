package fr.hesias.car.converter;

import fr.hesias.car.dto.CarDTO;
import fr.hesias.car.dto.DriverDTO;
import fr.hesias.car.model.Driver;

import java.util.ArrayList;
import java.util.List;

public class DriverConverter implements EntityToDtoConverter<Driver, DriverDTO> {
    @Override
    public Driver dtoToEntity(DriverDTO driverDTO) {
        return new Driver(driverDTO.getId(), driverDTO.getName(), driverDTO.getAge());
    }

    @Override
    public DriverDTO entityToDto(Driver driver) {
        DriverDTO driverDTO = new DriverDTO();
        driverDTO.setId(driver.getId());
        driverDTO.setName(driver.getName());
        driverDTO.setAge(driver.getAge());
        CarDTO carDTO = new CarDTO();
        carDTO.setId(driver.getCar().getId());
        driverDTO.setCar(carDTO);
        return driverDTO;
    }

    @Override
    public List<DriverDTO> listEntityToListDto(List<Driver> drivers) {
        List<DriverDTO> driverDTOS = new ArrayList<>();
        for(Driver driver: drivers) {
            driverDTOS.add(this.entityToDto(driver));
        }
        return driverDTOS;
    }

    @Override
    public List<Driver> listDtoToListEntity(List<DriverDTO> driverDTOS) {
        List<Driver> drivers = new ArrayList<>();
        for(DriverDTO driverDTO: driverDTOS) {
            drivers.add(this.dtoToEntity(driverDTO));
        }
        return drivers;
    }
}
