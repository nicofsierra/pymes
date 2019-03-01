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
public class Partido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPartido;
	private String descripcion;
	
	@OneToMany(mappedBy="partido")
	private List<Localidad> localidad = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="provincia")
	private Provincia provincia;
	
	public Partido(){}

	public Partido(Long idPartido, String descripcion, List<Localidad> localidad, Provincia provincia) {
		super();
		this.idPartido = idPartido;
		this.descripcion = descripcion;
		this.localidad = localidad;
		this.provincia = provincia;
	}

	public Long getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(Long idPartido) {
		this.idPartido = idPartido;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Localidad> getLocalidad() {
		return localidad;
	}

	public void setLocalidad(List<Localidad> localidad) {
		this.localidad = localidad;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	
	
}
