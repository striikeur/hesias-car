package fr.hesias.car.dto;

import java.util.UUID;

public class CarDTO {

    private UUID id;
    private String name;
    private String brand;
    private Integer horsePower;
    private Float fuelConsumption;
    private Float fuelCapacity;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    public Float getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(Float fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public Float getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(Float fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }
}
