package manejoDePersonajes;

import java.util.*;

public class Liga implements Competidor {
	
	Tipo tipo;
	private String nombreLiga;
	private List<Competidor> liga = new ArrayList<Competidor>();

	public Liga(Tipo tipo, String nombreLiga) {
		this.tipo = tipo;
		this.nombreLiga = nombreLiga;
	}

	public void agregarPersonaje(Competidor p) {
		liga.add(p);
	}

	public void obtenerCompetidor() {
		Iterator<Competidor> itr = liga.iterator();
		while (itr.hasNext())
			System.out.println(itr.next().toString());
	}

	@Override
	public Tipo tipoDeCompetidor() {
		return this.tipo;
	}

	@Override
	public int obtenerCaracteristica(Caracteristica c) {
		int suma = 0;
		for (Competidor p : liga) {
			suma += p.obtenerCaracteristica(c);
		}
		return suma;
	}

	@Override
	public String toString() {
		return "\t[Tipo: " + tipo + ", Nombre de liga: " + nombreLiga + "]";
	}

}
