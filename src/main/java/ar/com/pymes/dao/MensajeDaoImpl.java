package ar.com.pymes.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import ar.com.pymes.modelo.Retorno;

@Service("mensajeDao")
public class MensajeDaoImpl implements MensajeDao{
	
	@Inject
	private SessionFactory sessionFactory;

	@Override
	public String traerMensaje(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		
		Retorno error = (Retorno) session.createCriteria(Retorno.class).add(Restrictions.eq("id", id)).uniqueResult();
		return error.getDescripcion();
	
	}


}
