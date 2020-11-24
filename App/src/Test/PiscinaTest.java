package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hotel.Piscina;

class PiscinaTest {

	@Test
	void test() {
		int [] a={23,23};
		Piscina p=new Piscina(a,true, true, false);
		assertEquals(a, p.getDimensiones());
		assertEquals(true,p.isClimatizada());
		assertEquals(true,p.isServicioToallas());
		assertEquals(false, p.isBarPiscina());
	}

}
