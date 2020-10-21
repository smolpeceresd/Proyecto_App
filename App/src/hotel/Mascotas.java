package hotel;
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
	public String toString() {
		if(this.isGuarderia()==false) {
			return "\n\tNuestro hotel permite mascotas , pero no se hace cargo de ellas";
		}else {
			return "\n\tNuestro hotel cuenta con un centro de guarderia donde los perros pueden pasar el dia";
		}
	}
}
