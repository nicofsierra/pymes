package ar.com.pymes.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.pymes.dao.DireccionDao;
import ar.com.pymes.modelo.Pais;

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
	public Boolean abmPais(Pais pais,String accion){
		return direccionDao.abmPais(pais,accion);
	}
	
	@Override
	public Pais buscarPais(Long id){
		return direccionDao.buscarPais(id);
	}
	

}
