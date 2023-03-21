package fr.hesias.car.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Entity
@Table(name = "sedan_cars")
public class SedanCar extends Car {

    @Column(name = "trunk_space")
    @Min(0)
    @NotNull
    private Integer trunkSpace;

    protected SedanCar() {
    }

    public SedanCar(UUID id) {
        super(id);
    }

    public SedanCar(UUID id, String name, String brand, Integer horsePower, Float fuelConsumption, Float fuelCapacity, Integer trunkSpace) {
        super(id, name, brand, horsePower, fuelConsumption, fuelCapacity);
        this.trunkSpace = trunkSpace;
    }

    public Integer getTrunkSpace() {
        return trunkSpace;
    }
}
