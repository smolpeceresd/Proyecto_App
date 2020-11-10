package hotel;


import traductor.Traductor;

/**
 * @author Smolpeceresd
 *
 */
public class Restaurante {
	//Atributos 
	private String descripcion;
	private boolean desayuno;
	private boolean comida;
	private boolean cena;
	private int numeroMesas;

	//Constructor

	public Restaurante(String descripcion, boolean desayuno, boolean comida, boolean cena, int numeroMesas) {
		this.descripcion=descripcion;
		this.desayuno=desayuno;
		this.comida=comida;
		this.cena=cena;
		this.numeroMesas=numeroMesas;		
	}

	//Metodos
	public String toString(Traductor diccionario) {
		String deVuelta="";
		if(this.getDescripcion()!=null) {
			deVuelta+=("\n\t*"+diccionario.getTexto("Descripcion_")+"\n\t"+ this.getDescripcion());
		}
		deVuelta+=("\n\t*"+diccionario.getTexto("N_MESAS")+ this.getNumeroMesas());
		deVuelta+=("\n\t*"+diccionario.getTexto("SERVICIOS_")+"\n");
		if(this.isDesayuno()==true) {
			deVuelta+=("\t\t* "+diccionario.getTexto("DESAYUNO"));
		}
		if(this.isComida()==true) {
			deVuelta+=("\n\t\t* "+diccionario.getTexto("COMIDA"));
		}
		if(this.isCena()==true) {
			deVuelta+=("\n\t\t* "+diccionario.getTexto("CENA"));
		}
		return deVuelta;
	}
	///////////////////////////////////////////////////
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	///////////////////////////////////////////////////
	public boolean isDesayuno() {
		return desayuno;
	}
	public void setDesayuno(boolean desayuno) {
		this.desayuno = desayuno;
	}
	///////////////////////////////////////////////////
	public boolean isComida() {
		return comida;
	}
	public void setComida(boolean comida) {
		this.comida = comida;
	}
	///////////////////////////////////////////////////
	public boolean isCena() {
		return cena;
	}
	public void setCena(boolean cena) {
		this.cena = cena;
	}
	///////////////////////////////////////////////////
	public int getNumeroMesas() {
		return numeroMesas;
	}
	public void setNumeroMesas(int numeroMesas) {
		this.numeroMesas = numeroMesas;
	}

}
