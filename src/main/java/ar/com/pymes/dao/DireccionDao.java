package ar.com.pymes.dao;

import java.util.List;

import ar.com.pymes.modelo.Pais;
import ar.com.pymes.modelo.Provincia;

public interface DireccionDao {
	
	public Boolean abm(Provincia provincia, String accion);
	public Boolean abm(Pais pais,String accion);
	public List<Pais> buscarPaises();
	public Pais buscarPais(Long id);
	public List<Provincia> buscarProvincias();
	public Provincia buscarProvincia(Long id);

}
