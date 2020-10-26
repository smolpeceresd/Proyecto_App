# Proyecto_App
En este repositorio vamos a ver una practica la cual trata de generar una aplicación con la cual los hoteles puedan promocionarse y los usuarios hacer reservas en ellos.

**AUTOR** 
Santiago Molpeceres Diaz -> smolpeceresd
# Datos básicos 
Este proyecto ha sido creado con las siguientes especificaciones:
* Portatil :AsusZenBook.
* Entorno de desarrollo: Eclipse2020.
* Version jdk: jdk.8u251-Windows.
* Version jre: jre.8u251-Windows.

# APP
Esta app ha sido diseñada para:

	* Las empresas puedan promocionarse en nuestra app.
	* Los usuarios puedan hacer reservas en dichos hoteles.
	
# Estructura

* **Paquete Principal** 

	**Main**
El main esta diseñado para que interactue con todas las clases.Toda operacion será ejecutada desde el main.
Esta clase tiene 3 funciones generales que vamos a usar en todo el programa.
	* datoString -> nos devolvera un dato de tipo String que dependerá de su parametro.
	* cantidad -> nos devolvera un dato de tipo int.
	* decisiones-> nos devolvera un booleano.
Estas 3 funciones determinan todos los parametros de los constructores de todas las clases.

* **Paquete hotel**
Este paquete recoge todo lo que contiene el hotel.
	* La clase hotel. 
	* Restaurante .
	* Piscina.
	* Mascotas.
	* Valoraciones-> Vector/Lista de Valoraciones de usuario.
	* Reserva
* **Paquete Habitacion**
Este paquete marca una herencia de objetos.
	* **La clase Habitacion -SuperClase**
	Una plantilla para una habitacion estandar , para que todos los hoteles independientemente de su numero de estrellas puedan registrarse.
	* **La clase Suit** 
	Esta clase marca la herencia desde la clase habitacion. Hereda todos los atributos de Habitacion y añade los propios de la clase suit.
	
* **Paquete DataBase**
	* Clase DataBase.
	La clase DataBase ,sera una base de datos en los que guardaremos todos los hoteles y usuarios que usan nuestra app.
	desde ella podremos buscar , obtener , eliminar y mapear , donde estan los datos de cada usuario.
* **Paquete Usuario**
	* Usuario 
	Recoge los datos del usuario , nombre , tarjeta, dni... Muchos de estos datos no se podran modificar.
	* Valoracion 
	Es la estructura que va a recoger la clase Valoraciones . 

# AVANCES 
Esta app estaria en la fase 0 o 1  de su desarrollo.
Se prevé añadir los siguientes aspectos:

	* Excepción de errores

	* Mejoras de funcionamiento

	* Depuración de codigo

	* Interface

	* Importante!!-> Las valoraciones aun no estan añadidas en el main.
	
