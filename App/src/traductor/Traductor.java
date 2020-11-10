package traductor;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
public class Traductor {
	/*
	 * diccionario es una tabla Hash (String, String) que
	 * almacena los componentes léxicos del lenguaje, definidos
	 * por parejas <texto, comando> donde el texto es
	 * la clave de la tabla y la comando léxica el valor
	 */
	private Hashtable<String, String> diccionario;
	
	public Traductor(String ficherodiccionario) {
		this.diccionario = new Hashtable<String, String>();
		leediccionario(this.diccionario,ficherodiccionario);
	}
	
	public String getComando(String lexema) {//recibe un >
		return this.diccionario.get(lexema);
	}
	
	public String getTexto(String comando) {
		String texto = null;
		Set<Map.Entry<String, String>> s =this.diccionario.entrySet();//Colocamelo para mapear 
		
		for(Map.Entry<String, String> m : s)// buscado en cada apartado de la tabla hash
			if (m.getValue().equals(comando)) {//si el valor (Recuerda que es clave,valor , ==valor
				texto = m.getKey();
				break;
			}
		return texto;
	}
	
	
	private static boolean existeFichero(String fichero) {
		File ficheroEntrada = new File (fichero);
		return ficheroEntrada.exists();
	}
	
	private static String comando(String s) {
		return s.substring(0, s.indexOf("\t")).trim();
	}
	
	private static String texto(String s) {
		return s.substring(s.lastIndexOf("\t") + 1);
	}
	
	private static void leediccionario(Hashtable<String, String>diccionario, String ficherodiccionario) {
		if (existeFichero(ficherodiccionario)) {
			try {
				Scanner fichero = new Scanner(new File(ficherodiccionario));
				String componenteLexico, texto, comando;
				while (fichero.hasNext()) {
					componenteLexico = fichero.nextLine();
					if (componenteLexico.length() > 0 &&componenteLexico.charAt(0) != '/') {
						texto = texto(componenteLexico);
						comando = comando(componenteLexico);
						diccionario.put(texto, comando);
					}
				}
				fichero.close();
			} catch (IOException e) {}
		}
	}
}