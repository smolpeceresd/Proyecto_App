package usuario;

import java.util.Scanner;
import java.util.Vector;

import hotel.Reserva;

/**
 * @author Smolpeceresd
 *
 */
public class Usuario {
	private int edad;
	private String tarjeta;
	private String correo;
	private String telefono;
	private String nombre;
	private String contrase�a;
	private String dNI;
	private Vector<Reserva> reservas=new Vector<Reserva>();

	public Usuario(String nombre,int edad, String tarjeta, String correo, String telefono, String contrase�a,
			String dNI) {
		super();
		this.edad = edad;
		this.tarjeta = tarjeta;
		this.correo = correo;
		this.telefono = telefono;
		this.nombre = nombre;
		this.contrase�a = contrase�a;
		this.dNI = dNI;
	}


	public String toString() {
		return "Usuario: \n"+
				"*Nombre: "+this.getNombre()+"\n"+
				"*Edad: "+this.getEdad()+"\n"+
				"*Correo: "+this.getCorreo()+"\n"+
				"*Telefono: "+this.getTelefono()+"\n"+
				"*DNI: "+this.getDNI()+"\n"+
				"*Tarjeta: "+this.getTarjeta();
	}


	public int getEdad() {
		return edad;
	}// la edad no se podra cambiar
	///////////////////////////////////////////////////
	public String getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}
	///////////////////////////////////////////////////
	public String getNombre() {
		return nombre;
	}// el nombre no se podr� cambiar

	///////////////////////////////////////////////////
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	///////////////////////////////////////////////////
	public String getDNI() {
		return dNI;
	}// el DNI no se podr� cambiar

	///////////////////////////////////////////////////
	public String getCorreo() {
		return correo;
	}//el correo no se podr� cambiar. 

	///////////////////////////////////////////////////
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	///////////////////////////////////////////////////

	public Vector<Reserva> getReservas() {
		return reservas;
	}

	public void a�adeReserva(Reserva a) {
		this.getReservas().add(a);
	}

	public int eligeReserva() {
		for(int i=0;i<this.getReservas().size();i++) {
			System.out.println("\nReserva numero: "+(i+1)+"\n"+this.getReservas().get(i).toString());
		}
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		System.out.print("\nEleccion: ");
		int eleccion=sc.nextInt();
		while(eleccion<=0 && eleccion>=this.getReservas().size()) {
			System.out.print("\nLa seleccion esta fuera de rango , intentalo otra vez.\nEleccion: ");
		}
		return eleccion-1;
	}
	public String verReservas() {
		if(this.getReservas().size()==0) {
			return "\nNo has hecho ninguna reserva todavia\n";
		}
		String deVuelta="";
		for(int i=0;i<this.getReservas().size();i++) {
			deVuelta+=this.getReservas().get(i).toString();
		}
		return deVuelta;
	}
	public void elimina(int posicion){
		this.getReservas().remove(posicion);
	}
}
