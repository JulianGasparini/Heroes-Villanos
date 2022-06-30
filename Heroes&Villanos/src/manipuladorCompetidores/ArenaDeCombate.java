package manipuladorCompetidores;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Excepciones.CompetidorRepetidoException;
import competidores.Caracteristica;
import competidores.Competidor;
import competidores.Liga;
import competidores.Personaje;

public class ArenaDeCombate {

	/*
	 * @Atributo: instancia unica
	 */
	private static ArenaDeCombate instancia;
	private QSCompetidores ordenador;

	/*
	 * Distintas estructuras que utiliza el programa para almacenar los datos
	 */
	private List<Competidor> competidores = new LinkedList<Competidor>();
	private List<Liga> ligas = new LinkedList<Liga>();
	private List<Personaje> personajes = new LinkedList<Personaje>();

	/*
	 * @Constructor: Inicializa una instancia unica durante tiempo de ejecucion
	 */
	private ArenaDeCombate() {
	};

	/*
	 * @return: instancia unica de la clase ArenaDeCombate
	 */
	public static ArenaDeCombate getInstancia() {

		if (instancia == null) {
			instancia = new ArenaDeCombate();
		}

		return instancia;
	}

	/*
	 * @pos: ordena los competidores utilizando quicksort
	 */
	public Competidor[] ordenarCompetidores(Caracteristica c) {
		Competidor[] competidoresO = new Competidor[competidores.size()];
		Iterator<Competidor> it = competidores.iterator();
		for (int i = 0; i < competidoresO.length; i++) {
			competidoresO[i] = it.next();
		}

		ordenador.quickSort(competidoresO, 0, competidoresO.length - 1, c);

		return competidoresO;
	}

	/*
	 * @pos: devuelve TRUE si agrego el objeto, levanta una excepcion si no pudo
	 * hacerlo
	 */
	public boolean agregarCompetidor(Competidor competidor) throws CompetidorRepetidoException {
		if (this.getCompetidor(competidor.getNombre()) != null) {
			throw new CompetidorRepetidoException();
		}
		return competidores.add(competidor);
	}

	/*
	 * @pos: agrega una Liga a la lista de ligas de la clase
	 */
	public boolean agregarALigas(Liga liga) {
		return this.ligas.add(liga);
	}

	/*
	 * @pos: agrega un Personaje a la lista de Personajes de la clase
	 */
	public boolean agregarAPersonajes(Personaje personaje) {
		return this.personajes.add(personaje);
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

	/// ----- Getters y setters -------------------

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
	 * @return: tamanio de competidores
	 */
	public int cantCompetidores() {
		return competidores.size();
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

	/////

	/*
	 * @pos: vacia la lista de competidores. Se utiliza durante las pruebas
	 */
	public void vaciarListaCompetidores() {
		competidores.clear();
	}

}
