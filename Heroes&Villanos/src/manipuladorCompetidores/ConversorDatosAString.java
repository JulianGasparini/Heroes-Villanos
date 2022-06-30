package manipuladorCompetidores;

import competidores.Caracteristica;
import competidores.Competidor;
import competidores.Liga;
import competidores.Personaje;

public class ConversorDatosAString {

	// Atributos
	private ArenaDeCombate ac;

	// Constructor
	public ConversorDatosAString() {
		ac = ArenaDeCombate.getInstancia();
	}

	/*
	 * @return: devuelve un String que contiene los competidores que son vencidos
	 * dada la caracteristica indicada en el parametro por el competidor que se pasa
	 * por parametro
	 */
	public String getCompetidoresQuePuedeVencer(Competidor comp, Caracteristica c) {

		String rt = "Listado: \n";
		for (Competidor competidor : ac.getCompetidores()) {
			if (comp.esGanador(competidor, c)) {
				rt += competidor.getNombre() + "\n";
			}
		}
		return rt;
	}

	/*
	 * @return: devuelve un String con los competidores ordenados por la
	 * caracteristica indicada por parametro
	 */
	public String toStringOrdenadosPorCaracteristica(Caracteristica c) {
		Competidor[] ordenados = new Competidor[ac.cantCompetidores()];
		ordenados = ac.ordenarCompetidores(c);
		String rt = "";
		for (int i = 0; i < ordenados.length; i++) {
			rt += ordenados[i] + "\n";
		}
		return rt;

	}

	/*
	 * @return: devuelve un String con las ligas que se encuentran guardadas en
	 * memoria
	 */
	public String toStringLigas() {
		String rt = "";
		for (Liga liga : ac.getLigas()) {
			rt += "Liga: " + liga.getNombre() + ". Integrantes: " + liga.toString() + "\n";
		}

		return rt;
	}

	/*
	 * @return: devuelve un String con los Personajes que se encuentran guardados en
	 * memoria
	 */
	public String toStringPersonajes() {
		String rt = "";
		for (Personaje personaje : ac.getPersonajes()) {
			rt += personaje.toString() + "\n";
		}

		return rt;
	}

}
