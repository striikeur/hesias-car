package fr.hesias.car.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "races")
public class Race extends Ride {

    @Column(name = "race_track")
    @Size(max = 150)
    private String raceTrack;

    @JoinColumn(name = "winner_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Pilot winner;


    @ManyToMany(fetch = FetchType.LAZY)
    private List<Car> cars;

    protected Race() {
    }

    public Race(UUID id, String name, String departure, String arrival, Long date, String raceTrack, Pilot winner) {
        super(id, name, departure, arrival, date);
        this.raceTrack = raceTrack;
        this.winner = winner;
    }

    public String getRaceTrack() {
        return raceTrack;
    }

    public Pilot getWinner() {
        return winner;
    }

    public List<Car> getCars() {
        return cars;
    }
}
