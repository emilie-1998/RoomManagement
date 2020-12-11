package fr.insa.RoomProject.ShuttersManagement.Controller;

import fr.insa.RoomProject.ShuttersManagement.model.ShutterSensor;
import fr.insa.RoomProject.ShuttersManagement.model.ShutterActuator;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/auto")
public class AutomationRessource {
	
	@GetMapping(value="/management")
	public String shutterManagement() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		String message = "";
		
		ShutterActuator actuator = restTemplate.getForObject("http://localhost:8080/shutter/actuator/1", ShutterActuator.class);
		ShutterSensor sensor=restTemplate.getForObject("http://localhost:8080/shutter/sensor/1", ShutterSensor.class);

		message += "State of the shutters : "+ actuator.getState();
		
		message += "Command : "+ actuator.getOrder();
		
		if((sensor.getValue() < 250) & (actuator.getState()==true)) {
			actuator.setState(false);
			actuator.setOrder(1);
		}
		
		if((sensor.getValue() > 250) & (actuator.getState()==false)) {
			actuator.setState(true);
			actuator.setOrder(0);
		}
				
		return message;
		
	}

}
