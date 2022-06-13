package manejoDePersonajesTest;

import org.junit.Test;
import org.junit.Assert;
import manejoDePersonajes.*;

public class LigaTest {

	private ArenaDeCombate ar = ArenaDeCombate.getInstancia();

	@Test
	public void buscarPersonaje() {
		Personaje p = new Personaje(Tipo.Heroe, "Batman", "Batman", 1, 1, 1, 1);
		Liga s = new Liga("DC");		

		ar.getCompetidores().add(s);
		ar.getCompetidores().add(p);

		Assert.assertEquals(p, ar.getCompetidor("Batman"));
		Assert.assertEquals(s, ar.getCompetidor("DC"));

	}

}
