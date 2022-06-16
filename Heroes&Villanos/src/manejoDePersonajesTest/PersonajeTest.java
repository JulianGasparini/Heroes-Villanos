package manejoDePersonajesTest;

import org.junit.*;

import manejoDePersonajes.*;

public class PersonajeTest {

	Personaje heroe;
	Personaje villano;

	@Before
	public void inicializarPersonajes() {
		heroe = new Personaje(Tipo.Heroe, "Bruce Wayne", "Batman", 400, 600, 800, 600);
		villano = new Personaje(Tipo.Villano, "Oswald Cobblepot", "El pinguino", 500, 300, 900, 600);
	}

	@Test
	public void tipoDeHeroeTest() {
		Assert.assertEquals(Tipo.Heroe, heroe.getTipoDeCompetidor());
	}

	@Test
	public void nombreRealDeHeroeTest() {
		Assert.assertEquals("Bruce Wayne", heroe.getNombreReal());
	}

	@Test
	public void nombrePersonajeDeHeroeTest() {
		Assert.assertEquals("Batman", heroe.getNombre());
	}

	@Test
	public void caracteristicasDeHeroeTest() {
		Assert.assertEquals(400, heroe.obtenerCaracteristica(Caracteristica.VELOCIDAD));
		Assert.assertEquals(600, heroe.obtenerCaracteristica(Caracteristica.FUERZA));
		Assert.assertEquals(800, heroe.obtenerCaracteristica(Caracteristica.RESISTENCIA));
		Assert.assertEquals(600, heroe.obtenerCaracteristica(Caracteristica.DESTREZA));
	}

	@Test
	public void tipoDeVillanoTest() {
		Assert.assertEquals(Tipo.Villano, villano.getTipoDeCompetidor());
	}

	@Test
	public void nombreRealDeVillanoTest() {
		Assert.assertEquals("Oswald Cobblepot", villano.getNombreReal());
	}

	@Test
	public void nombrePersonajeDeVillanoTest() {
		Assert.assertEquals("El pinguino", villano.getNombre());
	}

	@Test
	public void caracteristicasDeVillanoTest() {
		Assert.assertEquals(500, villano.obtenerCaracteristica(Caracteristica.VELOCIDAD));
		Assert.assertEquals(300, villano.obtenerCaracteristica(Caracteristica.FUERZA));
		Assert.assertEquals(900, villano.obtenerCaracteristica(Caracteristica.RESISTENCIA));
		Assert.assertEquals(600, villano.obtenerCaracteristica(Caracteristica.DESTREZA));
	}

}
