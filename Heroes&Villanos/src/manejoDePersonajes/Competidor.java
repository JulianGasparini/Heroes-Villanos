package manejoDePersonajes;

import java.util.ArrayList;
import java.util.List;

import Excepciones.EsEmpateException;

public abstract class Competidor {

	// ATRIBUTOS
	public List<Caracteristica> caracteristicasEnum = new ArrayList<Caracteristica>();
	protected List<Integer> caracteristicas = new ArrayList<Integer>();
	protected boolean perteneceALiga;
	protected String nombre;
	protected Tipo tipoDeCompetidor;

	public abstract int obtenerCaracteristica(Caracteristica c);

	/*
	 * @return: devuelve true si los valores numericos para las caracteristicas de
	 * ambos competidores son iguales
	 */
	public boolean sonIguales(Competidor obj) {
		boolean sonIguales = true;

		for (int i = 0; i < this.caracteristicasEnum.size(); i++) {
			if (sonIguales) {
				if (this.caracteristicas.get(i) != obj.caracteristicas.get(i)) {
					sonIguales = false;
				}
			}
		}

		return sonIguales;
	}

	/*
	 * @return: tipoDeCompetidor
	 */
	public Tipo getTipoDeCompetidor() {
		return this.tipoDeCompetidor;
	}

	/*
	 * @return: nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/*
	 * @return: devuelve True si la caracteristica deseada es superior. En caso de
	 * haber empate revisara las siguientes caracteristicas de forma ciclica.
	 * 
	 * @throws: EsEmpateException: si todas las caracteristicas son iguales levanta
	 * esta excepcion
	 */
	public boolean esGanador(Competidor enemigo, Caracteristica c) throws EsEmpateException {

		int numeroDeCarac = c.ordinal();

		if (this.sonIguales(enemigo)) {
			throw new EsEmpateException();
		}

		if (this.esEmpate(enemigo, caracteristicasEnum.get(numeroDeCarac))) {
			if (numeroDeCarac + 1 >= 4) {
				return this.esGanador(enemigo, caracteristicasEnum.get(0));
			} else
				return this.esGanador(enemigo, caracteristicasEnum.get(numeroDeCarac + 1));

		} else {

			return (this.obtenerCaracteristica(c) > enemigo.obtenerCaracteristica(c));
		}
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
	 * @return: Compara dos caracteristicas. Devuelve True si son iguales, false en
	 * caso contrario
	 */
	private boolean esEmpate(Competidor enemigo, Caracteristica c) {

		return (this.obtenerCaracteristica(c) == enemigo.obtenerCaracteristica(c));

	}

}
