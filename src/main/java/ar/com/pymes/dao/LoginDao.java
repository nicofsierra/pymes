package ar.com.pymes.dao;

import ar.com.pymes.modelo.Administrador;
import ar.com.pymes.modelo.Usuario;

public interface LoginDao {
	
	Usuario buscarUsuario(Usuario usuario);
	
	Administrador validarAdministrador(Long idUsuario);

}
