package ar.com.pymes.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Factura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFactura;
	private Integer cantidad;
	private Float importe;
	
	@ManyToOne
	@JoinColumn(name="tipo")
	private TipoFactura tipo;
	
	@OneToOne(mappedBy="factura")
	private Venta venta;
	
	public Factura(){}

	public Factura(Long idFactura, Integer cantidad, Float importe, TipoFactura tipo, Venta venta) {
		super();
		this.idFactura = idFactura;
		this.cantidad = cantidad;
		this.importe = importe;
		this.tipo = tipo;
		this.venta = venta;
	}

	public Long getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Float getImporte() {
		return importe;
	}

	public void setImporte(Float importe) {
		this.importe = importe;
	}

	public TipoFactura getTipo() {
		return tipo;
	}

	public void setTipo(TipoFactura tipo) {
		this.tipo = tipo;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	
}
