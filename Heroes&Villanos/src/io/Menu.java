package io;

public class Menu {

	/*
	 * Devuelve los distintos Menus y submenus utilizados en el metodo main() del
	 * demo
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

	public String submenuCargaArchivo() {
		return "Seleccionaste: carga desde archivo\n" + "Introduci el nombre del archivo que queres cargar\n";
	}

	public String submenuCreacionPersonaje() {
		return "Seleccionaste: creaci�n\n"
				+ "Introduci la linea con los datos de tu personaje en el siguiente orden: \n"
				+ "1- Heroe/Villano\n2-Nombre real\n3-Nombre de personaje\n4-Su velocidad\n5-Su fuerza\n6-Su resistencia\n7-Su destreza";
	}

	public String submenuGuardarPersonajes() {
		return "Seleccionaste: Guardar en archivo todos los personajes\n"
				+ "Introduci el nombre del archivo donde se van a guardar los personajes (sin .txt): ";
	}

	public String submenuCreacionLiga() {
		return "Seleccionaste: creaci�n\n" + "Introduci el nombre de la liga a crear";
	}

	public String submenuGuardarLigas() {
		return "Seleccionaste: Guardar en archivo todos las ligas\n"
				+ "Introduci el nombre del archivo donde se van a guardar las ligas (sin .txt): ";
	}

	public String submenuCombate() {
		return "Seleccionaste: combate\n"
				+ "Ingresa la caracteristica por la que van a combatir los Competidores(VELOCIDAD, FUERZA, RESISTENCIA, DESTREZA)";
	}

	public String submenuListadoCombate() {
		return "Seleccionaste: Personajes ligas que venzan a x personajes o liga\n"
				+ "Ingresa tu personaje o liga que queres comparar con el resto";
	}

}
