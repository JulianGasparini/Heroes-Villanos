package io;

import Excepciones.CompetidorNoExisteException;
import Excepciones.CompetidorNoPuedeAgregarseALigaException;
import Excepciones.CompetidorRepetidoException;
import Excepciones.LigaNoPudoCrearseCorrectamente;
import ManipuladorCompetidores.ArenaDeCombate;
import manejoDePersonajes.*;

public class CreadorLigas extends Creador {

	/*
	 * @pos: procesa una Liga construida en una linea con el formato correspondiente
	 * ("Nombre Liga", Integrante n, Integrante n+1, ...) Si la liga se crea sin
	 * problemas la almacena en la lista de competidores de la clase ArenaDeCombate
	 */
	public boolean crear(String[] datos) throws LigaNoPudoCrearseCorrectamente {
		ArenaDeCombate ac = ArenaDeCombate.getInstancia();
		try {

			Liga nuevaLiga = new Liga(datos[0].trim());
			try {
				nuevaLiga.setTipoDeCompetidor(ac.getCompetidor(datos[1].trim()).getTipoDeCompetidor());
			} catch (NullPointerException e) {
				throw new CompetidorNoExisteException();
			}
			for (int i = 1; i < datos.length; i++) {

				Competidor adicionALiga = ac.getCompetidor(datos[i].trim());

				if (adicionALiga == null) {
					throw new CompetidorNoExisteException();
				}

				if (!adicionALiga.getPerteneceALiga()
						|| adicionALiga.getTipoDeCompetidor() == nuevaLiga.getTipoDeCompetidor()) {
					nuevaLiga.agregarCompetidor(adicionALiga);
					adicionALiga.setPerteneceALiga(true);

				} else {
					throw new CompetidorNoPuedeAgregarseALigaException();
				}
			}

			ac.agregarCompetidor(nuevaLiga);
			ac.agregarALigas(nuevaLiga);
			return true;
		} catch (CompetidorNoPuedeAgregarseALigaException | CompetidorNoExisteException | CompetidorRepetidoException e) {
			throw new LigaNoPudoCrearseCorrectamente();
		}
	}
}
