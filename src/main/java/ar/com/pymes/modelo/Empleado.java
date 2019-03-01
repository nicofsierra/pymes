package ar.com.pymes.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="idUsuario")
public class Empleado extends Usuario{
	
	private Integer legajo;
	
	@OneToMany(mappedBy="empleado")
	private List<Cliente> cliente = new ArrayList<>();
	
	@OneToMany(mappedBy="empleado")
	private List<Venta> venta = new ArrayList<>();
	
	public Empleado(){
		super();
	}

	public Empleado(Integer legajo, List<Cliente> cliente, List<Venta> venta) {
		super();
		this.legajo = legajo;
		this.cliente = cliente;
		this.venta = venta;
	}

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}

	public List<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}

	public List<Venta> getVenta() {
		return venta;
	}

	public void setVenta(List<Venta> venta) {
		this.venta = venta;
	}
	
}
