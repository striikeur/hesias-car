package fr.hesias.car.converter;

import fr.hesias.car.dto.RacingCarDTO;
import fr.hesias.car.model.RacingCar;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RacingCarConverter extends EntityToDtoConverter<RacingCar, RacingCarDTO> {
    @Override
    public RacingCar dtoToEntity(RacingCarDTO racingCarDTO) {
        return new RacingCar(racingCarDTO.getId(),
                racingCarDTO.getName(), racingCarDTO.getBrand(), racingCarDTO.getHorsePower(), racingCarDTO.getFuelConsumption(), racingCarDTO.getFuelCapacity(), racingCarDTO.getTopSpeed());
    }

    @Override
    public RacingCarDTO entityToDto(RacingCar racingCar) {
        RacingCarDTO racingCarDTO = new RacingCarDTO();
        racingCarDTO.setId(racingCar.getId());
        racingCarDTO.setName(racingCar.getName());
        racingCarDTO.setBrand(racingCar.getBrand());
        racingCarDTO.setHorsePower(racingCar.getHorsePower());
        racingCarDTO.setFuelConsumption(racingCar.getFuelConsumption());
        racingCarDTO.setFuelCapacity(racingCar.getFuelCapacity());
        racingCarDTO.setTopSpeed(racingCar.getTopSpeed());
        return racingCarDTO;
    }
}
