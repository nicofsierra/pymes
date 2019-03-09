package ar.com.pymes.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class EstadoRegistro {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String tipo;
	
	@OneToMany(mappedBy="estado")
	private List<Abm> abm = new ArrayList<>();
	
	@OneToMany(mappedBy="estado")
	private List<Pais> pais = new ArrayList<>();
	
	public EstadoRegistro(){}

	public EstadoRegistro(Long id, String tipo, List<Abm> abm, List<Pais> pais) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.abm = abm;
		this.pais = pais;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Abm> getAbm() {
		return abm;
	}

	public void setAbm(List<Abm> abm) {
		this.abm = abm;
	}

	public List<Pais> getPais() {
		return pais;
	}

	public void setPais(List<Pais> pais) {
		this.pais = pais;
	}

}
