package Excepciones;

public class PersonajeNoPudoCrearseCorrectamente extends Exception {

	/**
	 * Esta excepcion aparece cuando un Personaje no puede crearse por una linea de
	 * datos mal formada
	 */
	private static final long serialVersionUID = 1L;

	public PersonajeNoPudoCrearseCorrectamente() {
		super("Linea de personaje mal formada, los datos introducidos fueron incorrectos o se encontraban en posiciones equivocadas");

	}

}
