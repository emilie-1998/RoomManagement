package fr.insa.RoomProject.ShuttersManagement.model;

public class ShutterActuator {
	
	private Boolean state;
	private int id;
	private double order;
	
	public ShutterActuator() {
		
	}
	
	public ShutterActuator(Boolean state, int id, double order) {
		this.state = state;
		this.id = id;
		this.order = order;
	}
	
	public double getOrder() {
		return order;
	}

	public void setOrder(double order) {
		this.order = order;
	}

	public Boolean getState() {
		return state;
	}
	public void setState(Boolean state) {
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
