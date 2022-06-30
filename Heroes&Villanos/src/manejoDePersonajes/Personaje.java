package manejoDePersonajes;

public class Personaje extends Competidor {

	// Atributos
	private String nombreReal;

	/*
	 * @pos: crea un objeto de tipo Personaje y asigna los parametros a los
	 * atributos correspondientes
	 */
	public Personaje(Tipo tipo, String nombreReal, String nombrePersonaje, int velocidad, int fuerza, int resistencia,
			int destreza) {
		super();
		this.nombreReal = nombreReal;
		setTipoDeCompetidor(tipo);
		setNombre(nombrePersonaje);
		setPerteneceALiga(false);
		agregarCaracteristica(velocidad);
		agregarCaracteristica(fuerza);
		agregarCaracteristica(resistencia);
		agregarCaracteristica(destreza);

	}

	/*
	 * @return: devuelve la posicion de la caracteristica en el Enumerado
	 */
	public int getCaracteristicaPorEnum(Caracteristica c) {
		int i = c.ordinal();
		return getCaracteristica(i);
	}

	/*
	 * @return: nombre
	 */
	public String getNombreReal() {
		return nombreReal;
	}

	@Override
	public String toString() {

		return this.getTipoDeCompetidor() + ", " + this.getNombreReal() + ", " + this.getNombre() + ", "
				+ this.getCaracteristica(0) + ", " + this.getCaracteristica(1) + ", " + this.getCaracteristica(2) + ", "
				+ this.getCaracteristica(3);

	}

}
