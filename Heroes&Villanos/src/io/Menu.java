package io;

public class Menu {

	/*
	 * Devuelve los distintos Menus utilizados en el metodo main() del demo
	 */

	public String principal() {

		return "1 - Administraci�n de Personajes\n" + "2 - Administraci�n de Ligas\n" + "3 - Realizaci�n de Combates\n"
				+ "4 - Reportes\n" + "5 - Salir";
	}

	public String administracionDePersonajes() {

		return "	1- Carga desde archivo\n" + "	2- Creaci�n\n" + "	3- Listado\n"
				+ "	4- Guardar en archivo todos los personajes";
	}

	public String administracionDeLigas() {
		return "	1- Carga desde archivo\n" + "	2- Creaci�n\n" + "	3- Listado\n"
				+ "	4- Guardar en archivo todas las ligas";
	}

	public String realizacionCombates() {
		return "	1- Personaje contra Liga\n" + "	2- Liga contra Liga";
	}

	public String reportes() {
		return "	1- Listado ordenado de personajes por m�ltiples caracter�sticas\n"
				+ "	2- Todos los personajes o ligas que venzan a un personaje dado para cierta caracte�stica";

	}

}
