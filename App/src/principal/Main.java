package principal;

import java.util.Scanner;

import javax.swing.JOptionPane;

import java.time.LocalDate;
import java.time.Month;

import dataBase.DataBase;
import habitacion.Habitacion;
import habitacion.Suit;
import hotel.Hotel;
import hotel.Mascotas;
import hotel.Piscina;
import hotel.Reserva;
import hotel.Restaurante;
import traductor.Traductor;
import usuario.Usuario;
/**
 * @author Smolpeceresd
 *
 */
public class Main  {

	public static String seleccionaIdioma() {
		Object[] opciones = {"Español", "English"};
		int a=JOptionPane.showOptionDialog(null,"ESCOGE TU IDIOMA \n CHOOSE YOUR LANGUAGE",
				"Swing", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,
				null, opciones,opciones[0]);
		
		return (a==0)?"es.txt":(a==1)?"us.txt":null;
		/*if(a==0) {
			return "es.txt";
		}else if(a==1) {
			return "us.txt";
		}
		return null;*/
	}
	public  static int menu(Traductor diccionario) {
		int eleccion;
		Scanner sc= new Scanner(System.in);
		System.out.println(diccionario.getTexto("Bienvenida"));

		System.out.println("\t"+diccionario.getTexto("Pregunta1")+"\n"+ 
							   diccionario.getTexto("Respuesta_menu")+"\n"+
						 	   diccionario.getTexto("Respuesta2_menu")+"\n"+
						 	   diccionario.getTexto("Respuesta3_menu")
				);
		System.out.print("\t"+diccionario.getTexto("Eleccion")); eleccion=sc.nextInt();
		if(eleccion==3) {sc.close();};
		return eleccion;
	}

	public static boolean registrado(Traductor diccionario) {
		return decisiones("\t\t"+diccionario.getTexto("Registrado"),diccionario);
	}

	public static boolean decisiones(String a,Traductor diccionario) {
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);

