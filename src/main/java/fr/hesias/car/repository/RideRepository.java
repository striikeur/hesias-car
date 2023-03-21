package fr.hesias.car.repository;

import fr.hesias.car.model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RideRepository extends JpaRepository<Ride, UUID> {
    List<Ride> findByDateGreaterThan(Long date);

    List<Ride> findByDateLessThanEqual(Long date);
}
