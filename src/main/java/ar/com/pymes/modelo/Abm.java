package ar.com.pymes.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Abm {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name="administrador")
	private Administrador administrador;
	
	@ManyToOne
	@JoinColumn(name="errores")
	private Errores errores;
	
	@OneToOne(mappedBy="abm")
	private Pais pais;
	
	public Abm(){}

	public Abm(Long id, Date fecha, Administrador administrador, Errores errores, Pais pais) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.administrador = administrador;
		this.errores = errores;
		this.pais = pais;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public Errores getErrores() {
		return errores;
	}

	public void setErrores(Errores errores) {
		this.errores = errores;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

}
