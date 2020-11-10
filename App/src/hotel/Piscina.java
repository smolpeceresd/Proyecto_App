package hotel;

import traductor.Traductor;

/**
 * @author Smolpeceresd
 *
 */
public class Piscina {
	//Atributos 
	private int dimensiones[] = new int [2];
	private boolean climatizada;
	private boolean servicioToallas;
	private boolean barPiscina;

	//Cosntructor
	public Piscina(int [] dimensiones, boolean climatizada, boolean servicioToallas, boolean barPiscina) {
		this.dimensiones=dimensiones;
		this.climatizada=climatizada;
		this.servicioToallas=servicioToallas;
		this.barPiscina=barPiscina;
	}// este constructor va a ser para la piscina general del hotel
	
	public Piscina(int [] dimensiones , boolean climatizada) {
		this.dimensiones=dimensiones;
		this.climatizada=climatizada;
		this.servicioToallas=false;
		this.barPiscina=false;
	}// este constructor es para las piscinas de la suit

	//Metodos

	public String toString(Traductor diccionario) {
		String deVuelta="";

		deVuelta+=("\n* "+diccionario.getTexto("DIMENSIONES_P_P")+this.getDimensiones()[0]+" x "+ this.getDimensiones()[1]);

		if(this.isClimatizada()==true) {
			deVuelta+=("\n\t* "+diccionario.getTexto("CLIMATIZADA_P_P")+diccionario.getTexto("Afirmacion"));
		}else{ deVuelta+=("\n\t*"+diccionario.getTexto("CLIMATIZADA_P_P")+diccionario.getTexto("Afirmacion"));}

		if(this.isServicioToallas()==true) {
			deVuelta+=("\n\t*"+diccionario.getTexto("TOALLA_P_P")+diccionario.getTexto("Afirmacion"));
		}else{
			deVuelta+=("\n\t*"+diccionario.getTexto("TOALLAS_P_P")+diccionario.getTexto("Negacion"));
		}

		if(this.isBarPiscina()==true) {
			deVuelta+=("\n\t*"+diccionario.getTexto("BAR_P_P")+diccionario.getTexto("Afirmacion"));
		}else {
			deVuelta+=("\n\t*"+diccionario.getTexto("BAR_P_P")+diccionario.getTexto("Negacion"));
		}
		return deVuelta;
	}
	
	public String toStringSuit(Traductor diccionario) {
		String deVuelta="";

		deVuelta+=("\n\n*"+diccionario.getTexto("DIMENSIONES_P_P") +this.getDimensiones()[0]+" x "+ this.getDimensiones()[1]);

		if(this.isClimatizada()==true) {
			deVuelta+=("\n\t* "+diccionario.getTexto("CLIMATIZADA_P_P")+diccionario.getTexto("Afirmacion"));
		}else{ deVuelta+=("\n\t*"+diccionario.getTexto("CLIMATIZADA_P_P")+diccionario.getTexto("Afirmacion"));}

		
		return deVuelta;
	}
	///////////////////////////////////////////////////

	public int[] getDimensiones() {
		return dimensiones;
	}

	public void setDimensiones(int[] dimesiones) {
		this.dimensiones = dimesiones;
	}

	///////////////////////////////////////////////////
	public boolean isClimatizada() {
		return climatizada;
	}

	public void setClimatizada(boolean climatizada) {
		this.climatizada = climatizada;
	}
	///////////////////////////////////////////////////
	public boolean isServicioToallas() {
		return servicioToallas;
	}

	public void setServicioToallas(boolean servicioToallas) {
		this.servicioToallas = servicioToallas;
	}
	///////////////////////////////////////////////////
	public boolean isBarPiscina() {
		return barPiscina;
	}

	public void setBarPiscina(boolean barPiscina) {
		this.barPiscina = barPiscina;
	}

}
