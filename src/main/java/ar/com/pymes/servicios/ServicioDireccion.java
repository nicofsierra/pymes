package ar.com.pymes.servicios;

import java.util.List;

import ar.com.pymes.modelo.Pais;

public interface ServicioDireccion {
	
	public List<Pais> buscarPaises();
	public Boolean abmPais(Pais pais, String accion);
	public Pais buscarPais(Long id);

}
