package fr.insa.HeatingSystemManagement.model;

public class HSActuator {
	private boolean state;
	private int id;
	private int value;
	
	public HSActuator(boolean state, int id, int value) {
		this.state=state;
		this.id=id;
		this.value=value;
	}
	
	public HSActuator() {}
	
	public boolean getState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
