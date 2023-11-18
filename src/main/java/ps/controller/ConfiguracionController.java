package ps.controller;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import ps.model.Configuracion;
import ps.repository.ConfiguracionRepository;
import ps.service.TokenServicio;



@RestController
@RequestMapping("/configuraciones")
public class ConfiguracionController {
	
	@Autowired
	private ConfiguracionRepository configuracionRepository;
	@Autowired
	private TokenServicio token;
	

	@GetMapping("/string")
	public String obtener_string_hardcodeado() {
		return "Un mensaje de texto.";
	}


	// Crear una nueva configuracion
		@PostMapping
		@Operation(summary = "Agregar una tarifa", description = "Se incorpora una configuracion vigente especificado en un JSON siempre y cuando sea administrador el usuario conectado")
		public Configuracion addConfiguracion(@RequestBody Configuracion configuracion, @RequestHeader("Authorization") String authorization) {
			
			// si es administrador puede guardar tarifa
			if (token.autorizado(authorization).contains("ADMIN")) {
	            return configuracionRepository.save(configuracion);
	        }
	        System.out.println("token no autorizado");
	        return null;
			
		}

	    // Endpoint para obtener la configuración más reciente antes de la fecha actual
	    @GetMapping("/")
	    @Operation(summary = "Agregar una tarifa", description = "Se incorpora una configuracion vigente especificado en un JSON siempre y cuando sea administrador el usuario conectado")
	    public Configuracion getCurrentConfiguration (@RequestBody Configuracion configuracion, @RequestHeader("Authorization") String authorization) {
	        Date currentDate = new Date(); // Obtén la fecha actual
	    	if (token.autorizado(authorization).contains("ADMIN")) {
	        return configuracionRepository.findFirstByFechaBeforeOrderByFechaDesc(currentDate);
	    }
	        System.out.println("token no autorizado");
	        return null;
			
}	
}
	    
