/**
 * 
 */
package hotel;

import java.util.Scanner;
import java.util.Vector;

import habitacion.Habitacion;
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
			boolean niños,String contraseña) {
		this.nombreHotel = nombreHotel;
		this.telefono = telefono;
		this.direccion = direccion;
		this.aparcamiento = aparcamiento;
		this.niños = niños;
		this.contraseñaHotel=contraseña;
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

	@Override
	public String toString() {
		String deVuelta="";
		deVuelta+=("El Hotel "+ this.getNombreHotel() +" cuenta con "+ (this.getNumeroHabitaciones())+" habitaciones");
		deVuelta+=("\n*Numero de estrellas: "+this.estrellas(this.getNumeroEstrellas()));
		deVuelta+=("\n*Telefono: "+this.getTelefono());
		deVuelta+=("\n*Direccion: C\\"+this.getDireccion());

		if(this.isAparcamiento()==true) {
			deVuelta+=("\n*Tiene aparcamiento");
		}
		if(this.isNiños()==true) {
			deVuelta+=("\n*Acepta niños");
		}
		if(this.getPisci()!=null) {
			deVuelta+=("\nPiscina:\n"+ this.getPisci().toString());
		}
		if(this.getRestaurante()!=null) {
			deVuelta+=("\nRestaurante:\n"+this.getRestaurante().toString());
		}
		if(this.getMascotas()!=null) {
			deVuelta+=("\nMascotas:\n"+this.getMascotas().toString());
		}
		deVuelta+="\n\nEstas son las habitaciones que tiene el hotel";

		for(Habitacion elem:this.getRooms()) {

			if(elem.getClass().getSimpleName().equals("Habitacion")==true) {
				deVuelta+="\n\n\n Tipo de habitacion: Estandar\n"+elem.toString();
			}else
				deVuelta+="\n\n\n Tipo de habitacion: "+elem.getClass().getSimpleName()+"\n"+elem.toString();
		}
	return deVuelta;
}

public Habitacion escogeHabitacion() {
	System.out.println("\nLas Habitaciones del hotel:\n");
	for(int i=0;i<this.getRooms().size();i++) {
		System.out.println("\tHabitacion numero "+(i+1)+":\n"+this.getRooms().get(i).toStringUsuario());
	}
	@SuppressWarnings("resource")
	Scanner sc=new Scanner(System.in);
	System.out.print("\n\nDime la nueva habitacion\nEleccion: ");
	int eleccion=sc.nextInt();
	while(eleccion<0 && eleccion>=this.getRooms().size()) {
		System.out.print("Seleccion fuera de rango.Prueba otra vez\nEleccion: ");
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
