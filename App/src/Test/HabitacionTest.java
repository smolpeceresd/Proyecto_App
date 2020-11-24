package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import habitacion.Habitacion;

class HabitacionTest {

	@Test
	void test() {
		Habitacion a=new Habitacion("Es un hotel", 2, true, true, true, false, true, 345, 45);
		
		assertEquals("Es un hotel", a.getDescripcion());
		assertEquals(2, a.getNumeroCamas());
		assertEquals(true, a.isTv());
		assertEquals(true, a.isWifi());
		assertEquals(true, a.isMinibar());
		assertEquals(false, a.isCajaFuerte());
		assertEquals(true, a.isAdaptadaMinusvalidos());
		assertEquals(345, a.getPrecio());
		assertEquals(45, a.getNumeroTipo());
	}
	/* Con ver que los parametros se asocian a nuestros atributos, es suficiente para saber que la clase funciona, cualquier
	 * error , viene de las funciones
	 */
}
