package Excepciones;

public class NoSeEncontroElArchivoExcepcion extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSeEncontroElArchivoExcepcion() {
		super("No se encontro el archivo. Intente agregando el tipo de archivo (Ejemplo: Test.txt)");
	}
	
}
