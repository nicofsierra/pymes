package ar.com.pymes.dao;

import java.util.List;

import ar.com.pymes.modelo.Pais;

public interface DireccionDao {
	
	public List<Pais> buscarPaises();
	public Boolean abmPais(Pais pais, String accion);
	public Pais buscarPais(Long id);

}
