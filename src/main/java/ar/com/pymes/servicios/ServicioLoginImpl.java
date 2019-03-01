package ar.com.pymes.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.pymes.dao.LoginDao;
import ar.com.pymes.modelo.Administrador;
import ar.com.pymes.modelo.Usuario;

@Service("servicioLogin")
@Transactional
public class ServicioLoginImpl implements ServicioLogin {

	@Inject
	private LoginDao loginDao;

	@Override
	public Usuario buscarUsuario(Usuario usuario) {

		return loginDao.buscarUsuario(usuario);
	}

	@Override
	public Administrador validarAdministrador(Long idUsuario) {
		
		return loginDao.validarAdministrador(idUsuario);
	}

}
