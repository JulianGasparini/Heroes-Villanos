package manejoDePersonajes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Competidor {

	// ATRIBUTOS
	private List<Caracteristica> caracteristicasEnum = new ArrayList<Caracteristica>();
	private List<Integer> caracteristicas = new ArrayList<Integer>();
	private boolean perteneceALiga;
	private String nombre;
	private Tipo tipoDeCompetidor;

	/*
	 * Constructor
	 */
	public Competidor() {
		caracteristicasEnum.add(Caracteristica.VELOCIDAD);
		caracteristicasEnum.add(Caracteristica.FUERZA);
		caracteristicasEnum.add(Caracteristica.RESISTENCIA);
		caracteristicasEnum.add(Caracteristica.DESTREZA);
	}

	/*
	 * Metodo equals utilizando caracteristicas como punto de comparacion
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Competidor other = (Competidor) obj;
		return Objects.equals(caracteristicas, other.caracteristicas);
	}

	/*
	 * @return: devuelve True si la caracteristica deseada es superior. En caso de
	 * haber empate revisara las siguientes caracteristicas de forma ciclica.
	 */
	public boolean esGanador(Competidor enemigo, Caracteristica c) {

		int numeroDeCarac = c.ordinal();

		if (esEmpate(enemigo)) {
			return false;
		}

		if (this.esEmpateEnCaracteristica(enemigo, caracteristicasEnum.get(numeroDeCarac))) {
			if (numeroDeCarac + 1 >= 4) {
				return this.esGanador(enemigo, caracteristicasEnum.get(0));
			} else
				return this.esGanador(enemigo, caracteristicasEnum.get(numeroDeCarac + 1));

		} else {

			return (this.getCaracteristicaPorEnum(c) > enemigo.getCaracteristicaPorEnum(c));
		}
	}

	/*
	 * @return: true si es empate entre todas las caracteristicas
	 */
	public boolean esEmpate(Competidor enemigo) {
		return this.equals(enemigo);
	}

	/*
	 * @return: Compara dos caracteristicas. Devuelve True si son iguales, false en
	 * caso contrario
	 */
	private boolean esEmpateEnCaracteristica(Competidor enemigo, Caracteristica c) {

		return (this.getCaracteristicaPorEnum(c) == enemigo.getCaracteristicaPorEnum(c));

	}

	///// Getters y setters

	/*
	 * @return: devuelve la caracteristica del enum indicado en los parametros
	 */
	public abstract int getCaracteristicaPorEnum(Caracteristica c);

	/*
	 * @pos: agrega
	 */
	/*
	 * @return: tipoDeCompetidor
	 */
	public Tipo getTipoDeCompetidor() {
		return this.tipoDeCompetidor;
	}

	/*
	 * @return: tipoDeCompetidor
	 */
	public void setTipoDeCompetidor(Tipo tipo) {
		this.tipoDeCompetidor = tipo;
	}

	/*
	 * @return: nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/*
	 * @pos: cambia el nombre al indicado por los parametros
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/*
	 * @return: True si ya pertenece a una liga. False en caso contrario
	 */
	public boolean getPerteneceALiga() {
		return perteneceALiga;
	}

	/*
	 * @pos: setea el atributo perteneceALiga
	 */
	public void setPerteneceALiga(boolean b) {
		this.perteneceALiga = b;
	}

	/*
	 * @pos: agrega las caracteristicas en el siguiente orden(maximo 4) velocidad -
	 * fuerza - resistencia - destreza
	 */
	public void agregarCaracteristica(int x) {
		caracteristicas.add(x);
	}

	/*
	 * @return: caracteristica en la posicion indicada por el parametro
	 */
	public int getCaracteristica(int x) {
		return caracteristicas.get(x);
	}

}
