package ar.com.pymes.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.pymes.dao.MensajeDao;

@Service("servicioMensaje")
@Transactional
public class ServicioMensajeImpl implements ServicioMensaje{
	
	@Inject
	private MensajeDao mensajeDao;
	
	public String traerMensaje(Long id){
		return mensajeDao.traerMensaje(id);
	}

}
