package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hotel.Mascotas;

class MascotasTest {

	@Test
	void test() {
		Mascotas a= new Mascotas(true);
		Mascotas b = new Mascotas(false);
		assertEquals(true, a.isGuarderia());
		assertEquals(false, b.isGuarderia());
	}

}
