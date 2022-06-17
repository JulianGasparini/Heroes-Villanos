package Excepciones;

public class LineaDePersonajeMalCreada extends Exception {

	/**
	 * Esta excepcion aparece cuando un Personaje no puede crearse por una linea de datos mal formada
	 */
	private static final long serialVersionUID = 1L;
	
	public LineaDePersonajeMalCreada() {
		super("Linea de personaje mal formada");
		
	}

}
