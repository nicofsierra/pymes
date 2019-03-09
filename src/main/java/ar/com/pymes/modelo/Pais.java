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
import javax.persistence.OneToOne;

@Entity
public class Pais {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPais;
	private String descripcion;
	
	@OneToMany(mappedBy="pais")
	private List<Provincia> provincia = new ArrayList<>();
	
	@OneToOne
	@JoinColumn(name="abm")
	private Abm abm;
	
	@ManyToOne
	@JoinColumn(name="estado")
	private EstadoRegistro estado;
	
	public Pais(){}

	public Pais(Long idPais, String descripcion, List<Provincia> provincia, Abm abm, EstadoRegistro estado) {
		super();
		this.idPais = idPais;
		this.descripcion = descripcion;
		this.provincia = provincia;
		this.abm = abm;
		this.estado = estado;
	}
	
	public Abm getAbm() {
		return abm;
	}

	public void setAbm(Abm abm) {
		this.abm = abm;
	}

	public void setIdPais(Long pais) {
		this.idPais = pais;
	}

	public Long getIdPais() {
		return idPais;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Provincia> getProvincia() {
		return provincia;
	}

	public void setProvincia(List<Provincia> provincia) {
		this.provincia = provincia;
	}

	public EstadoRegistro getEstado() {
		return estado;
	}

	public void setEstado(EstadoRegistro estado) {
		this.estado = estado;
	}
		
}
