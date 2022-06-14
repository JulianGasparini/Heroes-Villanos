package manejoDePersonajesTest;

import org.junit.*;

import manejoDePersonajes.*;

public class CompetidorTest {
	
	Personaje heroe;
	Personaje villano;
	
	@Test
	public void esGanadorTest() {
		heroe = new Personaje(Tipo.Heroe, "Batman", "Batman", 400, 600, 800, 600);
		villano = new Personaje(Tipo.Villano, "Pinguino", "Pinguino", 500, 300, 900, 600);
		Assert.assertTrue(heroe.esGanador(villano, Caracteristica.DESTREZA));
	}

}
