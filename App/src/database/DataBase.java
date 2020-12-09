/**
 * 
 */
package dataBase;

import java.util.Scanner;
import java.util.Vector;
import hotel.Hotel;
import hotel.Reserva;
import traductor.Traductor;
import usuario.Usuario;

/**
 * @author Smolpeceresd
 *
 */
public class DataBase <H,U> {

	private Vector<H> vectorHoteles=new Vector <H>();
	private Vector<U> vectorUsuario=new Vector <U>();
	
	public DataBase() {}

	public void añadeHotel(H a) {
		vectorHoteles.add(a);
	}

	public void añadeUsuario(U a) {
		vectorUsuario.add(a);
	}

	public Vector<H> getVectorHoteles() {
		return vectorHoteles;
	}
	public Vector<U> getVectorUsuario() {
		return vectorUsuario;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////
	public int hotelRegistrado(String nombre, String contraseña) {
		for(int i=0;i<this.getVectorHoteles().size();i++) {
			if(((Hotel) this.getVectorHoteles().elementAt(i)).getNombreHotel().equals(nombre)) {
				if(((Hotel) this.getVectorHoteles().elementAt(i)).getContraseñaHotel().equals(contraseña)) {
					return i;
				}
			}
		}
		return -1;
	}
	public int usuarioRegistrado(String nombre, String contraseña) {
		for(int i=0;i<this.getVectorUsuario().size();i++) {
			if(((Usuario) this.getVectorUsuario().elementAt(i)).getNombre().equals(nombre.toUpperCase())) {
				if(((Usuario) this.getVectorUsuario().elementAt(i)).getContraseña().equals(contraseña)) {
					return i;
				}
			}
		}
		return -1;
	}

	public int seleccionHotel(Traductor diccionario) {
		System.out.println("\n\n"+diccionario.getTexto("LISTA")+"\n"+diccionario.getTexto("SELECT_LISTA"));
		for(int i=0; i<this.getVectorHoteles().size();i++) {
			System.out.print((i+1)+") "+((Hotel) this.getVectorHoteles().get(i)).getNombreHotel());
		}
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.print(diccionario.getTexto("Eleccion"));
		int eleccion=sc.nextInt();
		while(eleccion<=0 && eleccion>=this.getVectorHoteles().size()) {
			System.out.print("\n"+diccionario.getTexto("ERROR_DB"));
			eleccion=sc.nextInt();
		}
		return eleccion-1;
	}

	public int seleccionaHabitacion(Hotel hotel,Traductor diccionario) {
		System.out.print(diccionario.getTexto("SELECT_HAB"));
		for(int i=0;i<hotel.getRooms().size();i++) {
			System.out.println("\n"+diccionario.getTexto("ROOM")+(i+1)+")\n"+hotel.getRooms().get(i));
		}
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("\n"+diccionario.getTexto("Eleccion"));
		int eleccion=sc.nextInt();
		return eleccion-1;
	}

	public H buscaHotel(Reserva reserva) {
		for(H elem:this.getVectorHoteles()) {
			if(elem.equals(reserva.getHotel())) {
				return  elem;
			}
		}
		return null;// lo pongo por que ha de devolver algo , pero nunca llegara a devolver null
	}
}
