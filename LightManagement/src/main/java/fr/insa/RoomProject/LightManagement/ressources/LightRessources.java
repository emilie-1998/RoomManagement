package fr.insa.RoomProject.LightManagement.ressources;

import org.springframework.web.bind.annotation.GetMapping ;

import org.springframework.web.bind.annotation.PathVariable ;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.client.RestTemplate;

import fr.insa.RoomProject.LightManagement.model.*;

@RestController
@RequestMapping("/Light")
public class LightRessources {
	/* Creation du capteur*/
	private Capteurs capteur= new Capteurs(1,20);
	Actuator actuator = new Actuator(1,false);
	
	
	@GetMapping("/valueCapteur")
	public int getValueCapteur() {
		return capteur.getValue();
	}
	
	@GetMapping("/statusActuator")
	public boolean getStatusActuator() {
		return actuator.getState();
	}
	
	@PostMapping(value="/ChangeState/{state}")
	public void setOrder(@RequestParam boolean state) {
		actuator.setState(state);
	}
	
	@GetMapping(value ="/management")
	public String managementLight() {
	//Instanciate RestTeplate for Rest calls
	RestTemplate restTemplate = new RestTemplate();
	int capteurValue= restTemplate.getForObject("http://localhost:8080/valueCapteur", Integer.class);
	if (capteurValue < 20) { // si luminosité basse, on allume la lumiere
		actuator.setState(true);
	}
	else{
		actuator.setState(false);
	}
	
	if (actuator.getState()==true) {
		return "La lumiere est alumee car la luminosite est de : " + String.valueOf(capteurValue); }
	else {
		return "La lumiere est eteinte car la luminosite est de : " + String.valueOf(capteurValue); }
	}
}
