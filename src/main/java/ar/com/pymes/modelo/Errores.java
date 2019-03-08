package ar.com.pymes.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Errores {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String descripcion;
	
	@OneToMany(mappedBy="errores")
	private List<Abm> abm = new ArrayList<>();
	
	public Errores(){}

	public Errores(Long id, String descripcion, List<Abm> abm) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.abm = abm;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Abm> getAbm() {
		return abm;
	}

	public void setAbm(List<Abm> abm) {
		this.abm = abm;
	}
	
}
