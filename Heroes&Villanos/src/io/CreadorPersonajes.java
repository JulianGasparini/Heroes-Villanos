package io;

import Excepciones.CompetidorRepetidoException;
import Excepciones.PersonajeNoPudoCrearseCorrectamente;
import competidores.*;
import manipuladorCompetidores.ArenaDeCombate;

/*
 * Esta clase tiene la responsabilidad de crear Personajes, sean ingresados por consola o por un archivo de texto
 */
public class CreadorPersonajes extends Creador {

	/*
	 * @pos: crea un personaje y lo agrega a la lista en la instancia de la Arena de
	 * combate
	 */
	@Override
	public boolean crear(String[] datos) throws PersonajeNoPudoCrearseCorrectamente {
		ArenaDeCombate arena = ArenaDeCombate.getInstancia();

		try {

			Personaje nuevo = new Personaje(Tipo.valueOf(datos[0]), datos[1], datos[2],
					Integer.parseInt(datos[3].trim()), Integer.parseInt(datos[4].trim()),
					Integer.parseInt(datos[5].trim()), Integer.parseInt(datos[6].trim()));
			arena.agregarCompetidor(nuevo);
			arena.agregarAPersonajes(nuevo);
			return true;

		} catch (IllegalArgumentException | IndexOutOfBoundsException | CompetidorRepetidoException e) {
			throw new PersonajeNoPudoCrearseCorrectamente();
		}
	}
}
