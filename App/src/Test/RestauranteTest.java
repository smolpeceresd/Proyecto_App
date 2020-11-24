package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hotel.Restaurante;

class RestauranteTest {

	@Test
	void test() {
		Restaurante a= new Restaurante(null,true,true ,false,4);
		assertEquals(null, a.getDescripcion());
		assertEquals(true, a.isDesayuno());
		assertEquals(true, a.isComida());
		assertEquals(false, a.isCena());
		assertEquals(4, a.getNumeroMesas());
	}

}
