package manejoDePersonajes;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Excepciones.CompetidorRepetidoException;
import Excepciones.EsEmpateException;

public class ArenaDeCombate {

	/*
	 * @Atributo: instancia unica
	 */
	private static ArenaDeCombate instancia;

	/*
	 * Distintas estructuras que utiliza el programa para almacenar los datos
	 */
	private List<Competidor> competidores = new LinkedList<Competidor>();
	private List<Liga> ligas = new LinkedList<Liga>();
	private List<Personaje> personajes = new LinkedList<Personaje>();

	/*
	 * @return: competidores
	 */
	public List<Competidor> getCompetidores() {
		return competidores;
	}

	/*
	 * @return: ligas
	 */
	public List<Liga> getLigas() {
		return ligas;
	}

	/*
	 * @return: personajes
	 */
	public List<Personaje> getPersonajes() {
		return personajes;
	}

	/*
	 * @return: devuelve un String que contiene los competidores que son vencidos
	 * dada la caracteristica indicada en el parametro por el competidor que se pasa
	 * por parametro
	 */
	public String getCompetidoresQuePuedeVencer(Competidor comp, Caracteristica c) {

		String rt = "";
		for (Competidor competidor : competidores) {
			try {
				if (comp.esGanador(competidor, c)) {
					rt += competidor.toString() + "\n";
				}
			} catch (EsEmpateException e) {
			}
		}
		return rt;
	}

	/*
	 * @pos: ordena los competidores utilizando quicksort
	 */
	public Competidor[] sortearCompetidores(Caracteristica c) {
		Competidor[] competidoresO = new Competidor[competidores.size()];
		Iterator<Competidor> it = competidores.iterator();
		for (int i = 0; i < competidoresO.length; i++) {
			competidoresO[i] = it.next();
		}

		quickSort(competidoresO, 0, competidoresO.length - 1, c);

		return competidoresO;
	}

	/*
	 * @return: devuelve un String con los competidores ordenados por la
	 * caracteristica indicada por parametro
	 */
	public String toStringOrdenados(Caracteristica c) {
		Competidor[] ordenados = new Competidor[competidores.size()];
		ordenados = this.sortearCompetidores(c);
		String rt = "";
		for (int i = 0; i < ordenados.length; i++) {
			rt += ordenados[i] + "\n";
		}
		return rt;

	}

	/*
	 * @return: tamanio de competidores
	 */
	public int cantCompetidores() {
		return competidores.size();
	}

	/*
	 * @pos: vacia la lista de competidores. Se utiliza durante las pruebas
	 */
	public void vaciarListaCompetidores() {
		competidores.clear();
	}

	/*
	 * @pos: devuelve la referencia al competidor que se identifica con el 'nombre'
	 * indicado en los parametros
	 */
	public Competidor getCompetidor(String nombre) {
		Competidor esperado = null;
		for (Competidor competidor : competidores) {
			if (competidor.getNombre().trim().equals(nombre)) {
				esperado = competidor;
			}
		}
		return esperado;
	}

	/*
	 * @pos: agrega una Liga a la lista de ligas de la clase
	 */
	public void agregarALigas(Liga liga) {
		this.ligas.add(liga);
	}

	/*
	 * @pos: agrega un Personaje a la lista de Personajes de la clase
	 */
	public void agregarAPersonajes(Personaje personaje) {
		this.personajes.add(personaje);
	}

	/*
	 * @pos: devuelve TRUE si agrego el objeto, levanta una excepcion si no pudo
	 * hacerlo
	 */
	public boolean agregarCompetidor(Competidor competidor) throws CompetidorRepetidoException {
		if (competidores.contains(competidor)) {
			throw new CompetidorRepetidoException();
		}
		return competidores.add(competidor);
	}

	/*
	 * @Constructor: Inicializa una instancia unica durante tiempo de ejecucion
	 */
	public static ArenaDeCombate getInstancia() {

		if (instancia == null) {
			instancia = new ArenaDeCombate();
		}

		return instancia;
	}

	/*
	 * @return: devuelve un String con las ligas que se encuentran guardadas en
	 * memoria
	 */
	public String toStringLigas() {
		String rt = "";
		for (Liga liga : ligas) {
			rt += "Liga: " + liga.getNombre() + ". Integrantes: " + liga.toString() + "\n";
		}

		return rt;
	}

	/*
	 * @return: devuelve un String con los Personajes que se encuentran guardados en
	 * memoria
	 */
	public String toStringPersonajes() {
		String rt = "";
		for (Personaje personaje : personajes) {
			rt += personaje.toString() + "\n";
		}

		return rt;
	}

	/*
	 * @return: devuelve un String con todos los competidores que se encutran
	 * guardados en memoria
	 */
	@Override
	public String toString() {
		String rt = "";
		for (Competidor competidor : competidores) {
			rt += competidor.toString() + "\n";
		}

		return rt;
	}

	/*
	 * Quicksort modificado para trabajar sobre la caracteristica indicada
	 */
	private void quickSort(Competidor[] arr, int low, int high, Caracteristica c) {
		if (low < high) {

			int pi = partition(arr, low, high, c);

			quickSort(arr, low, pi - 1, c);
			quickSort(arr, pi + 1, high, c);
		}
	}

	private void swap(Competidor[] arr, int i, int j) {
		Competidor temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private int partition(Competidor[] arr, int low, int high, Caracteristica c) {

		Competidor pivot = arr[high];

		int i = (low - 1);

		for (int j = low; j <= high - 1; j++) {

			if (arr[j].obtenerCaracteristica(c) < pivot.obtenerCaracteristica(c)) {

				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return (i + 1);
	}

}
