package hotel;

import traductor.Traductor;

/**
 * @author Smolpeceresd
 *
 */
public class Mascotas {

	//Atributos
	private boolean guarderia;

	//Constructor

	public Mascotas(boolean guarderia) {
		this.guarderia=guarderia;
	}

	//Metodos

	///////////////////////////////////////////////////

	public boolean isGuarderia() {
		return guarderia;
	}
	public void setGuarderia(boolean guarderia) {
		this.guarderia = guarderia;
	}
	public String toString(Traductor diccionario) {
		if(this.isGuarderia()==false) {
			return "\n\t"+diccionario.getTexto("GUARDERIA_M");
		}else {
			return "\n\t"+diccionario.getTexto("GUARDERIA_M_N");
		}
	}
}
