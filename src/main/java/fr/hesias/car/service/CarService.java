package fr.hesias.car.service;

import fr.hesias.car.dto.CarDTO;
import fr.hesias.car.model.Car;
import fr.hesias.car.repository.CarRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Transactional(readOnly = true)
    public List<CarDTO> findAllByBrand(String brand) {
        List<Car> cars = this.carRepository.findByBrandLike(brand);
        List<CarDTO> carDTOS = new ArrayList<>();
        for(Car car: cars) {
            CarDTO carDTO = new CarDTO();
            BeanUtils.copyProperties(car, carDTO);
            carDTOS.add(carDTO);
        }
        return carDTOS;
    }

    @Transactional(readOnly = true)
    public List<CarDTO> findAllByHorsePowerGreaterThan(Integer horsePower) {
        List<Car> cars = this.carRepository.findByHorsePowerGreaterThan(horsePower);
        List<CarDTO> carDTOS = new ArrayList<>();
        for(Car car: cars) {
            CarDTO carDTO = new CarDTO();
            BeanUtils.copyProperties(car, carDTO);
            carDTOS.add(carDTO);
        }
        return carDTOS;
    }
}
