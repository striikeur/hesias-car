package fr.hesias.car.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


import java.util.UUID;

@Entity
@Table(name = "cars")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name", length = 100, nullable = false)
    @Size(min = 3, max = 100)
    @NotNull
    private String name;

    @Column(name = "brand",length = 100, nullable = false)
    @Size(min = 3, max = 100)
    @NotNull
    private String brand;

    @Column(name = "horse_power")
    @Min(0)
    @NotNull
    private Integer horsePower;

    @Column(name = "fuel_comsuption")
    @Min(0)
    @NotNull
    private Float fuelConsumption;

    @Column(name = "fuel_capacity")
    @Min(0)
    @NotNull
    private Float fuelCapacity;

    protected Car() {
    }

    public Car(UUID id, String name, String brand, Integer horsePower, Float fuelConsumption, Float fuelCapacity) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.horsePower = horsePower;
        this.fuelConsumption = fuelConsumption;
        this.fuelCapacity = fuelCapacity;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public Float getFuelConsumption() {
        return fuelConsumption;
    }

    public Float getFuelCapacity() {
        return fuelCapacity;
    }
}
