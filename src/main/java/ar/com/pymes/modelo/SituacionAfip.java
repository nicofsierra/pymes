package ar.com.pymes.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SituacionAfip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSituacion;
	private String codigo;
	private String descripcion;
	
	@OneToMany(mappedBy="situacion")
	private List<Cliente> cliente = new ArrayList<>();
	
	public SituacionAfip(){}

	public SituacionAfip(Long idSituacion, String codigo, String descripcion, List<Cliente> cliente) {
		super();
		this.idSituacion = idSituacion;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.cliente = cliente;
	}

	public Long getIdSituacion() {
		return idSituacion;
	}

	public void setIdSituacion(Long idSituacion) {
		this.idSituacion = idSituacion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}
	
}
