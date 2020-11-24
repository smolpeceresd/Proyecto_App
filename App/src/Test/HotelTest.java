package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hotel.Hotel;

class HotelTest {

	@Test
	void test() {
		Hotel a= new Hotel("NH","912321232","Colon",true,false,"nh",5);
		assertEquals("NH", a.getNombreHotel());
		assertEquals("912321232", a.getTelefono());
		assertEquals("Colon", a.getDireccion());
		assertEquals(true, a.isAparcamiento());
		assertEquals(false, a.isNiños());
		assertEquals("nh", a.getContraseñaHotel());
		assertEquals(5, a.getNumeroEstrellas());
	}

}
