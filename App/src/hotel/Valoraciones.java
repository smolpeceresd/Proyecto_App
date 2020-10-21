package hotel;
/**
 * @author Smolpeceresd
 *
 */
import java.util.ArrayList;

import usuario.Valoracion;

public class Valoraciones {
	private ArrayList<Valoracion> Listado=new ArrayList <Valoracion>();

	public Valoraciones() {}

	public ArrayList<Valoracion> getListado() {
		return Listado;
	}	
	public String toString() {
		if(this.getListado().size()==0) {
			return "De momento nadie ha valorado el hotel";
		}else {
			String deVuelta="";
			for(int i=0;i<Listado.size();i++) {
				deVuelta+="\n"+this.getListado().get(i).toString();
			}
			return deVuelta;
		}
	}
}
