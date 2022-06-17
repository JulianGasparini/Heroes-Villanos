package manejoDePersonajesTest;

import org.junit.*;

import Excepciones.EsEmpateException;
import manejoDePersonajes.*;

public class CompetidorTest {

	Personaje heroe;
	Personaje villano;

	@Test
	public void esGanadorTest() {
		heroe = new Personaje(Tipo.Heroe, "Batman", "Batman", 400, 600, 800, 600);
		villano = new Personaje(Tipo.Villano, "Pinguino", "Pinguino", 500, 300, 900, 600);
		try {
			Assert.assertFalse(heroe.esGanador(villano, Caracteristica.DESTREZA));
		} catch (EsEmpateException e) {
			System.err.println("No empatamos");
		}
	}

	@Test
	public void esGanadorTestFalse() throws EsEmpateException {
		heroe = new Personaje(Tipo.Heroe, "Batman", "Batman", 400, 600, 800, 600);
		villano = new Personaje(Tipo.Villano, "Pinguino", "Pinguino", 500, 300, 900, 5);

		Assert.assertFalse(heroe.esGanador(villano, Caracteristica.VELOCIDAD));
	}

	@Test
	public void esGanadorTestTrue() {
		heroe = new Personaje(Tipo.Heroe, "Batman", "Batman", 400, 600, 800, 600);
		villano = new Personaje(Tipo.Villano, "Pinguino", "Pinguino", 500, 300, 900, 600);
		try {
			Assert.assertTrue(villano.esGanador(heroe, Caracteristica.RESISTENCIA));
		} catch (EsEmpateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void esGanador2Test() {
		heroe = new Personaje(Tipo.Heroe, "Batman", "Batman", 400, 600, 800, 600);
		villano = new Personaje(Tipo.Villano, "Pinguino", "Pinguino", 500, 300, 900, 600);
		try {
			Assert.assertFalse(heroe.esGanador(villano, Caracteristica.DESTREZA));
		} catch (EsEmpateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = EsEmpateException.class)
	public void empataronTest() throws EsEmpateException {
		heroe = new Personaje(Tipo.Heroe, "Batman", "Batman", 1, 1, 1, 1);
		villano = new Personaje(Tipo.Villano, "Pinguino", "Pinguino", 1, 1, 1, 1);
		Assert.assertFalse(heroe.esGanador(villano, Caracteristica.DESTREZA));
	}

}
