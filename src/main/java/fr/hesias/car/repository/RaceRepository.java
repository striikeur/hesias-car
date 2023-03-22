package fr.hesias.car.repository;

import fr.hesias.car.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RaceRepository extends JpaRepository<Race, UUID> {

    @Query("select r from Race r where r.winner.id = :winner_id ")
    List<Race> findByWinnerId(@Param("winner_id") UUID winnerId);

}
