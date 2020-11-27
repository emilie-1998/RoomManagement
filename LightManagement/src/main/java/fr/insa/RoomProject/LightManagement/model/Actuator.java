package fr.insa.RoomProject.LightManagement.model;

public class Actuator {
	private int id;
	private boolean state ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean getState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	
	public Actuator(int id, boolean state) {
		super();
		this.id = id;
		this.state = state;
	}
	
	public Actuator() {
	}


}
