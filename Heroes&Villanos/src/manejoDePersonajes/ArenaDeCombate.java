package manejoDePersonajes;

import java.util.LinkedList;
import java.util.List;

public class ArenaDeCombate {

	private static ArenaDeCombate instancia;

	private List<Competidor> competidores = new LinkedList<Competidor>();

	public List<Competidor> getCompetidores() {
		return competidores;
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
			if (competidor.getNombre().equals(nombre)) {
				esperado = competidor;
			}
		}
		return esperado;
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

	@Override
	public String toString() {
		String rt = "";
		for (Competidor competidor : competidores) {
			rt += competidor.toString() + "\n";
		}

		return rt;
	}

}
