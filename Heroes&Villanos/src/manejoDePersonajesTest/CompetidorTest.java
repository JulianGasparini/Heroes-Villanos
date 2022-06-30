package manejoDePersonajesTest;

import org.junit.*;

import competidores.*;

public class CompetidorTest {

	Personaje heroe;
	Personaje villano;

	@Test
	public void esGanadorTest() {
		heroe = new Personaje(Tipo.Heroe, "Batman", "Batman", 400, 600, 800, 600);
		villano = new Personaje(Tipo.Villano, "Pinguino", "Pinguino", 500, 300, 900, 600);
		Assert.assertFalse(heroe.esGanador(villano, Caracteristica.DESTREZA));
	}

	@Test
	public void esGanadorTestFalse() {
		heroe = new Personaje(Tipo.Heroe, "Batman", "Batman", 400, 600, 800, 600);
		villano = new Personaje(Tipo.Villano, "Pinguino", "Pinguino", 500, 300, 900, 5);

		Assert.assertFalse(heroe.esGanador(villano, Caracteristica.VELOCIDAD));
	}

	@Test
	public void esGanadorTestTrue() {
		heroe = new Personaje(Tipo.Heroe, "Batman", "Batman", 400, 600, 800, 600);
		villano = new Personaje(Tipo.Villano, "Pinguino", "Pinguino", 500, 300, 900, 600);
		Assert.assertTrue(villano.esGanador(heroe, Caracteristica.RESISTENCIA));
	}

	@Test
	public void esGanador2Test() {
		heroe = new Personaje(Tipo.Heroe, "Batman", "Batman", 400, 600, 800, 600);
		villano = new Personaje(Tipo.Villano, "Pinguino", "Pinguino", 500, 300, 900, 600);
		Assert.assertFalse(heroe.esGanador(villano, Caracteristica.DESTREZA));
	}

	@Test
	public void siEmpataronDevuelveFalseTest() {
		heroe = new Personaje(Tipo.Heroe, "Batman", "Batman", 1, 1, 1, 1);
		villano = new Personaje(Tipo.Villano, "Pinguino", "Pinguino", 1, 1, 1, 1);
		Assert.assertFalse(heroe.esGanador(villano, Caracteristica.DESTREZA));
	}

	@Test
	public void siSusCaracteristicasSonIgualesEqualsDevuelveTrueTest() {
		heroe = new Personaje(Tipo.Heroe, "Batman", "Batman", 1, 1, 1, 1);
		villano = new Personaje(Tipo.Villano, "Pinguino", "Pinguino", 1, 1, 1, 1);
		Assert.assertTrue(heroe.equals(villano));
	}

}
