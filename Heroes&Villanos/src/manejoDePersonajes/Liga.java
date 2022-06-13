package manejoDePersonajes;

import java.util.*;

public class Liga extends Competidor {

	Tipo tipo;
	private ArrayList<Competidor> liga;

	// Constructor de liga
	public Liga(String nombreLiga) {
		this.nombre = nombreLiga;
		this.liga = new ArrayList<Competidor>();
		this.perteneceALiga = false;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	// Agrega competidor a lista de liga
	public void agregarCompetidor(Competidor p) {
		liga.add(p);
	}

	// Imprime la lista de competidores
	public void obtenerListaCompetidores() {

		System.out.println(liga.toString());
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
		return "\n[Tipo: " + tipo + ", Nombre de liga: " + nombre + "]\n" + liga.toString();
	}

}
