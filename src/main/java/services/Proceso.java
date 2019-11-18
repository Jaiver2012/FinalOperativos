package services;

import lombok.Data;

@Data
public class Proceso {

	private String id;
	private String nombre;
	private String cpu;
	private String si;
	private String pm;
	private String npm;


	public Proceso(String id, String name, String cpu, String npm, String si, String pm) {
		this.id=id;
		this.nombre=name;
		this.cpu=cpu;
		this.npm=npm;
		this.si=si;
		this.pm=pm;
		
	}
	
	



}
