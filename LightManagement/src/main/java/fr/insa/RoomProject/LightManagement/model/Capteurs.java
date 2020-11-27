package fr.insa.RoomProject.LightManagement.model;

public class Capteurs {
	
	private int id;
	private int value ;
	
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
	
	public Capteurs(){
	}
	
	public Capteurs(int id, int value) {
		super();
		this.id = id;
		this.value = value;
	}
	
}
