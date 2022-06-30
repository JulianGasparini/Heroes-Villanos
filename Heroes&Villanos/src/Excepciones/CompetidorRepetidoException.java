package Excepciones;

public class CompetidorRepetidoException extends Exception {

	/**
	 * Esta excepcion aparece cuando intenta agregarse un competidor repetido a una Liga
	 */
	private static final long serialVersionUID = 1L;
	
	public CompetidorRepetidoException() {
		super("El competidor ya existe, no pueden agregarse repetidos ");
	}

}
