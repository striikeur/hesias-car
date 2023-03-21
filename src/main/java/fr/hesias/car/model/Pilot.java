package fr.hesias.car.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pilots")
public class Pilot extends Driver {

    @Column(name = "height")
    @Min(150)
    @Max(260)
    private Integer height;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "winner")
    private List<Race> races;

    protected Pilot() {
    }

    public Pilot(UUID id, String name, Integer age, Integer height) {
        super(id, name, age);
        this.height = height;
    }

    public Integer getHeight() {
        return height;
    }
}
