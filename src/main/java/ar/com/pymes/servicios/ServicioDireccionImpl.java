package ar.com.pymes.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.pymes.dao.DireccionDao;
import ar.com.pymes.modelo.Pais;
import ar.com.pymes.modelo.Provincia;

@Service("servicioDireccion")
@Transactional
public class ServicioDireccionImpl implements ServicioDireccion{
	
	@Inject
	private DireccionDao direccionDao;
	
	@Override
	public List<Pais> buscarPaises(){
		return direccionDao.buscarPaises();
	}
	
	@Override
	public Boolean abm(Pais pais,String accion){
		return direccionDao.abm(pais,accion);
	}
	
	@Override
	public Pais buscarPais(Long id){
		return direccionDao.buscarPais(id);
	}
	
	@Override
	public List<Provincia> buscarProvincias(){
		return direccionDao.buscarProvincias();
	}
	@Override
	public Boolean abm(Provincia provincia, String accion){
		return direccionDao.abm(provincia, accion);
	}
	@Override
	public Provincia buscarProvincia(Long id){
		return direccionDao.buscarProvincia(id);
	}
	

}
