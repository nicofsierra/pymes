package ar.com.pymes.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import ar.com.pymes.modelo.Pais;
import ar.com.pymes.modelo.Provincia;

@Service("direccionDao")
public class DireccionDaoImpl implements DireccionDao {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public Boolean abm(Pais pais, String accion) {
		final Session session = sessionFactory.getCurrentSession();

		if (accion.equals("a")) {
			session.save(pais);
		} else {
			if (accion.equals("b")) {
				session.delete(pais);
			} else {
				if (accion.equals("m")) {
					session.saveOrUpdate(pais);
				} else {
					return false;
				}
			}
		}

		return true;
	}

	@Override
	public Boolean abm(Provincia provincia, String accion) {
		final Session session = sessionFactory.getCurrentSession();

		if (accion.equals("a")) {
			session.save(provincia);
		} else {
			if (accion.equals("b")) {
				session.delete(provincia);
			} else {
				if (accion.equals("m")) {
					session.saveOrUpdate(provincia);
				} else {
					return false;
				}
			}
		}

		return true;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Pais> buscarPaises() {
		final Session session = sessionFactory.getCurrentSession();
		return (List<Pais>) session.createCriteria(Pais.class, "p").list();
	}

	@Override
	public Pais buscarPais(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		return (Pais) session.createCriteria(Pais.class).add(Restrictions.eq("idPais", id)).uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Provincia> buscarProvincias() {
		final Session session = sessionFactory.getCurrentSession();
		return (List<Provincia>) session.createCriteria(Provincia.class, "p").list();
	}

	@Override
	public Provincia buscarProvincia(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		return (Provincia) session.createCriteria(Provincia.class).add(Restrictions.eq("idProvincia", id))
				.uniqueResult();
	}

}
