package ps.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ps.model.Configuracion;

@Service
public class ApiService {
	// Reemplaza con la URL de tu API
	
	@Value("${base_url}")
	private String base_url;

	@Autowired
	private RestTemplate rest_template;

	public ResponseEntity<String> get() {
		return this.rest_template.getForEntity(this.base_url, String.class);
	}

	public ResponseEntity<Configuracion> post(Configuracion configuracion) {
		return this.rest_template.postForEntity(this.base_url, configuracion, Configuracion.class);
	}

	public void delete(Long id) {
		this.rest_template.delete(this.base_url + "/" + id);
	}

}