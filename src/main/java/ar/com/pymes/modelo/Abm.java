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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Date fecha;

	@ManyToOne
	@JoinColumn(name = "administrador")
	private Administrador administrador;

	@ManyToOne
	@JoinColumn(name = "errores")
	private Retorno errores;

	@OneToOne(mappedBy = "abm")
	private Pais pais;

	@ManyToOne
	@JoinColumn(name = "estado")
	private EstadoRegistro estado;

	public Abm() {
	}

	public Abm(Long id, Date fecha, Administrador administrador, Retorno errores, Pais pais, EstadoRegistro estado) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.administrador = administrador;
		this.errores = errores;
		this.pais = pais;
		this.estado = estado;
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

	public Retorno getErrores() {
		return errores;
	}

	public void setErrores(Retorno errores) {
		this.errores = errores;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public EstadoRegistro getEstado() {
		return estado;
	}

	public void setEstado(EstadoRegistro estado) {
		this.estado = estado;
	}

}
