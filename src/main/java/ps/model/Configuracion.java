package ps.model;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "Configuracion")
public class Configuracion {
	@Id
	private ObjectId id;
	private double precio;
	private double  precio_pausa;
	private double tarifa_extra;
	private Date fecha;
	
	
	

	public Configuracion() {

	}


	public Configuracion (ObjectId id, double precio, double precio_pausa, double tarifa_extra, Date fecha) {
		
		this.id = id;
		this.precio = precio;
		this.precio_pausa = precio_pausa;
		this.tarifa_extra = tarifa_extra;
		this.fecha = fecha;
	}
	


	public ObjectId getId() {
		return id;
	}


	public void setId(ObjectId id) {
		this.id = id;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public double getPrecio_pausa() {
		return precio_pausa;
	}


	public void setPrecio_pausa(double precio_pausa) {
		this.precio_pausa = precio_pausa;
	}


	public double getTarifa_extra() {
		return tarifa_extra;
	}


	public void setTarifa_extra(double tarifa_extra) {
		this.tarifa_extra = tarifa_extra;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	// Método toString para representar la entidad como cadena
	//@Override
	//public String toString() {
		//return "Jugador [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", posicion=" + posicion
			//	+ ", valor=" + valor + "]";
	//}
}
