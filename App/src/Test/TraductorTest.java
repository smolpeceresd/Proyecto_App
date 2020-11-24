package Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.junit.jupiter.api.Test;

class TraductorTest {

	public static String seleccionaIdioma() {
		Object[] opciones = {"Español", "Ingles"};
		int a=JOptionPane.showOptionDialog(null,"ESCOGE TU IDIOMA \n CHOOSE YOUR LANGUAGE",
				"Swing", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,
				null, opciones,opciones[0]);
		if(a==0) {
			return "es.txt";
		}else if(a==1) {
			return "us.txt";
		}
		return null;
	}
	@Test
	void test() throws FileNotFoundException {
		String idFichero =seleccionaIdioma();
		File ficheroEntrada = new File (idFichero);

		if (ficheroEntrada.exists()) {

			Scanner datosFichero = new Scanner(ficheroEntrada);
			while (datosFichero.hasNext()) {

				String [] numerosFichero =
						datosFichero.nextLine().split(",");
				for (int i=0; i < numerosFichero.length; i++)
					System.out.print(numerosFichero[i] + "\t");
				System.out.println("");
			}
			datosFichero.close();
		}
		else
			System.out.println("¡El fichero no existe!");
	}
}
