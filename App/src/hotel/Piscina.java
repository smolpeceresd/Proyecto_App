package hotel;
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

	public String toString() {
		String deVuelta="";

		deVuelta+=("\n* Dimensiones: "+this.getDimensiones()[0]+" x "+ this.getDimensiones()[1]);

		if(this.isClimatizada()==true) {
			deVuelta+=("\n\t* Climatizada: Sí");
		}else{ deVuelta+=("\n\t* CLimatizada: No");}

		if(this.isServicioToallas()==true) {
			deVuelta+=("\n\t* Servicio de toallas: Sí");
		}else{
			deVuelta+=("\n\t* Servicio de Toallas: No");
		}

		if(this.isBarPiscina()==true) {
			deVuelta+=("\n\t* Bar en la piscina: Sí");
		}else {
			deVuelta+=("\n\t* Bar en la piscina: No");
		}
		return deVuelta;
	}
	
	public String toStringSuit() {
		String deVuelta="";

		deVuelta+=("\n\n* Dimensiones: "+this.getDimensiones()[0]+" x "+ this.getDimensiones()[1]);

		if(this.isClimatizada()==true) {
			deVuelta+=("\n\t* Climatizada: Sí");
		}else{ deVuelta+=("\n\t* Climatizada: No");}
		
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
