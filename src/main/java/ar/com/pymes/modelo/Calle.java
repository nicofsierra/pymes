package ar.com.pymes.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Calle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCalle;
	private String descripcion;
	
	@OneToMany(mappedBy="calle")
	private List<Direccion> direccion = new ArrayList<>();
	
	@OneToMany(mappedBy="calle")
	private List<CalleLocalidad> calleLocalidad = new ArrayList<>();
	
	public Calle(){
	}

	public Calle(Long idCalle, String descripcion, List<Direccion> direccion, List<CalleLocalidad> calleLocalidad) {
		super();
		this.idCalle = idCalle;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.calleLocalidad = calleLocalidad;
	}
	
	public List<Direccion> getDireccion() {
		return direccion;
	}

	public void setDireccion(List<Direccion> direccion) {
		this.direccion = direccion;
	}

	public List<CalleLocalidad> getCalleLocalidad() {
		return calleLocalidad;
	}

	public void setCalleLocalidad(List<CalleLocalidad> calleLocalidad) {
		this.calleLocalidad = calleLocalidad;
	}

	public Long getIdCalle() {
		return idCalle;
	}

	public void setIdCalle(Long idCalle) {
		this.idCalle = idCalle;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
}
