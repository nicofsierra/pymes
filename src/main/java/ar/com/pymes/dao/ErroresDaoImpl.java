package ar.com.pymes.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import ar.com.pymes.modelo.Errores;

@Service("erroresDao")
public class ErroresDaoImpl implements ErroresDao{
	
	@Inject
	private SessionFactory sessionFactory;

	@Override
	public String traerError(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		
		Errores error = (Errores) session.createCriteria(Errores.class).add(Restrictions.eq("id", id)).uniqueResult();
		return error.getDescripcion();
	
	}


}
