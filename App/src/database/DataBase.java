/**
 * 
 */
package database;

import java.util.Scanner;
import java.util.Vector;

import hotel.Hotel;
import hotel.Reserva;
import usuario.Usuario;

/**
 * @author Smolpeceresd
 *
 */
public class DataBase {

	private Vector<Hotel> vectorHoteles=new Vector <Hotel>();
	private Vector<Usuario> vectorUsuario=new Vector <Usuario>();
	public DataBase() {};

	public void añadeHotel(Hotel a) {
		vectorHoteles.add(a);
	}

	public void añadeUsuario(Usuario a) {
		vectorUsuario.add(a);
	}

	public Vector<Hotel> getVectorHoteles() {
		return vectorHoteles;
	}
	public Vector<Usuario> getVectorUsuario() {
		return vectorUsuario;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////
	public int hotelRegistrado(String nombre, String contraseña) {
		for(int i=0;i<this.getVectorHoteles().size();i++) {
			if(this.getVectorHoteles().elementAt(i).getNombreHotel().equals(nombre)==true) {
				if(this.getVectorHoteles().elementAt(i).getContraseñaHotel().equals(contraseña)==true) {
					return i;
				}
			}
		}
		return -1;
	}
	public int usuarioRegistrado(String nombre, String contraseña) {
		for(int i=0;i<this.getVectorUsuario().size();i++) {
			if(this.getVectorUsuario().elementAt(i).getNombre().equals(nombre.toUpperCase())==true) {
				if(this.getVectorUsuario().elementAt(i).getContraseña().equals(contraseña)==true) {
					return i;
				}
			}
		}
		return -1;
	}

	public int seleccionHotel() {
		System.out.println("\n\nEstos son los nombres de los hoteles registrados\nSelecciona el numero para acceder a su informacion");
		for(int i=0; i<this.getVectorHoteles().size();i++) {
			System.out.print((i+1)+") "+this.getVectorHoteles().get(i).getNombreHotel());
		}
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.print("\nEleccion: ");
		int eleccion=sc.nextInt();
		while(eleccion<=0 && eleccion>=this.getVectorHoteles().size()) {
			System.out.print("\nDecision no valida. Prueba otra vez\nEleccion: ");
			eleccion=sc.nextInt();
		}
		return eleccion-1;
	}

	public int seleccionaHabitacion(Hotel hotel) {
		System.out.print("Selecciona la habitacion que quieres reservar");
		for(int i=0;i<hotel.getRooms().size();i++) {
			System.out.println("\nHabitacion "+(i+1)+")\n"+hotel.getRooms().get(i));
		}
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEleccion: ");
		int eleccion=sc.nextInt();
		return eleccion-1;
	}

	public Hotel buscaHotel(Reserva reserva) {
		for(Hotel elem:this.getVectorHoteles()) {
			if(elem.equals(reserva.getHotel())==true) {
				return elem;
			}
		}
		return null;// lo pongo por que ha de devolver algo , pero nunca llegara a devolver null
	}
}
