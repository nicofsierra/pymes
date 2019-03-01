package ar.com.pymes.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Localidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLocalidad;
	private String descripcion;
	
	@OneToMany(mappedBy="localidad")
	private List<CalleLocalidad> calleLocalidad = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="partido")
	private Partido partido;
	
	public Localidad(){}

	public Localidad(Long idLocalidad, String descripcion, List<CalleLocalidad> calleLocalidad, Partido partido) {
		super();
		this.idLocalidad = idLocalidad;
		this.descripcion = descripcion;
		this.calleLocalidad = calleLocalidad;
		this.partido = partido;
	}

	public Long getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(Long idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<CalleLocalidad> getCalleLocalidad() {
		return calleLocalidad;
	}

	public void setCalleLocalidad(List<CalleLocalidad> calleLocalidad) {
		this.calleLocalidad = calleLocalidad;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}
	
}
