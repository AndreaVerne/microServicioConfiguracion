package dto.response;

import java.util.List;

import ps.model.Configuracion;

public class ConfiguracionResponse {

	private List<Configuracion> configuracion;

	public ConfiguracionResponse(List<Configuracion> configuracion) {
		this.configuracion = configuracion;
	}

	public List<Configuracion> getConfiguracion() {
		return configuracion;
	}

	public void setConfiguracion(List<Configuracion> configuracion) {
		this.configuracion = configuracion;
	}
}
