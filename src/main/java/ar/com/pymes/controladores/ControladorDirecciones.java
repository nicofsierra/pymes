package ar.com.pymes.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.com.pymes.modelo.CalleLocalidad;
import ar.com.pymes.modelo.Localidad;
import ar.com.pymes.modelo.Pais;
import ar.com.pymes.modelo.Partido;
import ar.com.pymes.modelo.Provincia;
import ar.com.pymes.servicios.ServicioDireccion;
import ar.com.pymes.servicios.ServicioErrores;
import ar.com.pymes.servicios.ServicioValidarAdministrador;

@Controller
public class ControladorDirecciones {

	@Inject
	private ServicioDireccion servicioDireccion;

	@Inject
	private ServicioValidarAdministrador servicioValidarAdministrador;
	
	@Inject 
	private ServicioErrores servicioErrores;

	// VER PORQUE SALE DEL USUARIO

	@RequestMapping("/direcciones")
	public ModelAndView irADirecciones(HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		if (servicioValidarAdministrador.validarAdministrador(request)) {
			return new ModelAndView("direcciones", modelo);
		} else {
			modelo.put("error", servicioErrores.traerError(1L));
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
			modelo.put("error", servicioErrores.traerError(1L));
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
			modelo.put("error", servicioErrores.traerError(1L));
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
			modelo.put("error", servicioErrores.traerError(1L));
			return new ModelAndView("principal", modelo);
		}
	}

	@RequestMapping("/provincias")
	public ModelAndView irAProvincias(HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		Provincia provincia = new Provincia();
		if (servicioValidarAdministrador.validarAdministrador(request)) {
			modelo.put("paises", servicioDireccion.buscarPaises());
			modelo.put("provincias", servicioDireccion.buscarProvincias());
			modelo.put("provincia", provincia);
			return new ModelAndView("provincias", modelo);
		} else {
			modelo.put("error", servicioErrores.traerError(1L));
			return new ModelAndView("principal", modelo);
		}
	}

	@RequestMapping("/paises")
	public ModelAndView irAPaises(HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		if (servicioValidarAdministrador.validarAdministrador(request)) {
			modelo.put("paises", servicioDireccion.buscarPaises());
			return new ModelAndView("paises", modelo);
		} else {
			modelo.put("error", servicioErrores.traerError(1L));
			return new ModelAndView("principal", modelo);
		}
	}

	@RequestMapping("alta")
	public ModelAndView altaDirecciones(@RequestParam("tabla") String tabla,
			@RequestParam("descripcion") String descripcion, HttpServletRequest request) {
		ModelMap modelo = new ModelMap();

		if (servicioValidarAdministrador.validarAdministrador(request)) {
			switch (tabla) {
			case "pais":
				if (descripcion.isEmpty()) {
					modelo.put("error", servicioErrores.traerError(2L));
					modelo.put("paises", servicioDireccion.buscarPaises());
					return new ModelAndView("paises", modelo);
				} else {
					Pais pais = new Pais();
					pais.setDescripcion(descripcion);
					if (servicioDireccion.abm(pais, "a")) {
						modelo.put("paises", servicioDireccion.buscarPaises());
						modelo.put("mensaje", "Dato guardado exitosamente");
						return new ModelAndView("paises", modelo);
					} else {
						modelo.put("error", servicioErrores.traerError(3L));
						return new ModelAndView("paises", modelo);
					}

				}
			default:
				modelo.put("error", servicioErrores.traerError(4L));
				return new ModelAndView();
			}
		} else {
			modelo.put("error", servicioErrores.traerError(1L));
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
			modelo.put("error", servicioErrores.traerError(1L));
			return new ModelAndView("principal", modelo);
		}
	}

	@RequestMapping("/modificar")
	public ModelAndView modificarDireccion(@RequestParam("id") Long id, @RequestParam("descripcion") String descripcion,
			@RequestParam("tabla") String tabla, HttpServletRequest request, HttpServletResponse response) {
		ModelMap modelo = new ModelMap();
		if (servicioValidarAdministrador.validarAdministrador(request)) {
			switch (tabla) {
			case "pais":
				Pais pais = new Pais();
				pais.setIdPais(id);
				pais.setDescripcion(descripcion);
				if (servicioDireccion.abm(pais, "m")) {
					modelo.put("mensaje", "Modificado exitosamente");
					modelo.put("paises", servicioDireccion.buscarPaises());
					modelo.put("pais", servicioDireccion.buscarPais(id));
					return new ModelAndView("paises", modelo);
				} else {
					modelo.put("error", servicioErrores.traerError(3L));
					return new ModelAndView("paises", modelo);
				}
			default:
				return new ModelAndView("direcciones");
			}
		} else {
			modelo.put("error", servicioErrores.traerError(1L));
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
				if (servicioDireccion.abm(servicioDireccion.buscarPais(id), "b")) {
					modelo.put("mensaje", "Pais eliminado exitosamente");
					modelo.put("paises", servicioDireccion.buscarPaises());
					modelo.put("pais", pais);
					return new ModelAndView("paises", modelo);
				} else {
					modelo.put("error", servicioErrores.traerError(3L));
					return new ModelAndView("paises", modelo);
				}
			default:
				return new ModelAndView("direcciones");
			}
		} else {
			modelo.put("error", servicioErrores.traerError(1L));
			return new ModelAndView("principal", modelo);
		}
	}

}
