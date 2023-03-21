package fr.hesias.car.repository;

import fr.hesias.car.model.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PilotRepository extends JpaRepository<Pilot, UUID> {

    @Query("select r.winner from RaceDTO r where r.raceTrack like :race")
    List<Pilot> findByRace(@Param("race") String race);

}
