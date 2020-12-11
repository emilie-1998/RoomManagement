package fr.insa.RoomProject.ShuttersManagement.model;

public class ShutterSensor {
	
	private int value;
	private Boolean enable;
	private int id;
	
	public ShutterSensor() {
		
	}	
	
	public ShutterSensor(Boolean enable) {
		this.enable = enable;
	}
	
	public ShutterSensor(int value, int id) {
		this.value = value;
		this.id = id;
	}
	
	public ShutterSensor(int value, Boolean enable, int id) {
		this.value = value;
		this.enable = enable;
		this.id = id;
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

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}


}
