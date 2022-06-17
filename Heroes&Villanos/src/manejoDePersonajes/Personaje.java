package manejoDePersonajes;

public class Personaje extends Competidor {

	// Atributos
	private String nombreReal;
	private Tipo tipo;

	/*
	 * @pos: crea un objeto de tipo Personaje y asigna los parametros a los
	 * atributos correspondientes
	 */
	public Personaje(Tipo tipo, String nombreReal, String nombrePersonaje, int velocidad, int fuerza, int resistencia,
			int destreza) {

		this.tipo = tipo;
		this.nombreReal = nombreReal;
		this.nombre = nombrePersonaje;
		this.perteneceALiga = false;
		caracteristicas.add(velocidad);
		caracteristicas.add(fuerza);
		caracteristicas.add(resistencia);
		caracteristicas.add(destreza);
		caracteristicasEnum.add(Caracteristica.VELOCIDAD);
		caracteristicasEnum.add(Caracteristica.FUERZA);
		caracteristicasEnum.add(Caracteristica.RESISTENCIA);
		caracteristicasEnum.add(Caracteristica.DESTREZA);
	}

	/*
	 * @return: nombre
	 */
	public String getNombreReal() {
		return nombreReal;
	}

	/*
	 * @return: devuelve la posicion de la caracteristica en el Enumerado
	 */
	@Override
	public int obtenerCaracteristica(Caracteristica c) {
		int i = c.ordinal();
		return caracteristicas.get(i);
	}

	@Override
	public String toString() {

		return this.tipo + ", " + this.nombreReal + ", " + this.nombre + ", " + this.caracteristicas.get(0) + ", "
				+ this.caracteristicas.get(1) + ", " + this.caracteristicas.get(2) + ", " + this.caracteristicas.get(3);

	}

}
