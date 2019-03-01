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
public class Provincia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProvincia;
	private String descripcion;
	
	@OneToMany(mappedBy="provincia")
	private List<Partido> partido = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="pais")
	private Pais pais;
	
	public Provincia(){}

	public Provincia(Long idProvincia, String descripcion, List<Partido> partido, Pais pais) {
		super();
		this.idProvincia = idProvincia;
		this.descripcion = descripcion;
		this.partido = partido;
		this.pais = pais;
	}

	public Long getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(Long idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Partido> getPartido() {
		return partido;
	}

	public void setPartido(List<Partido> partido) {
		this.partido = partido;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
}