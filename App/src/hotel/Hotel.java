/**
 * 
 */
package hotel;

import java.util.Scanner;
import java.util.Vector;

import habitacion.Habitacion;
import traductor.Traductor;
import usuario.Usuario;
/**
 * @author Smolpeceresd
 *
 */
public class Hotel {
	//Atributos
	private int numeroHabitaciones=0;
	private String nombreHotel;
	private String contraseñaHotel;
	private String telefono;
	private String direccion;
	private boolean aparcamiento;
	private boolean niños;
	private int numeroEstrellas;
	private Piscina pisci=null;
	private Restaurante restaurante=null;
	private Mascotas mascotas= null;
	private Valoraciones valoraciones=new Valoraciones();
	Vector<Habitacion> rooms= new Vector<Habitacion>();
	Vector<Reserva> reservas=new Vector<Reserva>();


	//constructores

	public Hotel(String nombreHotel, String telefono, String direccion, boolean aparcamiento,
			boolean niños,String contraseña,int numEstrellas) {
		this.nombreHotel = nombreHotel;
		this.telefono = telefono;
		this.direccion = direccion;
		this.aparcamiento = aparcamiento;
		this.niños = niños;
		this.contraseñaHotel=contraseña;
		this.numeroEstrellas=numEstrellas;
	}


	//metodos	

	public Piscina getPisci() {
		return pisci;
	}

	public void setPisci(Piscina pisci) {
		this.pisci = pisci;
	}


	///////////////////////////////////////////////////

	public Restaurante getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	///////////////////////////////////////////////////

	public String getNombreHotel() {
		return nombreHotel;
	}

	public void setNombreHotel(String nombreHotel) {
		this.nombreHotel = nombreHotel;
	}

	///////////////////////////////////////////////////

	public int getNumeroHabitaciones() {
		return numeroHabitaciones;
	}
	public void setNumeroHabitaciones(int numeroHabitaciones) {
		this.numeroHabitaciones = numeroHabitaciones;
	}

	///////////////////////////////////////////////////

	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	///////////////////////////////////////////////////

	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	///////////////////////////////////////////////////

	public boolean isAparcamiento() {
		return aparcamiento;
	}
	public void setAparcamiento(boolean aparcamiento) {
		this.aparcamiento = aparcamiento;
	}

	///////////////////////////////////////////////////

	public boolean isNiños() {
		return niños;
	}
	public void setNiños(boolean niños) {
		this.niños = niños;
	}

	///////////////////////////////////////////////////

	public Valoraciones getValoraciones() {
		return valoraciones;
	}

	public void setValoraciones(Valoraciones valoraciones) {
		this.valoraciones = valoraciones;
	}

	///////////////////////////////////////////////////

	public String getContraseñaHotel() {
		return contraseñaHotel;
	}


	public void setContraseñaHotel(String contraseñaHotel) {
		this.contraseñaHotel = contraseñaHotel;

	}
	///////////////////////////////////////////////////

	public Mascotas getMascotas() {
		return mascotas;
	}



	public void setMascotas(Mascotas mascotas) {
		this.mascotas = mascotas;
	}

	///////////////////////////////////////////////////
	public int getNumeroEstrellas() {
		return numeroEstrellas;
	}


	public void setNumeroEstrellas(int numeroEstrellas) {
		this.numeroEstrellas = numeroEstrellas;
	}

	///////////////////////////////////////////////////

	public void añade(Habitacion a) {
		this.getRooms().add(a);
		this.numeroHabitaciones=this.getNumeroHabitaciones()+a.getNumeroTipo();
	}

	public int restantes(Habitacion a) {
		int restoDeHabitaciones=a.getNumeroTipo();
		for(Habitacion elem:this.getRooms()) {
			if(elem.equals(a)==true) {
				restoDeHabitaciones-=1;
			}
		}
		return restoDeHabitaciones;
	}

	///////////////////////////////////////////////////

	public Vector<Habitacion> getRooms() {
		return rooms;
	}

	///////////////////////////////////////////////////

	public Vector<Reserva> getReservas() {
		return reservas;
	}


