package fr.hesias.car.converter;

import fr.hesias.car.dto.CarDTO;
import fr.hesias.car.dto.DriverDTO;
import fr.hesias.car.model.Driver;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DriverConverter extends EntityToDtoConverter<Driver, DriverDTO> {
    @Override
    public Driver dtoToEntity(DriverDTO driverDTO) {
        return new Driver(driverDTO.getId(), driverDTO.getName(), driverDTO.getAge());
    }

    @Override
    public DriverDTO entityToDto(Driver driver) {
        DriverDTO driverDTO = new DriverDTO();
        BeanUtils.copyProperties(driver, driverDTO);
        //driverDTO.setId(driver.getId());
        //driverDTO.setName(driver.getName());
        //driverDTO.setAge(driver.getAge());

        if(driver.getCar() != null) {
            CarDTO carDTO = new CarDTO();
            carDTO.setId(driver.getCar().getId());
            driverDTO.setCar(carDTO);
        }
        return driverDTO;
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
