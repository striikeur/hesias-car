package fr.hesias.car.converter;

import fr.hesias.car.dto.RideDTO;
import fr.hesias.car.model.Ride;

import java.util.List;

public class RideConverter extends EntityToDtoConverter<Ride, RideDTO> {
    @Override
    public Ride dtoToEntity(RideDTO rideDTO) {
        return null;
    }

    @Override
    public RideDTO entityToDto(Ride ride) {
        return null;
    }

    @Override
    public List<RideDTO> listEntityToListDto(List<Ride> rides) {
        return null;
    }

    @Override
    public List<Ride> listDtoToListEntity(List<RideDTO> rideDTOS) {
        return null;
    }
}
