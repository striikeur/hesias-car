package fr.hesias.car.repository;

import fr.hesias.car.model.RacingCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RacingCarRepository extends JpaRepository<RacingCar, UUID> {

    List<RacingCar> findByTopSpeedGreaterThanEqual(Float topSpeed);
}
