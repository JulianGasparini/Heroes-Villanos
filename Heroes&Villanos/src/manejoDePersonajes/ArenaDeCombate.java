package manejoDePersonajes;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ArenaDeCombate {

	private static ArenaDeCombate instancia;

	private List<Competidor> competidores = new LinkedList<Competidor>();
	private List<Liga> ligas = new LinkedList<Liga>();
	private List<Personaje> personajes = new LinkedList<Personaje>();

	public List<Competidor> getCompetidores() {
		return competidores;
	}

	public List<Liga> getLigas() {
		return ligas;
	}

	public List<Personaje> getPersonajes() {
		return personajes;
	}

	public Competidor[] sortearCompetidores(Caracteristica c) {
		Competidor[] competidoresO = new Competidor[competidores.size()];
		Iterator<Competidor> it = competidores.iterator();
		for (int i = 0; i < competidoresO.length; i++) {
			competidoresO[i] = it.next();
		}

		quickSort(competidoresO, 0, competidoresO.length - 1, c);

		return competidoresO;
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
	public String toStringOrdenados(Caracteristica c) {
		Competidor[] ordenados = new Competidor[competidores.size()];
		ordenados = this.sortearCompetidores(c);
		String rt = "";
		for (int i = 0; i < ordenados.length; i++) {
			rt += ordenados[i] + "\n";
		}
		return rt;

	}

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

	public int cantCompetidores() {
		return competidores.size();
	}

	public void vaciarListaCompetidores() {
		competidores.clear();
	}

	public Competidor getCompetidor(String nombre) {
		Competidor esperado = null;
		for (Competidor competidor : competidores) {
			if (competidor.getNombre().trim().equals(nombre)) {
				esperado = competidor;
			}
		}
		return esperado;
	}

	public void agregarALigas(Liga liga) {
		this.ligas.add(liga);
	}

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

	public static ArenaDeCombate getInstancia() {

		if (instancia == null) {
			instancia = new ArenaDeCombate();
		}

		return instancia;
	}

	public String toStringLigas() {
		String rt = "";
		for (Liga liga : ligas) {
			rt += "Liga: " + liga.getNombre()+". Integrantes: " + liga.toString() + "\n";
		}

		return rt;
	}

	public String toStringPersonajes() {
		String rt = "";
		for (Personaje personaje : personajes) {
			rt += personaje.toString() + "\n";
		}

		return rt;
	}

	@Override
	public String toString() {
		String rt = "";
		for (Competidor competidor : competidores) {
			rt += competidor.toString() + "\n";
		}

		return rt;
	}

}
