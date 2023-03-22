package fr.hesias.car;

import fr.hesias.car.dto.DriverDTO;
import fr.hesias.car.dto.SedanCarDTO;
import fr.hesias.car.service.DriverService;
import fr.hesias.car.service.SedanCarService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class CarApplication {
	private final DriverService driverService;
	private final SedanCarService sedanCarService;

	public CarApplication(DriverService driverService, SedanCarService sedanCarService) {
		this.driverService = driverService;
		this.sedanCarService = sedanCarService;
	}

	public static void main(String[] args) {
		SpringApplication.run(CarApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void createDefaultData() {
		DriverDTO driverDTO = createMe();
		SedanCarDTO sedanCarDTO = createClioV();

		createMe2();
		this.driverService.createDriverSedanCar(driverDTO.getId(), sedanCarDTO);

	}
	private SedanCarDTO createClioV() {
		SedanCarDTO sedanCarDTO = new SedanCarDTO();
		sedanCarDTO.setName("Clio V");
		sedanCarDTO.setBrand("Renault");
		sedanCarDTO.setHorsePower(100);
		sedanCarDTO.setFuelConsumption(9f);
		sedanCarDTO.setFuelCapacity(72f);
		sedanCarDTO.setTrunkSpace(300);
		sedanCarDTO = this.sedanCarService.createSedanCar(sedanCarDTO);
		return sedanCarDTO;
	}

	private DriverDTO createMe() {
		DriverDTO driverDTO = new DriverDTO();
		driverDTO.setName("Jules BONFILLOUP");
		driverDTO.setAge(23);
		driverDTO = this.driverService.createDriver(driverDTO);
		return driverDTO;
	}
	private DriverDTO createMe2() {
		DriverDTO driverDTO = new DriverDTO();
		driverDTO.setName("Jules BON");
		driverDTO.setAge(23);
		driverDTO = this.driverService.createDriver(driverDTO);
		return driverDTO;
	}
}
