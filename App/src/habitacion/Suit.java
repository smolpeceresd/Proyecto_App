package habitacion;

import hotel.Piscina;
import traductor.Traductor;
/**
 * @author Smolpeceresd
 *
 */
public class Suit extends Habitacion{
	//Atributos
	private Piscina pisci=null;
	private boolean jacuzzi;
	private boolean barraBar;



	//constructor 
	public Suit(
			String descripcion, int numeroCamas, boolean tv, boolean wifi, boolean minibar, boolean cajaFuerte,
			boolean adaptadaMinusvalidos, double precio, boolean jacuzzi, boolean barraBar, int numeroTipo
			,Piscina pisci) {
		super(descripcion, numeroCamas, tv, wifi, minibar, cajaFuerte, adaptadaMinusvalidos, precio,numeroTipo);
		this.jacuzzi = jacuzzi;
		this.barraBar = barraBar;
		this.pisci=pisci;
	}

	//metodos

	public String toString(Traductor diccionario){
		String deVuelta=super.toString();
		deVuelta+="\n"+diccionario.getTexto("ENCABEZADO_SUIT")+"\n";
		if(this.getPisci()!=null) {
			deVuelta+="\n\t*"+diccionario.getTexto("PISCINA_H_H")+this.getPisci().toStringSuit(diccionario);
		}
		if(this.isJacuzzi()==true) {
			deVuelta+="\n\t*"+diccionario.getTexto("JACUZZI_H_H");
		}
		if(this.isBarraBar()==true) {
			deVuelta+="\n\t*"+diccionario.getTexto("BARRA_H_H");
		}
		return deVuelta;
	}
	///////////////////////////////////////////////////

	public Piscina getPisci() {
		return pisci;
	}

	public void setPisci(Piscina pisci) {
		this.pisci = pisci;
	}

	///////////////////////////////////////////////////

	public boolean isJacuzzi() {
		return jacuzzi;
	}

	public void setJacuzzi(boolean jacuzzi) {
		this.jacuzzi = jacuzzi;
	}

	///////////////////////////////////////////////////

	public boolean isBarraBar() {
		return barraBar;
	}

	public void setBarraBar(boolean barraBar) {
		this.barraBar = barraBar;
	}

	///////////////////////////////////////////////////


}
