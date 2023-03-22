package fr.hesias.car.converter;

import fr.hesias.car.dto.SedanCarDTO;
import fr.hesias.car.model.SedanCar;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SedanCarConverter extends EntityToDtoConverter<SedanCar, SedanCarDTO> {
    @Override
    public SedanCar dtoToEntity(SedanCarDTO sedanCarDTO) {
        return new SedanCar(sedanCarDTO.getId(),
                sedanCarDTO.getName(), sedanCarDTO.getBrand(), sedanCarDTO.getHorsePower(), sedanCarDTO.getFuelConsumption(), sedanCarDTO.getFuelCapacity(), sedanCarDTO.getTrunkSpace());
    }

    @Override
    public SedanCarDTO entityToDto(SedanCar sedanCar) {
        SedanCarDTO sedanCarDTO = new SedanCarDTO();
        sedanCarDTO.setId(sedanCar.getId());
        sedanCarDTO.setName(sedanCar.getName());
        sedanCarDTO.setBrand(sedanCar.getBrand());
        sedanCarDTO.setHorsePower(sedanCar.getHorsePower());
        sedanCarDTO.setFuelConsumption(sedanCar.getFuelConsumption());
        sedanCarDTO.setFuelCapacity(sedanCar.getFuelCapacity());
        sedanCarDTO.setTrunkSpace(sedanCar.getTrunkSpace());
        return sedanCarDTO;
    }

    @Override
    public List<SedanCarDTO> listEntityToListDto(List<SedanCar> sedanCars) {
        List<SedanCarDTO> sedanCarDtos = new ArrayList<>();
        for (SedanCar sedanCar : sedanCars) {
            sedanCarDtos.add(this.entityToDto(sedanCar));
        }
        return sedanCarDtos;
    }

    @Override
    public List<SedanCar> listDtoToListEntity(List<SedanCarDTO> sedanCarDTOS) {
        List<SedanCar> sedanCars = new ArrayList<>();
        for (SedanCarDTO sedanCarDTO : sedanCarDTOS) {
            sedanCars.add(this.dtoToEntity(sedanCarDTO));
        }
        return sedanCars;
    }
}
