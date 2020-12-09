/**
 * 
 */
package hotel;

import java.security.MessageDigest;
import java.util.Scanner;
import java.util.Vector;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import habitacion.Habitacion;
import Principal.Extras;
import traductor.Traductor;
import usuario.Usuario;
/**
 * @author Smolpeceresd
 *
 */
public class Hotel  implements Extras {
	//Atributos
	private int numeroHabitaciones=0;
	private String nombreHotel;
	private byte[] contraseñaHotel;
	private String telefono;
	private String direccion;
	private boolean aparcamiento;
	private boolean niños;
	private int numeroEstrellas;
	private int descuento=0;
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
		this.contraseñaHotel=encripta(contraseña);
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
		return descomponer(this.contraseñaHotel);
	}


	public void setContraseñaHotel(String contraseñaHotel) {
		this.contraseñaHotel = encripta(contraseñaHotel);

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
			if(elem.equals(a)) {
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
			if(this.getReservas().get(i).getUsuario().equals(user)) {//si coindice el usuario
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

		if(this.isAparcamiento()) {
			deVuelta+=("\n*"+diccionario.getTexto("APARCAMIENTO"));
		}
		if(this.isNiños()) {
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

			if(elem.getClass().getSimpleName().equals("Habitacion")) {
				deVuelta+="\n\n\n "+diccionario.getTexto("ESTANDAR_TYPE_")+"\n"+elem.toString(diccionario);
			}else
				deVuelta+="\n\n\n "+diccionario.getTexto("ROOM_TYPE")+elem.getClass().getSimpleName()+"\n"+elem.toString(diccionario);
		}

		deVuelta+=(this.getDescuento()!=0)?("\n*"+diccionario.getTexto("Descuento")+this.getDescuento()+"%"):("\n*"+diccionario.getComando("No_Descuento"));
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
			if(this.getReservas().get(i).getUsuario().equals(user)) {//si coincide el usuario
				if(this.getReservas().get(i).getHabitacion().equals(reserva.getHabitacion())) {//y si coincide la habitacion reservada
					this.getReservas().remove(i);//borrala
					break;//sal de aqui
				}
			}
		}
	}


	public int getDescuento() {
		return descuento;
	}


	public void setDescuento(int descuento) {
		this.descuento = Math.abs(descuento);
	}
	///////////////////////////////////////////////////////////CIFRADO
	public byte[] encripta(String contraseña) {
		try {
			return cifra(contraseña);
		} catch (Exception e) {
			System.out.println("La constraseña no es valida");
		}
		return null;
	}
	
	public String descomponer(byte[] contraseña) {
		try {
			return descifra(contraseña);
		} catch (Exception e) {
			System.out.println("Algo ha ido mal");
		}
		return null;
	}
	
	public  byte[] cifra(String sinCifrar) throws Exception {
		final byte[] bytes = sinCifrar.getBytes("UTF-8");
		final Cipher aes = obtieneCipher(true);
		final byte[] cifrado = aes.doFinal(bytes);
		return cifrado;
	}

	public  String descifra(byte[] cifrado) throws Exception {
		final Cipher aes = obtieneCipher(false);
		final byte[] bytes = aes.doFinal(cifrado);
		final String sinCifrar = new String(bytes, "UTF-8");
		return sinCifrar;
	}

	private  Cipher obtieneCipher(boolean paraCifrar) throws Exception {
		final String frase = "";
		final MessageDigest digest = MessageDigest.getInstance("SHA");
		digest.update(frase.getBytes("UTF-8"));
		final SecretKeySpec key = new SecretKeySpec(digest.digest(), 0, 16, "AES");

		final Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
		if (paraCifrar) {
			aes.init(Cipher.ENCRYPT_MODE, key);
		} else {
			aes.init(Cipher.DECRYPT_MODE, key);
		}

		return aes;
	}
}
