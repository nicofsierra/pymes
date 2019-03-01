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
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProducto;
	private String descripcion;
	private Float precio_unitario;
	
	@OneToMany(mappedBy="producto")
	private List<DetalleVenta> detalleVenta = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="administrador")
	private Administrador administrador;
	
	@OneToOne
	@JoinColumn(name="stock")
	private Stock stock; 
	
	public Producto(){}

	public Producto(Long idProducto, String descripcion, Float precio_unitario, List<DetalleVenta> detalleVenta,
			Administrador administrador, Stock stock) {
		super();
		this.idProducto = idProducto;
		this.descripcion = descripcion;
		this.precio_unitario = precio_unitario;
		this.detalleVenta = detalleVenta;
		this.administrador = administrador;
		this.stock = stock;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getPrecio_unitario() {
		return precio_unitario;
	}

	public void setPrecio_unitario(Float precio_unitario) {
		this.precio_unitario = precio_unitario;
	}
	
	public List<DetalleVenta> getDetalleVenta() {
		return detalleVenta;
	}

	public void setDetalleVenta(List<DetalleVenta> detalleVenta) {
		this.detalleVenta = detalleVenta;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

}
