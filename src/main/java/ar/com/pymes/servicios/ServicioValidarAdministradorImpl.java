package ar.com.pymes.servicios;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import ar.com.pymes.modelo.Usuario;

@Service("servicioValidarAdministrador")
public class ServicioValidarAdministradorImpl implements ServicioValidarAdministrador{

	@Inject 
	private ServicioLogin servicioLogin;
	
	public Boolean validarAdministrador(HttpServletRequest request){
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		
		try{
			if(servicioLogin.validarAdministrador(usuario.getIdUsuario()).getNombre().isEmpty());
			return true;
		}catch(Exception e){
			return false;
		}
		
	}
	
}
