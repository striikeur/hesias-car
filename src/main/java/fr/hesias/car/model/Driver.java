package fr.hesias.car.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

@Entity
@Table(name = "drivers")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Driver {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name", length = 150)
    @NotNull
    @Size(min = 2, max = 150)
    private String name;

    @Column(name = "age")
    @Min(5)
    @Min(200)
    private Integer age;

    @JoinColumn(name = "car_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Car car;

    protected Driver() {
    }

    public Driver(UUID id, String name, Integer age, Car car) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.car = car;
    }
}
