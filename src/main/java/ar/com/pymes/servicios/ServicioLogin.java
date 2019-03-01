package ar.com.pymes.servicios;

import ar.com.pymes.modelo.Administrador;
import ar.com.pymes.modelo.Usuario;

public interface ServicioLogin {
	
	Usuario buscarUsuario(Usuario usuario);
	Administrador validarAdministrador(Long idUsuario);

}
