package fr.hesias.car.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Entity
@Table(name = "racing_cars")
public class RacingCar extends Car {

    @Column(name = "top_speed")
    @Min(0)
    @NotNull
    private Float topSpeed;

    protected RacingCar() {
    }

    public RacingCar(UUID id, String name, String brand, Integer horsePower, Float fuelConsumption, Float fuelCapacity, Float topSpeed) {
        super(id, name, brand, horsePower, fuelConsumption, fuelCapacity);
        this.topSpeed = topSpeed;
    }

    public Float getTopSpeed() {
        return topSpeed;
    }
}
