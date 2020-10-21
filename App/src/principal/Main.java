package principal;

import java.util.Scanner;

import database.DataBase;
import habitacion.Habitacion;
import habitacion.Suit;
import hotel.Hotel;
import hotel.Mascotas;
import hotel.Piscina;
import hotel.Reserva;
import hotel.Restaurante;
import usuario.Usuario;
/**
 * @author Smolpeceresd
 *
 */
public class Main {

	public  static int menu() {
		int eleccion;
		Scanner sc= new Scanner(System.in);
		System.out.println("\tBienvenido a \"empresa\"");

		System.out.println("\t¿Como vas a usar la app? \n 1 Como usuario \n 2 Como empresa\n 3 Para salir");
		System.out.print("\t\tElección: "); eleccion=sc.nextInt();
		if(eleccion==3) {sc.close();};
		return eleccion;
	}

	public static boolean registrado() {
		return decisiones("\t\t¿Estas registrado?");
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

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//HOTEL

	public static boolean aparcamiento() {
		return decisiones("¿Tu hotel tiene aparcameinto?");
	}
	public static boolean niños() {
		return decisiones("¿Tu hotel Acepta niños?");		
	}
	@SuppressWarnings("resource")
	public static int menuHotelEdition() {
		Scanner sc=new Scanner(System.in);
		System.out.print("\n¿Que desea modificar?\n"
				+ "1 Numero de Habitaciones\n"+
				"2 Nombre del hotel\n"+
				"3 La contraseña del hotel\n"+
				"4 El telefono del hotel\n"+
				"5 La direccion del hotel\n"+
				"6 El aparcamiento\n"+
				"7 Aceptación de niños\n"+
				"8 El numero de estrellas\n"+
				"9 La piscina del hotel\n"+
				"10 El restaurante\n"+
				"11 La aceptación de las mascotas\n"+
				"12 Para ver las valoraciones\n"+
				"13 Para salir\n"+
				"Eleccion: ");
		int decision=sc.nextInt();
		return decision;

	}

	//PISCINA


	public static Piscina piscina() {
		Piscina pisci=new Piscina(dimensiones(),climatizada(),toallas(),bar());
		return pisci;
	}

	public static Piscina pisciSuit() {
		if(decisiones("¿Esta habitacion tiene piscina?")==true) {
			Piscina pisci=new Piscina(dimensiones(),climatizada());
			return pisci;
		}else {
			return null;
		}
	}
	public static int[] dimensiones() {
		int a []= new int[2];
		int dimen;
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		System.out.print("Dime cuanto mide la primera dimension de la piscina: ");
		dimen=sc.nextInt();
		a[0]=dimen;
		System.out.print("Dime cuanto mide la segunda dimension de la piscina: ");
		dimen=sc.nextInt();
		a[1]=dimen;
		return a;
	}
	public static boolean climatizada() {
		return decisiones("¿La pisicina esta climatizada?");
	}
	public static boolean toallas() {
		return decisiones("¿La pisicina tiene servicio de toallas?");
	}
	public static boolean bar() {
		return decisiones("¿La pisicina tiene bar?");
	}

	public static int menuPiscinaEdition(){
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.print("\nQue vamos a modificar de la pisicina?\n"
				+"1 Las dimensiones\n"
				+"2 La climatizacion\n"
				+"3 El servicio de toallas"
				+"4 La barra de Bar"
				+"5 Para salir\n"
				+ "Eleccion: ");
		int eleccion=sc.nextInt();
		return eleccion;
	}

	//RESTAURANTE

	public static Restaurante restaurante() {
		Restaurante restaurante= new Restaurante
				(descripcion(),
						desayuno()
						,comida(),
						cena(),
						cantidad("la cantidad de mesas de tu restaurante"));

		return restaurante;
	}

	public static boolean desayuno() {
		return decisiones("¿El restaurante tiene servicio de desayuno?");
	}
	public static boolean comida() {
		return decisiones("¿El restaurante tiene servicio de comida?");
	}
	public static boolean cena() {
		return decisiones("¿El restaurante tiene servicio de cena?");
	}

	public static int menuRestauranteEdition() {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.print("\nQue vamos a modificar?\n"
				+ "1 La descripción\n"
				+ "2 El servico de desayuno\n"
				+ "3 El servicio de comida\n"
				+ "4 El servicio de Cena\n"
				+ "5 Para salir\n"
				+ "Eleccion: ");
		int eleccion=sc.nextInt();
		return eleccion;
	}

	//Mascotas
	public static Mascotas mascotas() {
		Mascotas mascotas=new Mascotas(decisiones("¿Tu hotel cuenta con guarderia para mascotas?"));
		return mascotas;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//HABITACION

	public static double precio() {
		System.out.print("Dime el precio que tiene esta habitacion: ");
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		double precio=sc.nextDouble();
		return precio;	
	}



	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//USUARIO

	public static String nombre() {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.print("Dime tu nombre, recuerda que este no se podra cambiar: ");
		String nombre=sc.nextLine().toUpperCase();
		return nombre;
	}
	public static int edad() {
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		System.out.print("Dime tu edad , recuerda que no se podrá cambiar, y has de ser +18:");
		int edad=sc.nextInt();
		while(edad<18) {
			System.out.println("Tienes que ser >=18");
			System.out.print("Dime tu edad: ");
			edad=sc.nextInt();
		}
		return edad;
	}
	public static String dni() {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.print("Dime tu DNI: ");
		String dni=sc.nextLine().toUpperCase();
		return dni;
	}

	public static int menuUsuario() {
		System.out.println("\n¿Que quieres hacer?\n"
				+ "1 Para ver tus reservas\n"
				+ "2 Para hacer una nueva reserva\n"
				+ "3 para salir\n"
				+ "Eleccion: ");
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		int eleccion=sc.nextInt();
		return eleccion;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		DataBase data=new DataBase();
		int eleccion=menu();
		while(eleccion!=3) {
			if(eleccion==1) {
				if(registrado()==true) {
					int perfil=data.usuarioRegistrado(datoString("Dime tu nombre de usuario"),datoString("Dime tu contraseña"));
					if(perfil!=-1) {
						int decision=menuUsuario();
						while(decision!=3) {
							if(decision==1) {// ver tus reservas
								if(decisiones("¿Deseas modificar alguna?")==true) {
									if(decisiones("¿Deseas eliminarla?")==true) {
										int reserva=data.getVectorUsuario().get(perfil).eligeReserva();// poss de la reserva a gestionar

										//borramos la reserva en el hotel
										data.buscaHotel(data.getVectorUsuario().get(perfil).getReservas().get(reserva)).eliminaReserva(
												data.getVectorUsuario().get(perfil),
												data.getVectorUsuario().get(perfil).getReservas().get(reserva));

										//borramos la reserva en el usuario
										data.getVectorUsuario().get(perfil).elimina(reserva);

									}else {
										int reserva=data.getVectorUsuario().get(perfil).eligeReserva();// poss de la reserva a gestionar
										Habitacion nuevaHabitacion=data.buscaHotel(data.getVectorUsuario().get(perfil).getReservas().get(reserva)).escogeHabitacion();
										data.buscaHotel(data.getVectorUsuario().get(perfil).getReservas().get(reserva)).setReservas(
												data.getVectorUsuario().get(perfil), //le paso el usuario
												data.getVectorUsuario().get(perfil).getReservas().get(reserva).getHabitacion(),//le paso la habitacion antigua
												nuevaHabitacion);//le paso la nueva habitacion
										data.getVectorUsuario().get(perfil).getReservas().get(reserva).setHabitacion(nuevaHabitacion);
									}
								}else{
									System.out.println("\n\n"+data.getVectorUsuario().get(perfil).verReservas());
								}
							}else if(decision==2) {
								do {
									int seleccionHotel=data.seleccionHotel();
									System.out.println((data.getVectorHoteles().get(seleccionHotel).toString()));
									if(decisiones("¿Deseas hacer una reserva?")==true) {
										int room=data.seleccionaHabitacion(data.getVectorHoteles().get(seleccionHotel));
										//a hacer las competentes reservas->
										data.getVectorHoteles().get(seleccionHotel).añadeReserva(
												new Reserva(
														data.getVectorUsuario().get(perfil),//le paso el perfil
														data.getVectorHoteles().get(seleccionHotel).getRooms().get(room))//le paso la habitacion
												);
										data.getVectorUsuario().get(perfil).añadeReserva(
												new Reserva(
														data.getVectorHoteles().get(seleccionHotel),
														data.getVectorHoteles().get(seleccionHotel).getRooms().get(room))
												);										
									}
								}while(decisiones("¿Desea continuar en este hotel?")==true);
							}
							decision=menuUsuario();
						}
					}else{
						System.out.println("\n\n----Algo ha ido mal\nEl nombre de usuario o la contraseña ha sido mal introducido\n\n");
					}
				}else {
					System.out.println("\nVamos a crear tu perfil");
					Usuario perfil=new Usuario
							(nombre(),
									edad(),
									datoString("Dime la combinacion de tu tarjeta"),
									datoString("Dime tu correo"),
									datoString("Dime tu telefono de contacto"),
									datoString("Te vamos a registrar.\nDinos una contraseña para que puedas acceder a tus datos"),
									dni());
					System.out.println("\n\n\nAsí quedaría tu perfil\n");
					System.out.println(perfil.toString());
					data.añadeUsuario(perfil);
					System.out.println("\n\n\n\n!!!TODO LISTO¡¡¡\n\n");
				}
			}else if( eleccion==2) {
				System.out.println("¿Estas registrado?");
				if(registrado()==true){
					int hotel=data.hotelRegistrado(datoString("Dime el nombre de tu hotel"),datoString("Dime tu contraseña"));
					if(hotel!=-1) {//si estas registrado
						System.out.println("\n\nEste es tu perfil\n\n"+data.getVectorHoteles().get(hotel).toString()+"\n\n");
						int edicionMenu=menuHotelEdition();
						while(edicionMenu!=13) {
							switch(edicionMenu) {
							case 1:data.getVectorHoteles().get(hotel).setNumeroHabitaciones(cantidad("numero de habitaciones"));break;
							case 2:data.getVectorHoteles().get(hotel).setNombreHotel(datoString("Dime el nombre del hotel, este es el que usaras para registrarte:"));break;
							case 3:data.getVectorHoteles().get(hotel).setContraseñaHotel(datoString("Dinos una contraseña para que puedas acceder a tus datos"));break;
							case 4:data.getVectorHoteles().get(hotel).setTelefono(datoString("Dime el numero de telefono de tu hotel"));break;
							case 5:data.getVectorHoteles().get(hotel).setDireccion(datoString("Dime la direccion del hotel"));break;
							case 6:data.getVectorHoteles().get(hotel).setAparcamiento(aparcamiento());break;
							case 7:data.getVectorHoteles().get(hotel).setNiños(niños());break;
							case 8:data.getVectorHoteles().get(hotel).setNumeroEstrellas(cantidad("numero de estrellas de tu hotel"));break;
							case 9:
							{
								if(data.getVectorHoteles().get(hotel).getPisci()==null) {
									data.getVectorHoteles().get(hotel).setPisci(piscina());//la creas
								}else if(decisiones("¿Quieres eliminar tu piscina?")==false){
									int edicionPiscina=menuPiscinaEdition();
									while(edicionPiscina!=5) {
										switch(edicionPiscina) {
										case 1:data.getVectorHoteles().get(hotel).getPisci().setDimensiones(dimensiones());break;
										case 2:data.getVectorHoteles().get(hotel).getPisci().setClimatizada(climatizada());break;
										case 3:data.getVectorHoteles().get(hotel).getPisci().setServicioToallas(toallas());break;
										case 4:data.getVectorHoteles().get(hotel).getPisci().setBarPiscina(bar());break;
										case 5:System.out.println("\n\n!!TODO LISTO¡¡\n");break;
										default:System.out.println("\n\nAlgo ha ido mal.Prueba de nuevo\n");
										}
										System.out.println("\n\nEste es tu perfil\n\n"+data.getVectorHoteles().get(hotel).toString()+"\n\n");
										edicionPiscina=menuPiscinaEdition();
									}
								}else {
									data.getVectorHoteles().get(hotel).setPisci(null);
								}
							}break;

							case 10:
							{
								if(data.getVectorHoteles().get(hotel).getRestaurante()==null) {
									data.getVectorHoteles().get(hotel).setRestaurante(restaurante());
								}else if(decisiones("¿Quieres eliminar tu restaurante?")==false){
									System.out.println(data.getVectorHoteles().get(hotel).getRestaurante().toString());
									int edicionRestaurante=menuRestauranteEdition();
									while(edicionRestaurante!=5) {
										switch(edicionRestaurante) {
										case 1:data.getVectorHoteles().get(hotel).getRestaurante().setDescripcion(descripcion());break;
										case 2:data.getVectorHoteles().get(hotel).getRestaurante().setDesayuno(desayuno());break;
										case 3:data.getVectorHoteles().get(hotel).getRestaurante().setComida(comida());break;
										case 4:data.getVectorHoteles().get(hotel).getRestaurante().setCena(cena());break;
										case 5:System.out.println("\n\n!!!TODO LISTO¡¡¡\n");break;
										default: System.out.println("\nAlgo ha ido mal. prueba otra vez");
										}
										System.out.println(data.getVectorHoteles().get(hotel).getRestaurante().toString());
										edicionRestaurante=menuRestauranteEdition();
									}
								}else{
									data.getVectorHoteles().get(hotel).setRestaurante(null);
								}
							}break;

							case 11:
							{
								if(data.getVectorHoteles().get(hotel).getMascotas()==null) {
									data.getVectorHoteles().get(hotel).setMascotas(mascotas());;
								}else if(decisiones("¿Quieres eliminar tu guarderia?")==false){
									data.getVectorHoteles().get(hotel).getMascotas().setGuarderia(decisiones("¿Tu hotel cuenta con guarderia para mascotas?"));
								}else {
									data.getVectorHoteles().get(hotel).setMascotas(null);
								}
							}break;
							case 12:System.out.println(data.getVectorHoteles().get(hotel).getValoraciones().toString());break ;
							case 13:System.out.println("\n!!!Todo LISTO¡¡¡\n\n");break;
							default:System.out.println("\n\nAlgo aha ido mal.Prueba de nuevo\n");
							}
							System.out.println("\n\n---------------------------------------------------------------------------\n"
									+ "Este es tu perfil\n\n"+data.getVectorHoteles().get(hotel).toString()+""
									+ "\n------------------------------------------------------------------------------\n\n");
							edicionMenu=menuHotelEdition();
						}
					}else{
						System.out.println("\n\n----Algo ha ido mal\nEl nombre de usuario o la contraseña ha sido mal introducido---\n\n");
					}
				}else{
					System.out.println("\nVamos a hacer la plantilla de tu Hotel\n");
					Hotel hotel=new Hotel
							(datoString("Dime el nombre del hotel, este es el que usaras para registrarte"),
									datoString("Dime el numero de telefono de tu hotel"),
									datoString("Dime la direccion del hotel"),
									aparcamiento(),niños(),// son funciones bool
									datoString("Te vamos a registrar.\nDinos una contraseña para que puedas acceder a tus datos")
									);
					if(decisiones("¿Tu hotel tiene piscina?")==true) {
						hotel.setPisci(piscina());
					}
					if(decisiones("¿Tu hotel tiene restaurante?")==true) {
						hotel.setRestaurante(restaurante());
					}
					if(decisiones("¿Tu hotel admite mascotas?")==true) {
						hotel.setMascotas(mascotas());
					}
					System.out.println("\nVamos a registrar las diferentes habitaciones que tienes");
					if(decisiones("¿Tienes Suits en tu hotel?")==true){
						int a=cantidad("Dime cuantas suits diferentes tienes: ");
						for(int i=0; i<a;i++) {
							System.out.println("Vamos con la suit numero "+(i+1));
							Habitacion habitacion= new Suit
									(descripcion(),
											cantidad("el numero de camas"),
											decisiones("¿Tiene TV?"),
											decisiones("¿Tiene wifi?"),
											decisiones("¿Tiene minibar?"),
											decisiones("¿Tiene Caja fuerte?"),
											decisiones("¿Esta adaptada para minusvalidos?"),
											precio(),
											decisiones("¿Tiene Jacuzzi?"),
											decisiones("¿Tiene una barra de bar personal?"),
											cantidad("¿Cuntas habitaciones como esta hay?"),
											pisciSuit());
							hotel.añade(habitacion);
						}
					}
					System.out.println("\nVamos con las habitaciones mas estandar");
					int b=cantidad("¿Cuantas habitaciones diferentes tienes?");
					for(int i=0;i<b;i++) {
						System.out.println("Vamos con la habitacion Estandar numero "+(i+1));
						Habitacion habitacion=new Habitacion
								(descripcion(),
										cantidad("el numero de camas que tiene la habitacion"),
										decisiones("¿Tiene Tv?"),
										decisiones("¿Tiene wifi?"),
										decisiones("¿Tiene minibar?"),
										decisiones("¿Tiene Caja fuerte?"),
										decisiones("¿Esta adaptada para minusvalidos?"),
										precio(),
										cantidad("¿Cuantas habitaciones como esta hay?")
										);
						hotel.añade(habitacion);
					}
					data.añadeHotel(hotel);
					System.out.println("\n\n\n\n!!!TODO LISTO¡¡¡\n\n");
				}
			}else if(eleccion!=1 && eleccion !=2){
				System.out.println("\nPor favor introduce un dato valido\n");
			}
			eleccion=menu();
		}
		System.out.println("\t\tGRACIAS POR TU VISITA");
		System.out.println("\tESPERAMOS VOLVER A VERTE PRONTO");
	}
}
