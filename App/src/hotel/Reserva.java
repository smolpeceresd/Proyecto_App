package hotel;

import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDate;

import habitacion.Habitacion;
import traductor.Traductor;
import usuario.Usuario;

public class Reserva {
	private Usuario usuario=null;
	private Hotel hotel=null;
	private Habitacion habitacion=null;
	private LocalDate emisionReserva=LocalDate.now();
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;


	public Reserva(Usuario usuario, Habitacion habitacion, LocalDate entrada, LocalDate salida) {// hotel
		this.usuario = usuario;
		this.hotel=null;
		this.habitacion = habitacion;
		this.fechaEntrada=entrada;
		this.fechaSalida=salida;

	}

	public Reserva(Hotel hotel,Habitacion habitacion, LocalDate entrada, LocalDate salida) {//usuario
		this.usuario=null;
		this.hotel=hotel;
		this.habitacion=habitacion;
		this.fechaEntrada=entrada;
		this.fechaSalida=salida;
	}

	public String toString(Traductor diccionario) {
		String deVuelta="";
		if(this.getUsuario()!=null) {
			deVuelta+="\n"+diccionario.getTexto("USUARIO_")+"\n"+this.getUsuario().toString()+"\n";
		}
		if(this.getHotel()!=null) {
			deVuelta+="\n"+diccionario.getTexto("HOTEL_")+"\n"+this.getHotel().toString()+"\n";
		}
		deVuelta+="\n"+diccionario.getTexto("RESERVADA");
		if(this.getHabitacion().getClass().getSimpleName().equals("Habitacion")==true) {deVuelta+=diccionario.getTexto("STANDAR_TYPE")+"\n"+this.getHabitacion().toString()+"\n";
		}else {
			deVuelta+=diccionario.getTexto("TIPO")+this.getHabitacion().getClass().getSimpleName()+"\n"+this.getHabitacion().toString()+"\n";
		}

		deVuelta+="\n\n"+diccionario.getTexto("DATOS_RESERVA")+"\n"
				+ "*\t "+diccionario.getTexto("EMISION")+this.getEmisionReserva().getDayOfMonth()+"/"+emisionReserva.getMonthValue()+"/"+emisionReserva.getYear()
				+"\n*\t "+diccionario.getTexto("ENTRADA")+this.getFechaEntrada().getDayOfMonth()+"/"+this.getFechaEntrada().getMonthValue()+"/"+this.getFechaEntrada().getYear()
				+"\n*\t "+diccionario.getTexto("SALIDA")+this.getFechaSalida().getDayOfMonth()+"/"+this.getFechaSalida().getMonthValue()+"/"+this.getFechaSalida().getYear()
				+"\n*\t "+diccionario.getTexto("PRECIO_RESERV")+ this.getHabitacion().getPrecio()*((double)DAYS.between(this.getFechaEntrada(), this.getFechaSalida()));
				
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

	public LocalDate getEmisionReserva() {
		return emisionReserva;
	}

	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}


}