	public void setReservas(Usuario user, Habitacion antigua,Habitacion nueva) {
		for(int i=0;i<this.getReservas().size();i++) {
			if(this.getReservas().get(i).getUsuario().equals(user)==true) {//si coindice el usuario
				if(this.getReservas().get(i).getHabitacion().equals(antigua)) {// si coincide la antiagua
					this.getReservas().get(i).setHabitacion(nueva);//mete la nueva
					break;// no me interesa cambiar mas
				}
			}
		}
	}

	///////////////////////////////////////////////////

	public String estrellas(int a) {
		String deVuelta="";
		for(int i=0; i<a;i++) {
			deVuelta+="*";
		}
		return deVuelta;
	}

	///////////////////////////////////////////////////


	public void añadeReserva(Reserva a) {
		this.getReservas().add(a);
	}


	public String toString(Traductor diccionario) {
		String deVuelta="";
		deVuelta+=(diccionario.getTexto("DEF_Hot")+ this.getNombreHotel() +diccionario.getTexto("DEF_Hot_2")+ (this.getNumeroHabitaciones())+diccionario.getTexto("rooms"));
		deVuelta+=("\n*"+diccionario.getTexto("ESTRELLAS_Hot")+this.estrellas(this.getNumeroEstrellas()));
		deVuelta+=("\n*"+diccionario.getTexto("TEF_Hot")+this.getTelefono());
		deVuelta+=("\n*"+diccionario.getTexto("DIR_Hot")+this.getDireccion());

		if(this.isAparcamiento()==true) {
			deVuelta+=("\n*"+diccionario.getTexto("APARCAMIENTO"));
		}
		if(this.isNiños()==true) {
			deVuelta+=("\n*"+diccionario.getTexto("NIÑOS"));
		}
		if(this.getPisci()!=null) {
			deVuelta+=("\n\n"+diccionario.getTexto("PISCINA_Hot")+ this.getPisci().toString(diccionario));
		}
		if(this.getRestaurante()!=null) {
			deVuelta+=("\n\n"+diccionario.getTexto("RESTAURANTE_Hot")+this.getRestaurante().toString(diccionario));
		}
		if(this.getMascotas()!=null) {
			deVuelta+=("\n\n"+diccionario.getTexto("MASCOTAS_Hot")+this.getMascotas().toString(diccionario));
		}
		deVuelta+="\n\n";

		for(Habitacion elem:this.getRooms()) {

			if(elem.getClass().getSimpleName().equals("Habitacion")==true) {
				deVuelta+="\n\n\n "+diccionario.getTexto("ESTANDAR_TYPE_")+"\n"+elem.toString(diccionario);
			}else
				deVuelta+="\n\n\n "+diccionario.getTexto("ROOM_TYPE")+elem.getClass().getSimpleName()+"\n"+elem.toString(diccionario);
		}
		return deVuelta;
	}

	public Habitacion escogeHabitacion(Traductor diccionario) {
		System.out.println("\n"+diccionario.getTexto("HOTEL_ROOMS")+"\n");
		for(int i=0;i<this.getRooms().size();i++) {
			System.out.println("\t"+diccionario.getTexto("HOT_NUM_ROOM")+(i+1)+":\n"+this.getRooms().get(i).toStringUsuario(diccionario));
		}
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.print("\n\n"+diccionario.getTexto("NEW_room"));
		int eleccion=sc.nextInt();
		while(eleccion<0 && eleccion>=this.getRooms().size()) {
			System.out.print(diccionario.getTexto("RANGO_OUT")+"\n"+diccionario.getTexto("Eleccion"));
		}
		return this.getRooms().get(eleccion-1);
	}

	public void eliminaReserva(Usuario user,Reserva reserva) {
		for(int i=0;i<this.getReservas().size();i++) {
			if(this.getReservas().get(i).getUsuario().equals(user)==true) {//si coincide el usuario
				if(this.getReservas().get(i).getHabitacion().equals(reserva.getHabitacion())==true) {//y si coincide la habitacion reservada
					this.getReservas().remove(i);//borrala
					break;//sal de aqui
				}
			}
		}
	}

}
