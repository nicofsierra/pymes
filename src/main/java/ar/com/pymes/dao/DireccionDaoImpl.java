package ar.com.pymes.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import ar.com.pymes.modelo.Pais;

@Service("direccionDao")
public class DireccionDaoImpl implements DireccionDao {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<Pais> buscarPaises() {
		final Session session = sessionFactory.getCurrentSession();
		return (List<Pais>) session.createCriteria(Pais.class, "p").list();
	}

	@Override
	public Boolean abmPais(Pais pais, String accion) {
		final Session session = sessionFactory.getCurrentSession();
		
		
		/*try {
			switch (accion) {
			case "a":
				session.save(pais);
			case "b":
				session.delete(pais);
			case "m":
				session.saveOrUpdate(pais);
			default:
				;
			}
		} catch (Exception e) {
			return false;
		}*/
		
		
		if(accion.equals("a")){
			session.save(pais);
		}else{
			if(accion.equals("b")){
				session.delete(pais);
			}else{
				if(accion.equals("m")){
					session.saveOrUpdate(pais);
				}else{
					return false;
				}
			}
		}
		
		return true;
	}

	@Override
	public Pais buscarPais(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		return (Pais) session.createCriteria(Pais.class).add(Restrictions.eq("idPais", id)).uniqueResult();
	}

}
