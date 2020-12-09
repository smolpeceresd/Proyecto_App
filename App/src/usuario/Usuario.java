package usuario;

import java.security.MessageDigest;
import java.util.Scanner;
import java.util.Vector;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import hotel.Reserva;
import Principal.Extras;
import traductor.Traductor;

/**
 * @author Smolpeceresd
 *
 */
public class Usuario implements Extras {
	private int edad;
	private String tarjeta=null;
	private String correo=null;
	private String telefono=null;
	private String nombre=null;
	private byte[] contraseña=null;
	private String dNI;
	private Vector<Reserva> reservas=new Vector<Reserva>();

	public Usuario(String nombre,int edad, String tarjeta, String correo, String telefono, String contraseña,
			String dNI) {
		super();
		this.edad = edad;
		this.tarjeta = tarjeta;
		this.correo = correo;
		this.telefono = telefono;
		this.nombre = nombre;
		this.contraseña = encripta(contraseña);
		this.dNI = dNI;
	}

	public String toString(Traductor diccionario) {
		return "Usuario: \n"+
				diccionario.getTexto("NOMBRE_")+this.getNombre()+"\n"+
				diccionario.getTexto("EDAD_")+this.getEdad()+"\n"+
				diccionario.getTexto("CORREO_")+this.getCorreo()+"\n"+
				diccionario.getTexto("TELEFONO_US")+this.getTelefono()+"\n"+
				diccionario.getTexto("DNI_US")+this.getDNI()+"\n"+
				diccionario.getTexto("TARJETA_")+this.getTarjeta();
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
	}// el nombre no se podrá cambiar

	///////////////////////////////////////////////////
	public String getContraseña() {
		return descomponer(this.contraseña);
	}
	public void setContraseña(String contraseña) {
		this.contraseña = encripta(contraseña);
	}
	///////////////////////////////////////////////////
	public String getDNI() {
		return dNI;
	}// el DNI no se podrá cambiar

	///////////////////////////////////////////////////
	public String getCorreo() {
		return correo;
	}//el correo no se podrá cambiar. 

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

	public void añadeReserva(Reserva a) {
		this.getReservas().add(a);
	}

	public int eligeReserva(Traductor diccionario) {
		for(int i=0;i<this.getReservas().size();i++) {
			System.out.println("\n"+diccionario.getTexto("N_RESERVA")+(i+1)+"\n"+this.getReservas().get(i).toString());
		}
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		System.out.print("\n"+diccionario.getTexto("Eleccion"));
		int eleccion=sc.nextInt();
		while(eleccion<=0 && eleccion>=this.getReservas().size()) {
			System.out.print("\n"+diccionario.getTexto("RANGO_OUT")+"\n"+diccionario.getTexto("Eleccion"));
		}
		return eleccion-1;
	}
	public String verReservas(Traductor diccionario) {
		if(this.getReservas().size()==0) {
			return "\n"+diccionario.getTexto("EMPTY")+"\n";
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
