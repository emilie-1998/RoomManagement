package fr.insa.HeatingSystemManagement.model;

public class HSSensor {
	private int id;
	private int value;
	
	public HSSensor(int id, int value) {
		this.id=id;
		this.value=value;
	}
	
	public HSSensor() {}

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
