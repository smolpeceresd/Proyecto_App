package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dataBase.DataBase;
import hotel.Hotel;
import usuario.Usuario;

class DataBaseTest {

	@Test
	void test() {
		DataBase a= new DataBase();
		a.getVectorHoteles().isEmpty();
		a.getVectorUsuario().isEmpty();
		assertEquals(true, a.getVectorHoteles().isEmpty());
		assertEquals(true, a.getVectorUsuario().isEmpty());
		
		a.añadeHotel(new Hotel("NH", "91","Direccion", true, true, "nh", 4));
		a.añadeUsuario(new Usuario("Santi", 10, "Tarjeta", "Santiago@hotmail.com", "+34", "contra", "DNI"));
		
		assertEquals(false, a.getVectorHoteles().isEmpty());
		assertEquals(false, a.getVectorUsuario().isEmpty());
	}

	//Con comprobar que los vectores estan funcionando , implica que la clase recibe bien los elementos de entrda. 
	//por tanto cualquier fallo implica que sea de las funciones.
	
}
