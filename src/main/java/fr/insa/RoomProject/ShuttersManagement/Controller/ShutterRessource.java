package fr.insa.RoomProject.ShuttersManagement.Controller;

import fr.insa.RoomProject.ShuttersManagement.model.ShutterSensor;
import fr.insa.RoomProject.ShuttersManagement.model.ShutterActuator;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/shutter")
public class ShutterRessource {
	
	private ShutterActuator shutter_new= new ShutterActuator(true,5,0.5);
	
	@GetMapping("/")
	public ShutterActuator getShutter() {
		return shutter_new;
	}
	
	@GetMapping(value="/sensor/{id}")
	public ShutterSensor infosShutter(@PathVariable int id) {
		ShutterSensor shutterSensor = new ShutterSensor(7, false, id);
		return shutterSensor;
	}
	
	@GetMapping(value="/actuator/{id}")
	public ShutterActuator infosShutterActuator(@PathVariable int id) {
		ShutterActuator shutterActuator = new ShutterActuator(false, id, 0.5);
		return shutterActuator;
	}
	
	@GetMapping("/status")
	public String getStatus() {
		if (shutter_new.getState()==true) {
			return "ouvert";
		}
		else {
			return "fermé";
		}
	}
	
	@PostMapping("/order")
	public double setOrder(@RequestParam double value) {
		shutter_new.setOrder(value);
		return value;
	}
	
	@PutMapping("/")
	public void updateShutter(@RequestBody ShutterActuator shutter) {
		this.shutter_new.setOrder(shutter.getOrder());
	}

}
