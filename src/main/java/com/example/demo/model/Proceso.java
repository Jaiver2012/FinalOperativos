package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@NoArgsConstructor
public class Proceso {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long id;

		private String nombre;
		private String cpu;
		private String si;
		private String pm;
		private String npm;

//
//		public Proceso(Long id, String name, String cpu, String npm, String si, String pm) {
//			this.id=id;
//			this.nombre=name;
//			this.cpu=cpu;
//			this.npm=npm;
//			this.si=si;
//			this.pm=pm;
//			
//		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getNombre() {
			return nombre;
		}


		public void setNombre(String nombre) {
			this.nombre = nombre;
		}


		public String getCpu() {
			return cpu;
		}


		public void setCpu(String cpu) {
			this.cpu = cpu;
		}


		public String getSi() {
			return si;
		}


		public void setSi(String si) {
			this.si = si;
		}


		public String getPm() {
			return pm;
		}


		public void setPm(String pm) {
			this.pm = pm;
		}


		public String getNpm() {
			return npm;
		}


		public void setNpm(String npm) {
			this.npm = npm;
		}
		
		//agrego los getteres y settesr porque el data no funciona
		
		
		
}
