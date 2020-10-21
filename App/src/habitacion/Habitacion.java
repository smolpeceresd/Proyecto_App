package habitacion;
/**
 * @author Smolpeceresd
 *
 */
public class Habitacion {
	//Atributos	
	private String descripcion=null;
	private int numeroCamas;
	private boolean tv;
	private boolean wifi;
	private boolean minibar;
	private boolean cajaFuerte;
	private boolean adaptadaMinusvalidos;
	private double precio;
	private int numeroTipo;// este es el numero de habitaciones que tiene de este tipo
	//array de fotos

	//constructor

	public Habitacion(String descripcion, int numeroCamas, boolean tv, boolean wifi, boolean minibar,
			boolean cajaFuerte, boolean adaptadaMinusvalidos, double precio,int numeroTipo) {
		this.descripcion = descripcion;
		this.numeroCamas = numeroCamas;
		this.tv = tv;
		this.wifi = wifi;
		this.minibar = minibar;
		this.cajaFuerte = cajaFuerte;
		this.adaptadaMinusvalidos = adaptadaMinusvalidos;
		this.precio = precio;
		this.numeroTipo=numeroTipo;
	}


	// metodos

	///////////////////////////////////////////////////
	public String toString() {
		String deVuelta="";
		if(this.getDescripcion()!=null) {
			deVuelta+="Descripcion: "+this.getDescripcion();
		}
		deVuelta+="\nEl numero de camas que tiene esta habitacion: "+this.getNumeroCamas();
		deVuelta+="\nEsta habitacion contiene:";
		if(this.isTv()==true) {
			deVuelta+="\n\t*TV";
		}
		if(this.isWifi()==true) {
			deVuelta+="\n\t*Wifi";
		}
		if(this.isMinibar()==true) {
			deVuelta+="\n\t*Mini bar";
		}
		if(this.isCajaFuerte()==true) {
			deVuelta+="\n\t*Caja fuerte";
		}
		if(this.isAdaptadaMinusvalidos()==true) {
			deVuelta+="\n\t*Esta habitacion esta adaptada para minusvalidos";
		}
		deVuelta+="\nPrecio de la habitacion: "+this.getPrecio()+"€";
		deVuelta+="\nEl numero de habitaciones que hay como esta son: "+this.getNumeroTipo();
		return deVuelta;

	}
	public String toStringUsuario() {
		String deVuelta="";
		if(this.getDescripcion()!=null) {
			deVuelta+="Descripcion: "+this.getDescripcion();
		}
		deVuelta+="\nEl numero de camas que tiene esta habitacion: "+this.getNumeroCamas();
		deVuelta+="\nEsta habitacion contiene:";
		if(this.isTv()==true) {
			deVuelta+="\n\t*TV";
		}
		if(this.isWifi()==true) {
			deVuelta+="\n\t*Wifi";
		}
		if(this.isMinibar()==true) {
			deVuelta+="\n\t*Mini bar";
		}
		if(this.isCajaFuerte()==true) {
			deVuelta+="\n\t*Caja fuerte";
		}
		if(this.isAdaptadaMinusvalidos()==true) {
			deVuelta+="\n\t*Esta habitacion esta adaptada para minusvalidos";
		}
		deVuelta+="\nPrecio de la habitacion: "+this.getPrecio()+"€";
		return deVuelta;

	}

	public String getDescripcion() {
		return descripcion;
	}


	public double getPrecio() {
		return precio;
	}

	///////////////////////////////////////////////////

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	///////////////////////////////////////////////////

	public int getNumeroCamas() {
		return numeroCamas;
	}
	public void setNumeroCamas(int numeroCamas) {
		this.numeroCamas = numeroCamas;
	}

	///////////////////////////////////////////////////

	public boolean isTv() {
		return tv;
	}
	public void setTv(boolean tv) {
		this.tv = tv;
	}

	///////////////////////////////////////////////////

	public boolean isWifi() {
		return wifi;
	}
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	///////////////////////////////////////////////////

	public boolean isMinibar() {
		return minibar;
	}
	public void setMinibar(boolean minibar) {
		this.minibar = minibar;
	}

	///////////////////////////////////////////////////

	public boolean isCajaFuerte() {
		return cajaFuerte;
	}
	public void setCajaFuerte(boolean cajaFuerte) {
		this.cajaFuerte = cajaFuerte;
	}

	///////////////////////////////////////////////////

	public boolean isAdaptadaMinusvalidos() {
		return adaptadaMinusvalidos;
	}
	public void setAdaptadaMinusvalidos(boolean adaptadaMinusvalidos) {
		this.adaptadaMinusvalidos = adaptadaMinusvalidos;
	}

	///////////////////////////////////////////////////
	public int getNumeroTipo() {
		return numeroTipo;
	}

	public void setNumeroTipo(int numeroTipo) {
		this.numeroTipo = numeroTipo;
	}

	///////////////////////////////////////////////////

	public void setPrecio(double precio) {
		this.precio = precio;
	}	

}
