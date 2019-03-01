package ar.com.pymes.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="idUsuario")
public class Administrador extends Usuario{
	

	@OneToMany(mappedBy="administrador")
	private List<Producto> producto = new ArrayList<>();
	
	public Administrador(){
		super();
	}
	
	public Administrador(List<Producto> producto) {
		super();
		this.producto = producto;
	}

	public List<Producto> getProducto() {
		return producto;
	}

	public void setProducto(List<Producto> producto) {
		this.producto = producto;
	}
	
}
