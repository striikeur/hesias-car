package fr.hesias.car.repository;

import fr.hesias.car.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {

    List<Car> findByBrand(String brand);

    @Query("from Car c where c.brand like :brand")
    List<Car> findByBrandLike(@Param("brand") String brand);
    List<Car> findByHorsePower(Integer horsePower);
    @Query("from Car c where c.horsePower > :horse_power")
    List<Car> findByHorsePowerGreaterThan(@Param("horse_power") Integer horsePower);
    List<Car> findByHorsePowerLessThanEqual(Integer horsePower);
    List<Car> findByFuelConsumption(Float fuelConsumption);
    List<Car> findByFuelConsumptionLessThanEqual(Float fuelConsumption);

}
