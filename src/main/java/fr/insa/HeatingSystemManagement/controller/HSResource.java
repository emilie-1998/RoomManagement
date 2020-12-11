package fr.insa.HeatingSystemManagement.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.insa.HeatingSystemManagement.model.HSSensor;
import fr.insa.HeatingSystemManagement.model.HSActuator;

@RestController
@RequestMapping("/HeatingSystem")
public class HSResource {

	private HSSensor sensor = new HSSensor();
	HSActuator actuator = new HSActuator(false, 1, 21);
	private final String temperatureURI = "http://localhost:8080/HeatingSystem/Sensor/1";
	private final String hsURI = "http://localhost:8080/HeatingSystem/Actuator";
	
	@GetMapping(value="/Sensor/{id}")
	public HSSensor infosSensor(@PathVariable int id) {
		sensor.setId(id);
		// valeur à récupérer sur om2m
		return sensor;
	}
	
	@GetMapping(value="/Actuator")
	public HSActuator infosActuator() {
		return actuator;
	}
	
	//On fixe la valeur de la température du chauffage
	//Lorsqu'il s'allumera, ce sera à cette température
	@PostMapping("/setHStemperature")
	public void setHStemperature (@RequestParam int temp) {
		actuator.setValue(temp);
	}
	
	@GetMapping("/manage")
	public String HSManagement() {
		
		//Instanciate RestTemplate for REST calls
		RestTemplate restTemplate = new RestTemplate();
		//Message de notification
		String message = "";
		
		HSSensor sensor = restTemplate.getForObject(temperatureURI, HSSensor.class);
		message += "Température actuelle : " + sensor.getValue() + " ° et ";
		
		if (sensor.getValue()<18) {
			actuator.setState(true);
			//PostForObject
		}
		
		HSActuator actuator = restTemplate.getForObject(hsURI, HSActuator.class);
		if (actuator.getState() == true ) {
			message += "le chauffage est allumé à " + actuator.getValue() + " °\n";
		}
		else {
			message += "le chauffage est éteint\n";
		}
			

		return message;
	}
}
