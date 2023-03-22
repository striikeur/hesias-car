package fr.hesias.car.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.UUID;

@Entity
@Table(name = "rides")
@Inheritance(strategy = InheritanceType.JOINED)
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "departure", length = 200)
    @Size(min = 10, max = 200)
    private String departure;
    @Column(name = "arrival", length = 200)
    @Size(min = 10, max = 200)
    private String arrival;

    @Column(name = "date")
    private Long date;

    protected Ride() {
    }

    public Ride(UUID id, String name, String departure, String arrival, Long date) {
        this.id = id;
        this.name = name;
        this.departure = departure;
        this.arrival = arrival;
        this.date = date;
    }
}
