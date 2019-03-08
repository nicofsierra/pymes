package ar.com.pymes.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.pymes.dao.ErroresDao;

@Service("servicioErrores")
@Transactional
public class ServicioErroresImpl implements ServicioErrores{
	
	@Inject
	private ErroresDao erroresDao;
	
	public String traerError(Long id){
		return erroresDao.traerError(id);
	}

}
