package ar.com.pymes.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idStock;
	private Integer cantidad;
	@OneToOne(mappedBy="stock")
	private Producto producto;
	
	public Stock(){}

	public Stock(Long idStock, Integer cantidad, Producto producto) {
		super();
		this.idStock = idStock;
		this.cantidad = cantidad;
		this.producto = producto;
	}

	public Long getIdStock() {
		return idStock;
	}

	public void setIdStock(Long idStock) {
		this.idStock = idStock;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
