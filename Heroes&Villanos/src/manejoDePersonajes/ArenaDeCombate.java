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
			rt += competidor.toString()+"\n";
		}

		return rt;
	}

}
