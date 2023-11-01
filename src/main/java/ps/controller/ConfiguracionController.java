package ps.controller;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;



import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ps.model.Configuracion;
import ps.repository.ConfiguracionRepository;



@RestController
@RequestMapping("/configuraciones")
public class ConfiguracionController {
	
	@Autowired
	private ConfiguracionRepository configuracionRepository;

	@Value("${variable_env}")
	private String variable_env;

	@GetMapping("/variable_env")
	public String obtener_variable_env() {
		return variable_env;
	}

	@GetMapping("/string")
	public String obtener_string_hardcodeado() {
		return "Un mensaje de texto.";
	}


	    @PostMapping("/")
	    public Configuracion addConfiguracion(@RequestBody Configuracion configuracion) {
	        return configuracionRepository.save(configuracion);
	    }

	    // Endpoint para obtener la configuración más reciente antes de la fecha actual
	    @GetMapping("/")
	    public Configuracion getCurrentConfiguration() {
	        Date currentDate = new Date(); // Obtén la fecha actual
	        return configuracionRepository.findFirstByFechaBeforeOrderByFechaDesc(currentDate);
	    }
}	

