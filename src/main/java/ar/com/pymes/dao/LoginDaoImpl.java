package ar.com.pymes.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import ar.com.pymes.modelo.Administrador;
import ar.com.pymes.modelo.Usuario;

@Service("loginDao")
public class LoginDaoImpl implements LoginDao{
	
	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public Usuario buscarUsuario(Usuario usuario){
		final Session session = sessionFactory.getCurrentSession();
		return  (Usuario) session.createCriteria(Usuario.class)
			   .add(Restrictions.and(Restrictions.eq("email",usuario.getEmail()),Restrictions.eq("password",usuario.getPassword())))
			    .uniqueResult();
	}
	
	@Override
	public Administrador validarAdministrador(Long idUsuario){
		final Session session = sessionFactory.getCurrentSession();
		return (Administrador) session.createCriteria(Administrador.class)
									  .add(Restrictions.eq("idUsuario",idUsuario)).uniqueResult();
	}

}
