package fr.hesias.car.dto;

import java.util.List;

public class PilotDTO extends DriverDTO {

    private Integer height;
    private List<RaceDTO> races;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public List<RaceDTO> getRaces() {
        return races;
    }

    public void setRaces(List<RaceDTO> races) {
        this.races = races;
    }
}
