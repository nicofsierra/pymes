package ar.com.pymes.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.com.pymes.modelo.CalleLocalidad;
import ar.com.pymes.modelo.Localidad;
import ar.com.pymes.modelo.Pais;
import ar.com.pymes.modelo.Partido;
import ar.com.pymes.servicios.ServicioDireccion;
import ar.com.pymes.servicios.ServicioValidarAdministrador;

@Controller
public class ControladorDirecciones {

	@Inject
	private ServicioDireccion servicioDireccion;

	@Inject
	private ServicioValidarAdministrador servicioValidarAdministrador;

	@RequestMapping("/direcciones")
	public ModelAndView irADirecciones(HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		if (servicioValidarAdministrador.validarAdministrador(request)) {
			return new ModelAndView("direcciones", modelo);
		} else {
			modelo.put("error", "No es administrador");
			return new ModelAndView("principal", modelo);
		}
	}

	@RequestMapping("/calles")
	public ModelAndView irACalles(HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		CalleLocalidad calleAltura = new CalleLocalidad();
		// Localidad localidad = ; //buscar localidades
		if (servicioValidarAdministrador.validarAdministrador(request)) {
			modelo.put("calleAltura", calleAltura);
			return new ModelAndView("calles", modelo);
		} else {
			modelo.put("error", "No es administrador");
			return new ModelAndView("principal", modelo);
		}
	}

	@RequestMapping("/localidades")
	public ModelAndView irALocalidades(HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		Localidad localidad = new Localidad();
		// Partido partido = // buscar provincias
		if (servicioValidarAdministrador.validarAdministrador(request)) {
			modelo.put("localidad", localidad);
			return new ModelAndView("localidades", modelo);
		} else {
			modelo.put("error", "No es administrador");
			return new ModelAndView("principal", modelo);
		}
	}

	@RequestMapping("/partidos")
	public ModelAndView irAPartidos(HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		Partido partido = new Partido();
		// Provincia provincia = // buscar provincias
		if (servicioValidarAdministrador.validarAdministrador(request)) {
			modelo.put("partido", partido);
			return new ModelAndView("partidos", modelo);
		} else {
			modelo.put("error", "No es administrador");
			return new ModelAndView("principal", modelo);
		}
	}

	@RequestMapping("/provincias")
	public ModelAndView irAProvincias(HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		Localidad localidad = new Localidad();
		// Pais pais = // buscar provincias
		if (servicioValidarAdministrador.validarAdministrador(request)) {
			modelo.put("provincia", localidad);
			return new ModelAndView("provincias", modelo);
		} else {
			modelo.put("error", "No es administrador");
			return new ModelAndView("principal", modelo);
		}
	}

	@RequestMapping("/paises")
	public ModelAndView irAPaises(HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		Pais pais = new Pais();
		if (servicioValidarAdministrador.validarAdministrador(request)) {
			modelo.put("paises", servicioDireccion.buscarPaises());
			modelo.put("pais", pais);
			return new ModelAndView("paises", modelo);
		} else {
			modelo.put("error", "No es administrador");
			return new ModelAndView("principal", modelo);
		}
	}

	@RequestMapping(path = "/abm-pais", method = RequestMethod.POST)
	public ModelAndView grabarPais(@ModelAttribute("pais") Pais guardarPais, HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		Pais pais = new Pais();
		if (servicioValidarAdministrador.validarAdministrador(request)) {
			if (servicioDireccion.abmPais(guardarPais, "a")) {
				modelo.put("mensaje", "Pais guardado exitosamente");
				modelo.put("paises", servicioDireccion.buscarPaises());
				modelo.put("pais", pais);
				return new ModelAndView("paises", modelo);
			} else {
				modelo.put("error", "No se pudo guardar los cambios");
				return new ModelAndView("paises", modelo);
			}
		} else {
			modelo.put("error", "No es administrador");
			return new ModelAndView("principal", modelo);
		}
	}

	@RequestMapping("/editar")
	public ModelAndView editarDireccion(@RequestParam("id") Long id, @RequestParam("tabla") String tabla,
			HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		if (servicioValidarAdministrador.validarAdministrador(request)) {
			switch (tabla) {
			case "pais":
				modelo.put("paises", servicioDireccion.buscarPaises());
				modelo.put("pais", servicioDireccion.buscarPais(id));
				return new ModelAndView("modificar-pais", modelo);
			default:
				return new ModelAndView("direcciones");
			}
		} else {
			modelo.put("error", "No es administrador");
			return new ModelAndView("principal", modelo);
		}
	}

	@RequestMapping("/modificar") 
	public ModelAndView modificarDireccion(@RequestParam("id") Long id, @RequestParam("descripcion") String descripcion,
			@RequestParam("tabla") String tabla, HttpServletRequest request,HttpServletResponse response) {
		ModelMap modelo = new ModelMap();
		if (servicioValidarAdministrador.validarAdministrador(request)) {
			switch (tabla) {
			case "pais":
				Pais pais = new Pais();
				System.out.println(id+" - "+descripcion);
				pais.setIdPais(id);
				pais.setDescripcion(descripcion);
				if (servicioDireccion.abmPais(pais, "m")) {
					modelo.put("mensaje", "Modificado exitosamente");
					modelo.put("paises", servicioDireccion.buscarPaises());
					modelo.put("pais", servicioDireccion.buscarPais(id));
					return new ModelAndView("paises", modelo);
				} else {
					modelo.put("error", "No se pudo guardar los cambios");
					return new ModelAndView("paises", modelo);
				}
			default:
				return new ModelAndView("direcciones");
			}
		} else {
			modelo.put("error", "No es administrador");
			return new ModelAndView("principal", modelo);
		}
	}

	@RequestMapping("/eliminar")
	public ModelAndView eliminarDireccion(@RequestParam("id") Long id, @RequestParam("tabla") String tabla,
			HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		Pais pais = new Pais();
		if (servicioValidarAdministrador.validarAdministrador(request)) {
			switch (tabla) {
			case "pais": 
				if (servicioDireccion.abmPais(servicioDireccion.buscarPais(id), "b")) { //VER ERROR
					modelo.put("mensaje", "Pais eliminado exitosamente");
					modelo.put("paises", servicioDireccion.buscarPaises());
					modelo.put("pais", pais);
					return new ModelAndView("paises", modelo);
				} else {
					modelo.put("error", "No se pudo guardar los cambios");
					return new ModelAndView("paises", modelo);
				}
			default:
				return new ModelAndView("direcciones");
			}
		} else {
			modelo.put("error", "No es administrador");
			return new ModelAndView("principal", modelo);
		}
	}

}
