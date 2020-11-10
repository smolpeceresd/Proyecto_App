package hotel;
/**
 * @author Smolpeceresd
 *
 */
import java.util.ArrayList;

import traductor.Traductor;
import usuario.Valoracion;

public class Valoraciones {
	private ArrayList<Valoracion> Listado=new ArrayList <Valoracion>();

	public Valoraciones() {}

	public ArrayList<Valoracion> getListado() {
		return Listado;
	}	
	public String toString(Traductor diccionario) {
		if(this.getListado().size()==0) {
			return diccionario.getTexto("TIME");
		}else {
			String deVuelta="";
			for(int i=0;i<Listado.size();i++) {
				deVuelta+="\n"+this.getListado().get(i).toString();
			}
			return deVuelta;
		}
	}
}
