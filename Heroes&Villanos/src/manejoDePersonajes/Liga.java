package manejoDePersonajes;

import java.util.*;

public class Liga extends Competidor {

	Tipo tipo;
	private String nombreLiga;
	private ArrayList<Competidor> liga;

	// Constructor de liga
	public Liga(Tipo tipo, String nombreLiga) {
		this.tipo = tipo;
		this.nombreLiga = nombreLiga;
		this.liga = new ArrayList<Competidor>();
	}

	// Agrega competidor a lista de liga
	public void agregarCompetidor(Competidor p) {
		liga.add(p);
	}

	// Imprime la lista de competidores
	public void obtenerListaCompetidores() {

		System.out.println(liga.toString());
	}

	// Obtiene el nombre de liga
	public String getNombreLiga() {
		return nombreLiga;
	}

	// Devuelve el tipo de la liga
	@Override
	public Tipo tipoDeCompetidor() {
		return this.tipo;
	}

	// Obtiene el valor de la caracteristica que se pasa por parámetro
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
		return "\n[Tipo: " + tipo + ", Nombre de liga: " + nombreLiga + "]\n" + liga.toString();
	}

}
