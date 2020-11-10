package traductor;

import javax.swing.JOptionPane;

public class TestComponentes {
	
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
	public static void main(String[] args) {
		Traductor componentesLexicos=new Traductor(seleccionaIdioma());
		
		System.out.println(">  \t"+componentesLexicos.getComando("Dime tu contraseña"));
		
		System.out.print(componentesLexicos.getTexto("Bienvenida"));
	}

}
