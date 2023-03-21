package fr.hesias.car.dto;

import java.util.List;

public class RaceDTO extends RideDTO {
    private String raceTrack;
    private PilotDTO winner;
    private List<CarDTO> cars;


    public String getRaceTrack() {
        return raceTrack;
    }

    public void setRaceTrack(String raceTrack) {
        this.raceTrack = raceTrack;
    }

    public PilotDTO getWinner() {
        return winner;
    }

    public void setWinner(PilotDTO winner) {
        this.winner = winner;
    }

    public List<CarDTO> getCars() {
        return cars;
    }

    public void setCars(List<CarDTO> cars) {
        this.cars = cars;
    }
}
