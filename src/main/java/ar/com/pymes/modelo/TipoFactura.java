package ar.com.pymes.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TipoFactura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipo;
	private String tipo;
	private String descripcion;
	
	@OneToMany(mappedBy="tipo")
	private List<Factura> factura = new ArrayList<>();
	
	public TipoFactura(){}

	public TipoFactura(Long idTipo, String tipo, String descripcion, List<Factura> factura) {
		super();
		this.idTipo = idTipo;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.factura = factura;
	}

	public Long getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Long idTipo) {
		this.idTipo = idTipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Factura> getFactura() {
		return factura;
	}

	public void setFactura(List<Factura> factura) {
		this.factura = factura;
	}
	
}
