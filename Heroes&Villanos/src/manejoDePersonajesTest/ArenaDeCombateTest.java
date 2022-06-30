package manejoDePersonajesTest;

import org.junit.Test;

import Excepciones.CompetidorRepetidoException;
import ManipuladorCompetidores.ArenaDeCombate;

import org.junit.Assert;
import manejoDePersonajes.*;

public class ArenaDeCombateTest {

	private ArenaDeCombate ar = ArenaDeCombate.getInstancia();

	@Test
	public void buscarPersonaje() {
		Personaje p = new Personaje(Tipo.Heroe, "Batman", "Batman", 1, 1, 1, 1);
		Liga s = new Liga("DC");

		ar.getCompetidores().add(s);
		ar.getCompetidores().add(p);

		Assert.assertEquals(p, ar.getCompetidor("Batman"));
		Assert.assertEquals(s, ar.getCompetidor("DC"));
		ar.vaciarListaCompetidores();
	}

	@Test
	public void cantidadDeCompetidores() {
		Personaje p1 = new Personaje(Tipo.Heroe, "Batman", "Batman", 1, 1, 1, 1);
		Personaje p2 = new Personaje(Tipo.Heroe, "Robin", "Robin", 1, 1, 1, 1);
		Liga s = new Liga("DC");
		ar.getCompetidores().add(s);
		ar.getCompetidores().add(p1);
		ar.getCompetidores().add(p2);

		Assert.assertEquals(3, ar.cantCompetidores());
		ar.vaciarListaCompetidores();
	}

	@Test
	public void agregoCompetidor() throws CompetidorRepetidoException {
		Personaje p1 = new Personaje(Tipo.Heroe, "Batman", "Batman", 1, 1, 1, 1);
		Personaje p2 = new Personaje(Tipo.Heroe, "Robin", "Robin", 1, 1, 1, 1);
		Liga s = new Liga("DC");
		ar.getCompetidores().add(s);
		ar.getCompetidores().add(p1);

		Assert.assertTrue(ar.agregarCompetidor(p2));
		ar.vaciarListaCompetidores();
	}

}
