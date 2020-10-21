package hotel;

import java.util.Scanner;

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
	public String toString() {
		String deVuelta="";
		if(this.getDescripcion()!=null) {
			deVuelta+=("\n\t*Descripción:\n\t"+ this.getDescripcion());
		}
		deVuelta+=("\n\t*Numero de Mesas: "+ this.getNumeroMesas());
		deVuelta+=("\n\t*Servicios:\n");
		if(this.isDesayuno()==true) {
			deVuelta+=("\t\t* Desayuno");
		}
		if(this.isComida()==true) {
			deVuelta+=("\n\t\t* Comida");
		}
		if(this.isCena()==true) {
			deVuelta+=("\n\t\t* Cena");
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

	////////////////////////////////////////////////////////////////////Metodos Estandar
	
	
	public static int menuEdicion() {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.print("\n¿Que vamos a cambiar?\n"
				+ "1 La descripcion\n"+
				"2 Servicio de desayuno\n"+
				"3 Servico de comida\n"+
				"4 Servicio de cena\n"+
				"5 Numero de mesas\n"+
				"6 Para salir"+
				"Eleccion: ");
		int decision=sc.nextInt();
		return decision;

	}
	public static String descripcion() {
		if(decisiones("¿Quieres añadir una descripción?")==true) {
			@SuppressWarnings("resource")
			Scanner sc= new Scanner(System.in);
			System.out.print("Descripción:");
			String descripcion=sc.nextLine();
			return descripcion;
		}else {
			return null;
		}
	}
	public static boolean decisiones(String a) {
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);

		int eleccion;
		do {
			System.out.print("\n"+a+"\n\t 1 Si \n\t 2 No\n Eleccion:  ");
			eleccion=sc.nextInt();
		}while(eleccion!= 1 && eleccion !=2);
		if(eleccion==1) {
			return true;
		}else {
			return false;
		}
	}
	public static int cantidad(String a)
	{
		int cantidad;
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.print("Dime "+a+" : ");
		cantidad=sc.nextInt();
		return cantidad;
	}
	public static String datoString(String a)
	{
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.print(a+" : ");
		String dato=sc.nextLine();
		return dato;
	}
}
