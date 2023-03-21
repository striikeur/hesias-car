package fr.hesias.car.repository;

import fr.hesias.car.model.Car;
import fr.hesias.car.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DriverRepository extends JpaRepository<Driver, UUID> {

    List<Driver> findByAge(Integer age);

    @Query("update Driver d set d.car = :car")
    int addCarToDriver(@Param("car") Car car);
}
