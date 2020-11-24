package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import usuario.Usuario;

class UsuarioTest {

	@Test
	void test() {
		Usuario a= new Usuario("Santiago", 19,"tarjeta", "smolpeceresd@alumnos.nebrija.es", "687339035", "Santi","DNI");
		assertEquals("Santiago",a.getNombre());
		assertEquals(19,a.getEdad());
		assertEquals("tarjeta",a.getTarjeta());
		assertEquals("smolpeceresd@alumnos.nebrija.es",a.getCorreo());
		assertEquals("687339035",a.getTelefono());
		assertEquals("Santi",a.getContraseña());
		assertEquals("DNI",a.getDNI());
		
	}

}
