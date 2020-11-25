# Proyecto_App
En este repositorio vamos a ver una practica la cual trata de generar una aplicación con la cual los hoteles puedan promocionarse y los usuarios hacer reservas en ellos.

**AUTOR** 
Santiago Molpeceres Diaz -> smolpeceresd
<img src="https://user-images.githubusercontent.com/54994511/100009340-10e73480-2dcf-11eb-894d-7e2cd9764cb4.jpg" width="110" height="110">

# Datos básicos 
Este proyecto ha sido creado con las siguientes especificaciones:
* Portatil :AsusZenBook.

![Portatil](https://user-images.githubusercontent.com/54994511/100013006-74c02c00-2dd4-11eb-9c2f-5c82e63fb015.jpg)

* Entorno de desarrollo: Eclipse2020.
<img width="224" alt="Eclipse" src="https://user-images.githubusercontent.com/54994511/100012518-b2708500-2dd3-11eb-8d63-daf2db470c49.png">

* Version jdk: jdk-15.0.1-Windows.
* Version jre: jre.SE-14-Windows.
* Test: JUnit15
<img width="700" alt="JRE" src="https://user-images.githubusercontent.com/54994511/100012351-6ae9f900-2dd3-11eb-9307-047093894455.png">

# APP
Esta app ha sido diseñada para:

	* Las empresas puedan promocionarse en nuestra app.
	* Los usuarios puedan hacer reservas en dichos hoteles.
	
# Estructura
![DEFINITVO](https://user-images.githubusercontent.com/54994511/100010437-8f90a180-2dd0-11eb-8b07-196b93288d76.jpg)
<img width="450" alt="BARRa" src="https://user-images.githubusercontent.com/54994511/100011286-cb783680-2dd1-11eb-920c-d25cbe6bbc6e.png">


* **Paquete Principal** 

	**Main**
El main esta diseñado para que interactue con todas las clases.Toda operacion será ejecutada desde el main.
Esta clase tiene 3 funciones generales que vamos a usar en todo el programa.
	* datoString -> nos devolvera un dato de tipo String que dependerá de su parametro.
	* cantidad -> nos devolvera un dato de tipo int.
	* decisiones-> nos devolvera un booleano.
Estas 3 funciones determinan todos los parametros de los constructores de todas las clases
	
**Extras**

Estras va a ser nuestra interfaz que de momento solo va a sobre cargar el toString de las clases.

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

* **Traductor**
	* El programa incorpora un "pequeño" traductor a nivel de compilador.
	* Para poder utilizarlo es necesario tener los archivos es.txt y us.txt metidos en la carpeta "src"
	* Descripcion
		Su funcionamiento es el de un comipilador , es un diccionario en el que en vez de recoger todas las palabras del lenguaje , coge ffrases predeterminadas que es 		lo que va a salir por pantalla.
		No es que sea muy practico , pero cuanto más avance el proyecto , lo podremos hacer en linea.


# Clases Importadas
* **JOptionPane**
	Esta biblioteca la hemos añadido para la parte inicial de la app , genera una ventana de opciones en la que le hemos puesto las condiciones de idioma 
	esta devuelve el archivo de texto que hemos de leer para que el texto por consola salga en Español o en Ingles
	<img width="999" alt="Jopne" src="https://user-images.githubusercontent.com/54994511/100010881-3c6b1e80-2dd1-11eb-8b3c-28d06ac058c1.png">
* **LOCALDATE**
	Esta biblioteca nos permite generar fechas , controlar tiempos, modificar fechas....
	Para esto hemos añadido bibliotecas de tiempo

		*	**LocalDate -> genera fechas
		*	**MONTH -> controla el tiempo en meses
		*	**DAY -> controla el tiempo en dias
		*	**ChronoUnit -> Biblioteca general de expresiones de tiempo
# AVANCES 
Esta app estaria en la fase 1 o 2  de su desarrollo.

Siempre es importante revisar el codigo con frecuencia , sobre todo para garantizar que los puntos solicitados funcionen correctamente o si se pueden simplificar.
El proceso de desarrrollo de esta app , se basa en una mejora continua en lan que a falta de algunos aspectos como los que vamos a comentar a continuacion, y se busca reducir el codigo lo máximo posible.
La base de esta aplicacion es que se intenta no modificar nada desde las clases , todo se hace desde el main y sobre todo accediendo por posiciones a nuestros datos , lo que evita errores en las tranferencias de datos. 

Para reducir el código y ver si estamos usando correctamente el código, hemos añadido " Sonar Lint " para nuestro entorno de desarrollo(Eclipse)  que proporciona sugerencias de mejora de codigo.

![sonarlint-og-image](https://user-images.githubusercontent.com/54994511/100165165-dad2af00-2eb9-11eb-8250-e4ff5ceff490.png)


Se prevé añadir los siguientes aspectos:

	* Excepción de errores

	* Mejoras de funcionamiento

	* Importante!!-> Las valoraciones aun no estan añadidas en el main.
	
