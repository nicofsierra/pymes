package ar.com.pymes.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CalleLocalidad {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Integer alturaDesde;
	private Integer alturaHasta;
	
	@ManyToOne
	@JoinColumn(name="calle")
	private Calle calle;
	@ManyToOne
	@JoinColumn(name="localidad")
	private Localidad localidad;
	
	public CalleLocalidad(){}

	public CalleLocalidad(Long id, Integer alturaDesde, Integer alturaHasta, Calle calle, Localidad localidad) {
		super();
		this.id = id;
		this.alturaDesde = alturaDesde;
		this.alturaHasta = alturaHasta;
		this.calle = calle;
		this.localidad = localidad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAlturaDesde() {
		return alturaDesde;
	}

	public void setAlturaDesde(Integer alturaDesde) {
		this.alturaDesde = alturaDesde;
	}

	public Integer getAlturaHasta() {
		return alturaHasta;
	}

	public void setAlturaHasta(Integer alturaHasta) {
		this.alturaHasta = alturaHasta;
	}

	public Calle getCalle() {
		return calle;
	}

	public void setCalle(Calle calle) {
		this.calle = calle;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	
}
