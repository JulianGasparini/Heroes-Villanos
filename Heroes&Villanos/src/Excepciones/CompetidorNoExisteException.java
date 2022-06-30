package Excepciones;

public class CompetidorNoExisteException extends Exception {

	/**
	 * Esta excepcion aparece cuando se busca un Competidor en la instancia de
	 * ArenaDeCombate y este no existe
	 */
	private static final long serialVersionUID = 1L;
	
	public CompetidorNoExisteException() {
		super("El Competidor no se encuentra dentro de los guardados en memoria");
	}
}
