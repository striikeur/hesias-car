package fr.hesias.car.repository;

import fr.hesias.car.model.SedanCar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SedanCarRepository extends JpaRepository<SedanCar, UUID> {

    List<SedanCar> findByTrunkSpaceGreaterThan(Float trunkSpace);
    List<SedanCar> findFirstByTrunkSpace(Float trunkSpace);

}