		int eleccion;
		do {
			System.out.print("\n"+a+"\n\t"+diccionario.getTexto("Afirmacion")+"\n\t"+diccionario.getTexto("Negacion")+"\n"+diccionario.getTexto("Eleccion"));
			eleccion=sc.nextInt();
		}while(eleccion!= 1 && eleccion !=2);
		if(eleccion==1) {
			return true;
		}else {
			return false;
		}
	}
	public static String descripcion(Traductor diccionario) {
		if(decisiones("Descripcion",diccionario)==true) {
			@SuppressWarnings("resource")
			Scanner sc= new Scanner(System.in);
			System.out.print(diccionario.getTexto("Descripccion_"));
			String descripcion=sc.nextLine();
			return descripcion;
		}else {
			return null;
		}
	}

	public static int cantidad(String a,Traductor diccionario)
	{
		int cantidad;
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.print(diccionario.getTexto("Dime")+a+" : ");
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

	public static boolean aparcamiento(Traductor diccionario) {
		return decisiones("¿Tu hotel tiene aparcameinto?",diccionario);
	}
	public static boolean niños(Traductor diccionario) {
		return decisiones("¿Tu hotel Acepta niños?",diccionario);		
	}
	@SuppressWarnings("resource")
	public static int menuHotelEdition(Traductor diccionario) {
		Scanner sc=new Scanner(System.in);
		System.out.print(
				"\n"+diccionario.getTexto("Modificar")+"\n"+
						diccionario.getTexto("M_H_1")+"\n"+
						diccionario.getTexto("M_H_2")+"\n"+
						diccionario.getTexto("M_H_3")+"\n"+
						diccionario.getTexto("M_H_4")+"\n"+
						diccionario.getTexto("M_H_5")+"\n"+
						diccionario.getTexto("M_H_6")+"\n"+
						diccionario.getTexto("M_H_7")+"\n"+
						diccionario.getTexto("M_H_8")+"\n"+
						diccionario.getTexto("M_H_9")+"\n"+
						diccionario.getTexto("M_H_10")+"\n"+
						diccionario.getTexto("M_H_11")+"\n"+
						diccionario.getTexto("M_H_12")+"\n"+
						diccionario.getTexto("M_H_13")+"\n"+
						diccionario.getTexto("M_H_14")+"\n"+
						diccionario.getTexto("Eleccion"));
		int decision=sc.nextInt();
		return decision;

	}

	//PISCINA


	public static Piscina piscina(Traductor diccionario) {
		Piscina pisci=new Piscina(dimensiones(diccionario),climatizada(diccionario),toallas(diccionario),bar(diccionario));
		return pisci;
	}

	public static Piscina pisciSuit(Traductor diccionario) {
		if(decisiones(diccionario.getTexto("PISCINA_p"),diccionario)==true) {
			Piscina pisci=new Piscina(dimensiones(diccionario),climatizada(diccionario));
			return pisci;
		}else {
			return null;
		}
	}
	public static int[] dimensiones(Traductor diccionario) {
		int a []= new int[2];
		int dimen;
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		System.out.print(diccionario.getTexto("DIMEN_1"));
		dimen=sc.nextInt();
		a[0]=dimen;
		System.out.print(diccionario.getTexto("DIMEN_2"));
		dimen=sc.nextInt();
		a[1]=dimen;
		return a;
	}
	public static boolean climatizada(Traductor diccionario) {
		return decisiones(diccionario.getTexto("CLIMATIZADA"),diccionario);
	}
	public static boolean toallas(Traductor diccionario) {
		return decisiones(diccionario.getTexto("TOALLAS"),diccionario);
	}
	public static boolean bar(Traductor diccionario) {
		return decisiones(diccionario.getTexto("BAR"),diccionario);
	}

	public static int menuPiscinaEdition(Traductor diccionario){
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.print(
				"\n"+diccionario.getTexto("Modificar_P")+"\n"+
				diccionario.getTexto("M_P_1")+"\n"+
				diccionario.getTexto("M_P_2")+"\n"+
				diccionario.getTexto("M_P_3")+"\n"+
				diccionario.getTexto("M_P_4")+"\n"+
				diccionario.getTexto("M_P_5")+"\n"+
				diccionario.getTexto("Eleccion"));
		int eleccion=sc.nextInt();
		return eleccion;
	}

	//RESTAURANTE

	public static Restaurante restaurante(Traductor diccionario) {
		Restaurante restaurante= new Restaurante
				(descripcion(diccionario),
						desayuno(diccionario)
						,comida(diccionario),
						cena(diccionario),
						cantidad(diccionario.getTexto("MESAS"),diccionario));

		return restaurante;
	}
/// UNIFICAR 
	public static boolean desayuno(Traductor diccionario) {
		return decisiones(diccionario.getTexto("DESAYUNO"),diccionario);
	}
	public static boolean comida(Traductor diccionario) {
		return decisiones(diccionario.getTexto("COMIDA"),diccionario);
	}
	public static boolean cena(Traductor diccionario) {
		return decisiones(diccionario.getTexto("CENA"),diccionario);
	}

	public static int menuRestauranteEdition(Traductor diccionario) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.print(
				"\n"+diccionario.getTexto("MODIFICAR_R")+"\n"+
				diccionario.getTexto("M_R_1")+"\n"+
				diccionario.getTexto("M_R_2")+"\n"+
				diccionario.getTexto("M_R_3")+"\n"+
				diccionario.getTexto("M_R_4")+"\n"+
				diccionario.getTexto("M_R_5")+"\n"+
				diccionario.getTexto("Eleccion"));
		int eleccion=sc.nextInt();
		return eleccion;
	}

	//Mascotas
	public static Mascotas mascotas(Traductor diccionario) {
		Mascotas mascotas=new Mascotas(decisiones(diccionario.getTexto("GUARDERIA"),diccionario));
		return mascotas;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//HABITACION

	public static double precio(Traductor diccionario) {
		System.out.print(diccionario.getTexto("PRECIO"));
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		double precio=sc.nextDouble();
		return precio;	
	}



	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//USUARIO

	public static String nombre(Traductor diccionario) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.print(diccionario.getTexto("NOMBRE"));
		String nombre=sc.nextLine().toUpperCase();
		return nombre;
	}
	public static int edad(Traductor diccionario) {
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		System.out.print(diccionario.getTexto("EDAD"));
		int edad=sc.nextInt();
		while(edad<18) {
			System.out.println(diccionario.getTexto("F_EDAD"));
			System.out.print(diccionario.getTexto("F_2_EDAD"));
			edad=sc.nextInt();
		}
		return edad;
	}
	public static String dni(Traductor diccionario) {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.print(diccionario.getTexto("DNI"));
		String dni=sc.nextLine().toUpperCase();
		return dni;
	}

	public static int menuUsuario(Traductor diccionario) {
		System.out.println(
				"\n"+diccionario.getTexto("PREGUNTA_U")+"\n"+
				diccionario.getTexto("M_U_1")+"\n"+
				diccionario.getTexto("M_U_2")+"\n"+
				diccionario.getTexto("M_U_3")+"\n"+
				diccionario.getTexto("Eleccion"));
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		int eleccion=sc.nextInt();
		return eleccion;
	}

	/////////////////////////////////////////////////////////////////////////////
	///RESERVAS
	public static LocalDate generaFecha(int a,int añoMinimo,LocalDate inicio,Traductor diccionario) {
		LocalDate fecha=LocalDate.of(añoMinimo, 1, 1);//año,mes,dia
		if(a==1){
			fecha=fecha.withYear(datoFecha((diccionario.getTexto("AÑO_1")+añoMinimo),1,fecha,diccionario) );
			fecha=fecha.withMonth( datoFecha(diccionario.getTexto("MES_1"),2,fecha,diccionario));
			fecha=fecha.withDayOfYear(datoFecha(diccionario.getTexto("DIA_1"),3,fecha,diccionario));
		}else{
			fecha=fecha.withYear(datoFecha((diccionario.getTexto("DIA_2")+añoMinimo),1,inicio,diccionario));
			fecha=fecha.withMonth(datoFecha(diccionario.getTexto("MES_2"),2,inicio,diccionario));
			fecha=fecha.withDayOfYear(datoFecha(diccionario.getTexto("DIA_2"),3,inicio,diccionario));
		}
		return fecha;
	}

	public static int datoFecha(String dato,int b, LocalDate fecha,Traductor diccionario) {
		int deVuelta;
		if(b==1) {// buscamos año
			do {
				deVuelta=cantidad(dato,diccionario);
			}while(deVuelta<fecha.getYear());
		}else if(b==2) {
			if(LocalDate.now().getYear()!=fecha.getYear()) {
				do {
					deVuelta=cantidad(dato,diccionario);
				}while(deVuelta<1 && deVuelta>12);
			}else {
				do {
					deVuelta=cantidad(dato,diccionario);
				}while(deVuelta<LocalDate.now().getDayOfMonth() && deVuelta>12);
			}
		}else {
			if((LocalDate.now().getYear()!=fecha.getYear())==true && (LocalDate.now().getMonth()==fecha.getMonth())==true) {
				do {
					deVuelta=cantidad(dato,diccionario);
				}while(deVuelta <LocalDate.now().getDayOfMonth() && deVuelta > Month.of(fecha.getMonthValue()).length(fecha.isLeapYear()));
			}else {
				do {
					deVuelta=cantidad(dato,diccionario);
				}while(deVuelta <1 && deVuelta > Month.of(fecha.getMonthValue()).length(fecha.isLeapYear()));
			}
			
		}
		return deVuelta;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		Traductor diccionario=new Traductor(seleccionaIdioma());
		DataBase data=new DataBase();
		int eleccion=menu(diccionario);//USUARIO o EMPRESA
		while(eleccion!=3) {
			if(eleccion==1) {
				if(registrado(diccionario)==true) {
					int perfil=data.usuarioRegistrado(datoString(diccionario.getTexto("NOMBRE_US")),datoString(diccionario.getTexto("R_CONTRASEÑA")));
					if(perfil!=-1) {
						int decision=menuUsuario(diccionario);
						while(decision!=3) {
							if(decision==1) {// ver tus reservas
								if(decisiones(diccionario.getTexto("MODIFICAR_RESERVA"),diccionario)==true) {
									if(decisiones(diccionario.getTexto("ELIMINAR"),diccionario)==true) {
										if(data.getVectorUsuario().get(perfil).getReservas().size()>0) {
											int reserva=data.getVectorUsuario().get(perfil).eligeReserva(diccionario);// poss de la reserva a gestionar

											//borramos la reserva en el hotel
											data.buscaHotel(data.getVectorUsuario().get(perfil).getReservas().get(reserva)).eliminaReserva(
													data.getVectorUsuario().get(perfil),
													data.getVectorUsuario().get(perfil).getReservas().get(reserva));

											//borramos la reserva en el usuario
											data.getVectorUsuario().get(perfil).elimina(reserva);

										}else {
											int reserva=data.getVectorUsuario().get(perfil).eligeReserva(diccionario);// poss de la reserva a gestionar
											Habitacion nuevaHabitacion=data.buscaHotel(data.getVectorUsuario().get(perfil).getReservas().get(reserva)).escogeHabitacion(diccionario);
											data.buscaHotel(data.getVectorUsuario().get(perfil).getReservas().get(reserva)).setReservas(
													data.getVectorUsuario().get(perfil), //le paso el usuario
													data.getVectorUsuario().get(perfil).getReservas().get(reserva).getHabitacion(),//le paso la habitacion antigua
													nuevaHabitacion);//le paso la nueva habitacion
											data.getVectorUsuario().get(perfil).getReservas().get(reserva).setHabitacion(nuevaHabitacion);
										}
									}else{
										System.out.println("\n\n"+data.getVectorUsuario().get(perfil).verReservas(diccionario));
									}
								}else{
									System.out.println("\n\n"+data.getVectorUsuario().get(perfil).verReservas(diccionario));
								}
							}else if(decision==2) {
								do {
									int seleccionHotel=data.seleccionHotel(diccionario);
									System.out.println((data.getVectorHoteles().get(seleccionHotel).toString(diccionario)));
									if(decisiones(diccionario.getTexto("RESERVA"),diccionario)==true) {
										int room=data.seleccionaHabitacion(data.getVectorHoteles().get(seleccionHotel),diccionario);
										//a hacer las competentes reservas->
										LocalDate entrada=generaFecha(1,LocalDate.now().getYear(),null,diccionario);
										LocalDate salida= generaFecha(2,LocalDate.now().getYear(),entrada,diccionario);
										data.getVectorHoteles().get(seleccionHotel).añadeReserva(
												new Reserva(
														data.getVectorUsuario().get(perfil),//le paso el perfil
														data.getVectorHoteles().get(seleccionHotel).getRooms().get(room),
														entrada,
														salida)//le paso la habitacion
												);
										data.getVectorUsuario().get(perfil).añadeReserva(
												new Reserva(
														data.getVectorHoteles().get(seleccionHotel),
														data.getVectorHoteles().get(seleccionHotel).getRooms().get(room),
														entrada,
														salida)
												);										
									}
								}while(decisiones(diccionario.getTexto("KEEP_ON"),diccionario)==true);
							}
							decision=menuUsuario(diccionario);
						}
					}else{
						System.out.println("\n\n"+diccionario.getTexto("ERROR_REGISTRO")+"\n\n");
					}
				}else {
					System.out.println("\n"+diccionario.getTexto("LETS_GO"));
					Usuario perfil=new Usuario
							(nombre(diccionario),
									edad(diccionario),
									datoString(diccionario.getTexto("TARJETA")),
									datoString(diccionario.getTexto("CORREO")),
									datoString(diccionario.getTexto("TELEFONO")),
									datoString(diccionario.getTexto("U_CONTRASEÑA")),
									dni(diccionario));
					System.out.println("\n\n\n"+diccionario.getTexto("END_U")+"\n");
					System.out.println(perfil.toString(diccionario));
					data.añadeUsuario(perfil);
					System.out.println("\n\n\n"+diccionario.getTexto("TODO")+"\n\n\n");
				}
			}else if( eleccion==2) {
				if(registrado(diccionario)==true){
					int hotel=data.hotelRegistrado(datoString(diccionario.getTexto("NOMBRE_H_R")),datoString(diccionario.getTexto("R_CONTRASEÑA")));
					if(hotel!=-1) {//si estas registrado
						System.out.println("\n\n"+diccionario.getTexto("MUESTREO_H")+"\n\n"+data.getVectorHoteles().get(hotel).toString(diccionario)+"\n\n");
						int edicionMenu=menuHotelEdition(diccionario);
						while(edicionMenu!=14) {
							switch(edicionMenu) {
							case 1:data.getVectorHoteles().get(hotel).setNumeroHabitaciones(cantidad(diccionario.getTexto("HABITACIONES"),diccionario));break;
							case 2:data.getVectorHoteles().get(hotel).setNombreHotel(datoString(diccionario.getTexto("NOMBRE_H")));break;
							case 3:data.getVectorHoteles().get(hotel).setContraseñaHotel(datoString(diccionario.getTexto("CONTRASEÑA_H")));break;
							case 4:data.getVectorHoteles().get(hotel).setTelefono(datoString(diccionario.getTexto("TELEFONO_H")));break;
							case 5:data.getVectorHoteles().get(hotel).setDireccion(datoString(diccionario.getTexto("DIRECCION_H")));break;
							case 6:data.getVectorHoteles().get(hotel).setAparcamiento(aparcamiento(diccionario));break;
							case 7:data.getVectorHoteles().get(hotel).setNiños(niños(diccionario));break;
							case 8:data.getVectorHoteles().get(hotel).setNumeroEstrellas(cantidad(diccionario.getTexto("ESTRELLAS"),diccionario));break;
							case 9:
							{
								if(data.getVectorHoteles().get(hotel).getPisci()==null) {
									data.getVectorHoteles().get(hotel).setPisci(piscina(diccionario));//la creas
								}else if(decisiones(diccionario.getTexto("ELIMINAR_P"),diccionario)==false){
									int edicionPiscina=menuPiscinaEdition(diccionario);
									while(edicionPiscina!=5) {
										switch(edicionPiscina) {
										case 1:data.getVectorHoteles().get(hotel).getPisci().setDimensiones(dimensiones(diccionario));break;
										case 2:data.getVectorHoteles().get(hotel).getPisci().setClimatizada(climatizada(diccionario));break;
										case 3:data.getVectorHoteles().get(hotel).getPisci().setServicioToallas(toallas(diccionario));break;
										case 4:data.getVectorHoteles().get(hotel).getPisci().setBarPiscina(bar(diccionario));break;
										case 5:System.out.println("\n\n"+diccionario.getTexto("TODO")+"\n");break;
										default:System.out.println("\n\n"+diccionario.getTexto("ERROR")+"\n");
										}
										System.out.println("\n\n"+diccionario.getTexto("MUESTREO_H")+"\n\n"+data.getVectorHoteles().get(hotel).toString(diccionario)+"\n\n");
										edicionPiscina=menuPiscinaEdition(diccionario);
									}
								}else {
									data.getVectorHoteles().get(hotel).setPisci(null);
								}
							}break;

							case 10:
							{
								if(data.getVectorHoteles().get(hotel).getRestaurante()==null) {
									data.getVectorHoteles().get(hotel).setRestaurante(restaurante(diccionario));
								}else if(decisiones(diccionario.getTexto("ELIMINAR_R"),diccionario)==false){
									System.out.println(data.getVectorHoteles().get(hotel).getRestaurante().toString(diccionario));
									int edicionRestaurante=menuRestauranteEdition(diccionario);
									while(edicionRestaurante!=5) {
										switch(edicionRestaurante) {
										case 1:data.getVectorHoteles().get(hotel).getRestaurante().setDescripcion(descripcion(diccionario));break;
										case 2:data.getVectorHoteles().get(hotel).getRestaurante().setDesayuno(desayuno(diccionario));break;
										case 3:data.getVectorHoteles().get(hotel).getRestaurante().setComida(comida(diccionario));break;
										case 4:data.getVectorHoteles().get(hotel).getRestaurante().setCena(cena(diccionario));break;
										case 5:System.out.println("\n\n"+diccionario.getTexto("TODO")+"\n");break;
										default: System.out.println("\n"+diccionario.getTexto("ERROR")+"\n");
										}
										System.out.println(data.getVectorHoteles().get(hotel).getRestaurante().toString(diccionario));
										edicionRestaurante=menuRestauranteEdition(diccionario);
									}
								}else{
									data.getVectorHoteles().get(hotel).setRestaurante(null);
								}
							}break;

							case 11:
							{
								if(data.getVectorHoteles().get(hotel).getMascotas()==null) {
									data.getVectorHoteles().get(hotel).setMascotas(mascotas(diccionario));;
								}else if(decisiones(diccionario.getTexto("ELIMINAR_G"),diccionario)==false){
									data.getVectorHoteles().get(hotel).getMascotas().setGuarderia(decisiones(diccionario.getTexto("GUARDERIA"),diccionario));
								}else {
									data.getVectorHoteles().get(hotel).setMascotas(null);
								}
							}break;
							case 12:System.out.println(data.getVectorHoteles().get(hotel).getValoraciones().toString(diccionario));break ;
							case 13:data.getVectorHoteles().get(hotel).setDescuento(cantidad(diccionario.getTexto("DIME_DESCUENTO"),diccionario));
							case 14:System.out.println("\n\n"+diccionario.getTexto("TODO")+"\n");break;
							default:System.out.println("\n"+diccionario.getTexto("ERROR")+"\n");
							}
							System.out.println("\n\n---------------------------------------------------------------------------\n"
									+ diccionario.getTexto("MUESTREO_H")+"\n\n"+data.getVectorHoteles().get(hotel).toString(diccionario)+""
									+ "\n------------------------------------------------------------------------------\n\n");
							edicionMenu=menuHotelEdition(diccionario);
						}
					}else{
						System.out.println("\n\n"+diccionario.getTexto("ERROR_REGISTRO")+"\n\n");
					}
				}else{
					System.out.println("\n"+diccionario.getTexto("LETS_GO_H")+"\n");
					Hotel hotel=new Hotel
							(datoString(diccionario.getTexto("NOMBRE2_H")),
									datoString(diccionario.getTexto("TELEFONO_H")),
									datoString(diccionario.getTexto("DIRECCION_H")),
									aparcamiento(diccionario),niños(diccionario),// son funciones bool
									datoString(diccionario.getTexto("CONTRASEÑA_H")),
									cantidad(diccionario.getTexto("ESTRELLAS"),diccionario)
									);
					if(decisiones(diccionario.getTexto("PREGUNTA_P"),diccionario)==true) {
						hotel.setPisci(piscina(diccionario));
					}
					if(decisiones(diccionario.getTexto("PREGUNTA_R"),diccionario)==true) {
						hotel.setRestaurante(restaurante(diccionario));
					}
					if(decisiones(diccionario.getTexto("MASCOTAS"),diccionario)==true) {
						hotel.setMascotas(mascotas(diccionario));
					}
					System.out.println("\n"+diccionario.getTexto("HABITACIONES"));
					if(decisiones(diccionario.getTexto("SUIT"),diccionario)==true){
						int a=cantidad(diccionario.getTexto("C_SUIT"),diccionario);
						for(int i=0; i<a;i++) {
							System.out.println(diccionario.getTexto("ITERACION")+(i+1));
							Habitacion habitacion= new Suit
									(descripcion(diccionario),
											cantidad(diccionario.getTexto("CAMAS"),diccionario),
											decisiones(diccionario.getTexto("TV"),diccionario),
											decisiones(diccionario.getTexto("WIFI"),diccionario),
											decisiones(diccionario.getTexto("MINIBAR"),diccionario),
											decisiones(diccionario.getTexto("CAJA_FUERTE"),diccionario),
											decisiones(diccionario.getTexto("MV"),diccionario),
											precio(diccionario),
											decisiones(diccionario.getTexto("JACUZZI"),diccionario),
											decisiones(diccionario.getTexto("BARRA"),diccionario),
											cantidad(diccionario.getTexto("CANTIDAD_HABIT"),diccionario),
											pisciSuit(diccionario));
							hotel.añade(habitacion);
						}
					}
					System.out.println("\n"+diccionario.getTexto("ESTANDAR_H"));
					int b=cantidad(diccionario.getTexto("C_ESTAND"),diccionario);
					for(int i=0;i<b;i++) {
						System.out.println(diccionario.getTexto("ESTAND_ITE")+(i+1));
						Habitacion habitacion=new Habitacion
								(descripcion(diccionario),
										cantidad(diccionario.getTexto("CAMAS"),diccionario),
										decisiones(diccionario.getTexto("TV"),diccionario),
										decisiones(diccionario.getTexto("WIFI"),diccionario),
										decisiones(diccionario.getTexto("MINIBAR"),diccionario),
										decisiones(diccionario.getTexto("CAJA_FUERTE"),diccionario),
										decisiones(diccionario.getTexto("MV"),diccionario),
										precio(diccionario),
										cantidad(diccionario.getTexto("CANTIDAD_HABIT"),diccionario)
										);
						hotel.añade(habitacion);
					}
					data.añadeHotel(hotel);
					System.out.println("\n\n\n\n"+diccionario.getTexto("TODO")+"\n\n");
				}
			}else if(eleccion!=1 && eleccion !=2){
				System.out.println("\n"+diccionario.getTexto("ERROR_VALIDO")+"\n");
			}
			eleccion=menu(diccionario);
		}
		System.out.println("\t\t"+diccionario.getTexto("GRACIAS"));
		System.out.println("\t"+diccionario.getTexto("SEE_YOU"));
	}
}
