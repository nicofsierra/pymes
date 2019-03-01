package ar.com.pymes.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.com.pymes.modelo.Usuario;
import ar.com.pymes.servicios.ServicioLogin;
import ar.com.pymes.servicios.ServicioValidarAdministrador;

@Controller
public class ControladorLogin {
	
	@Inject
	private ServicioLogin servicioLogin;
	@Inject 
	private ServicioValidarAdministrador servicioValidarAdministrador;
	
	@RequestMapping(path = "/")
	public ModelAndView inicio(){
		return new ModelAndView("redirect:/index");
	}
	
	@RequestMapping(path="/index")
	public ModelAndView irAIndex(){
		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		return new ModelAndView("index",modelo);
	}
	
	@RequestMapping(path="/login",method=RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuario , HttpServletRequest request){
		ModelMap modelo = new ModelMap();
		Usuario usuarioBuscado = servicioLogin.buscarUsuario(usuario);
		if( usuario != null ){
			request.getSession().setAttribute("usuario", usuarioBuscado);
			modelo.put("usuario",usuarioBuscado);
			if(servicioLogin.validarAdministrador(usuarioBuscado.getIdUsuario())!=null){
				return new ModelAndView("administrar",modelo);
			}
			else{
				return new ModelAndView("principal",modelo);
				}
			}
		else{
			modelo.put("error", "El usuario es incorrecto");
			return new ModelAndView("index",modelo);
		}
	
	}
	
	@RequestMapping("/administrar")
	public ModelAndView irAAdministrar(HttpServletRequest request){
		ModelMap modelo = new ModelMap();
		
		if( servicioValidarAdministrador.validarAdministrador(request) ){
			return new ModelAndView("administrar",modelo);
		}else{
			modelo.put("error", "No es administrador");
			return new ModelAndView("principal",modelo);
		}	
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request){
		request.getSession().removeAttribute("usuario");
		return new ModelAndView("redirect:/index");
	}
	
	

}
