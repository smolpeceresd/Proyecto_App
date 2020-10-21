package hotel;

import habitacion.Habitacion;
import usuario.Usuario;

public class Reserva {
	private Usuario usuario=null;
	private Hotel hotel=null;
	private Habitacion habitacion=null;


	public Reserva(Usuario usuario, Habitacion habitacion) {// hotel
		this.usuario = usuario;
		this.hotel=null;
		this.habitacion = habitacion;
	}

	public Reserva(Hotel hotel,Habitacion habitacion) {//usuario
		this.usuario=null;
		this.hotel=hotel;
		this.habitacion=habitacion;
	}

	public String toString() {
		String deVuelta="";
		if(this.getUsuario()!=null) {
			deVuelta+="\nUsuario: \n"+this.getUsuario().toString()+"\n";
		}
		if(this.getHotel()!=null) {
			deVuelta+="\nHotel: \n"+this.getHotel().toString()+"\n";
		}
		deVuelta+="\nHabitacion reservada: ";
		if(this.getHabitacion().getClass().getSimpleName().equals("Habitacion")==true) {deVuelta+="Tipo Estandar\n"+this.getHabitacion().toString()+"\n";
		}else {
			deVuelta+="Tipo "+this.getHabitacion().getClass().getSimpleName()+"\n"+this.getHabitacion().toString()+"\n";
		}
		return deVuelta;
	}
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Habitacion getHabitacion() {
		return habitacion;
	}
	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

}
