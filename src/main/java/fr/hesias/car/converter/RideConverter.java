package fr.hesias.car.converter;

import fr.hesias.car.dto.RideDTO;
import fr.hesias.car.model.Ride;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RideConverter extends EntityToDtoConverter<Ride, RideDTO> {
    @Override
    public Ride dtoToEntity(RideDTO rideDTO) {
        return new Ride(rideDTO.getId(), rideDTO.getName(), rideDTO.getDeparture(), rideDTO.getArrival(), rideDTO.getDate());
    }

    @Override
    public RideDTO entityToDto(Ride ride) {
        RideDTO rideDTO = new RideDTO();
        BeanUtils.copyProperties(ride, rideDTO);
        return rideDTO;
    }
}
