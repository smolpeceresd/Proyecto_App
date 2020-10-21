package usuario;
/**
 * @author Smolpeceresd
 *
 */
public class Valoracion {
	
	//atributos
	private String valoracion;
	private int calificacion;
	private int likesDelComentario=0;//Pensar como  subirlo 
	
	
	//constructor 
	public Valoracion(String valoracion, int calificación) {
		this.calificacion=calificación;
		this.valoracion=valoracion;
	}
	
	
	// Metodos
	
	public void setLikesDelComentario() {
		this.likesDelComentario +=1;
	}

	public int getLikesDelComentario() {
		return likesDelComentario;
	}
///////////////////////////////////////////////////
	
	public String getValoracion() {
		return valoracion;
	}
	public void setValoracion(String valoracion) {
		this.valoracion = valoracion;
	}
	public String estrellas(){
		String deVuelta="";
		for(int i=1;i<=this.getCalificacion();i++) {
			deVuelta+="*";
		}
		return deVuelta;
	}
	
///////////////////////////////////////////////////

	public int getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	
	public String toString() {
		String deVuelta="\n*Valoracion: "+this.getValoracion()+"\n*La calificacion del Hotel:"+this.estrellas()+
				"\nLikes: "+this.getLikesDelComentario();
		return deVuelta;
		
	}
}
