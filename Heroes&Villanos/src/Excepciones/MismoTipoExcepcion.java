package Excepciones;

public class MismoTipoExcepcion extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MismoTipoExcepcion() {
		super("Un heroe debe pelear con un villano");
	}

}
