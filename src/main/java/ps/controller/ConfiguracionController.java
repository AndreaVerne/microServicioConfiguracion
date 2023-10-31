package ps.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.requets.ErrorResponse;
import dto.response.ConfiguracionResponse;
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

	// Obtener todos las configuraciones
	@GetMapping
	public ResponseEntity<Object> obtenerTodosLasConfiguraciones() {
		try {
			// TODO: Pasar al service.
			ConfiguracionResponse jr = new ConfiguracionResponse(configuracionRepository.findAll());
			// Algun llamado al service.
			//throw new Exception("Este es un mensaje opcional");
			return ResponseEntity.ok(jr);
			
		} catch (Exception e) {
			// Ojo con esto por que puede enviar un error de BD al front,
			// se deberia controlar con e custom o error generico.
			ErrorResponse er = new ErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
		}
	}

	// Crear un nuevo configuracion
	@PostMapping
	public Configuracion crearJugador(@RequestBody Configuracion configuracion) {
		return configuracionRepository.save(configuracion);
	}

	// Actualizar un Configuracion existente por ID
	@PutMapping("/{id}")
	public Configuracion actualizarConfiguracion(@PathVariable ObjectId id, @RequestBody Configuracion configuracionActualizado) {
		configuracionActualizado.setId(id);
		return configuracionRepository.save(configuracionActualizado);
	}

	// Eliminar un Configuracion por ID
	@DeleteMapping("/{id}")
	public void eliminarConfiguracion(@PathVariable ObjectId id) {
		configuracionRepository.deleteById(id);
	}

	
}
