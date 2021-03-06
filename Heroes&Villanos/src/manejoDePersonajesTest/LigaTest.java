package manejoDePersonajesTest;

import org.junit.*;

import competidores.*;

public class LigaTest {
	Personaje heroe1, heroe2, villano1, villano2;
	Liga heroes1, heroes2, villanos1, villanos2;

	@Before
	public void inicializarLigas() {
		heroe1 = new Personaje(Tipo.Heroe, "Peter Parker", "Spiderman", 300, 250, 1000, 230);
		heroe2 = new Personaje(Tipo.Heroe, "Bruce Banner", "Hulk", 600, 300, 100, 560);
		heroes1 = new Liga("Liga de heroes 1");
		heroes1.setTipoDeCompetidor(Tipo.Heroe);
		heroes2 = new Liga("Liga de heroes 2");
		heroes2.setTipoDeCompetidor(Tipo.Heroe);
		heroes1.agregarCompetidor(heroe1);
		heroes2.agregarCompetidor(heroe2);
		heroes1.agregarCompetidor(heroes2);

		villano1 = new Personaje(Tipo.Villano, "Wilson Fisk", "Kingpin", 200, 500, 800, 550);
		villano2 = new Personaje(Tipo.Villano, "Norman Osborn", "Duende Verde", 300, 700, 450, 150);
		villanos1 = new Liga("Liga de villanos 1");
		villanos1.setTipoDeCompetidor(Tipo.Villano);
		villanos2 = new Liga("Liga de villanos 2");
		villanos2.setTipoDeCompetidor(Tipo.Villano);
		villanos1.agregarCompetidor(villano1);
		villanos2.agregarCompetidor(villano2);
		villanos1.agregarCompetidor(villanos2);
	}

	@Test
	public void agregarPersonaje() {
		Personaje nuevoHeroe = new Personaje(Tipo.Villano, "Bruce Banner", "Evil-Hulk", 600, 300, 100, 560);
		Assert.assertTrue(villanos1.agregarCompetidor(nuevoHeroe));
	}

	@Test
	public void nombreDeLigaHeroesTest() {
		Assert.assertEquals("Liga de heroes 1", heroes1.getNombre());
		Assert.assertEquals("Liga de heroes 2", heroes2.getNombre());
	}

	@Test
	public void nombreDeLigaVillanosTest() {
		Assert.assertEquals("Liga de villanos 1", villanos1.getNombre());
		Assert.assertEquals("Liga de villanos 2", villanos2.getNombre());
	}

	@Test
	public void tipoDeLigaHeroesTest() {
		Assert.assertEquals(Tipo.Heroe, heroes1.getTipoDeCompetidor());
		Assert.assertEquals(Tipo.Heroe, heroes2.getTipoDeCompetidor());
	}

	@Test
	public void tipoDeLigaVillanosTest() {
		Assert.assertEquals(Tipo.Villano, villanos1.getTipoDeCompetidor());
		Assert.assertEquals(Tipo.Villano, villanos2.getTipoDeCompetidor());
	}

	@Test
	public void caracteristicasDeLigaHeroesTest() {
		Assert.assertEquals(900, heroes1.getCaracteristicaPorEnum(Caracteristica.VELOCIDAD));
		Assert.assertEquals(550, heroes1.getCaracteristicaPorEnum(Caracteristica.FUERZA));
		Assert.assertEquals(1100, heroes1.getCaracteristicaPorEnum(Caracteristica.RESISTENCIA));
		Assert.assertEquals(790, heroes1.getCaracteristicaPorEnum(Caracteristica.DESTREZA));
	}

	@Test
	public void caracteristicasDeLigaVillanosTest() {
		Assert.assertEquals(500, villanos1.getCaracteristicaPorEnum(Caracteristica.VELOCIDAD));
		Assert.assertEquals(1200, villanos1.getCaracteristicaPorEnum(Caracteristica.FUERZA));
		Assert.assertEquals(1250, villanos1.getCaracteristicaPorEnum(Caracteristica.RESISTENCIA));
		Assert.assertEquals(700, villanos1.getCaracteristicaPorEnum(Caracteristica.DESTREZA));
	}

}
