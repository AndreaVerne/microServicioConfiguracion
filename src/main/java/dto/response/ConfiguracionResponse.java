package dto.response;

import java.util.List;
import ps.model.Configuracion;
public class ConfiguracionResponse {



	private List<Configuracion> configuraciones;

		public ConfiguracionResponse(List<Configuracion> configuraciones) {
			this.configuraciones = configuraciones;
		}

		 public List<Configuracion>getConfiguracion() {
			return configuraciones;
		}

		public void setConfiguracion(List<Configuracion> configuraciones) {
			this.configuraciones = configuraciones;
		}
	}


