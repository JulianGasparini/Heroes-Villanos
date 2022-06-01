package io;

public class Menu {

	public String principal() {

		return "1 - Administración de Personajes\n" + 
			   "2 - Administración de Ligas\n" + 
			   "3 - Realización de Combates\n"
			 + "4 - Reportes\n" +
			   "5 - Salir";
	}
	
	public String administracionDePersonajes() {
		
		return "	1- Carga desde archivo\n" +
			   "	2- Creación\n" +
			   "	3- Listado\n" +
			   "	4- Guardar en archivo todos los personajes";
	}
	
	public String administracionDeLigas() {
		return "	1- Carga desde archivo\n" +
			   "	2- Creación\n" +
			   "	3- Listado\n" +
			   "	4- Guardar en archivo todas las ligas";
	}
	
	public String realizacionCombates() {
		return "	1- Personaje contra Liga" +
			   "	2- Liga contra Liga";
	}
	
	public String reportes() {
		return "	1- Todos los personajes o ligas que venzan a un personaje dado para cierta caracteística" +
			   "	2- Listado ordenado de personajes por múltiples características";
		
	}

}
