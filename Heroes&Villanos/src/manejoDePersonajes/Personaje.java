package manejoDePersonajes;

import java.util.HashMap;

public class Personaje implements Competidor {

	private String nombreReal;
	private String nombrePersonaje;
	private Tipo tipo;
	private HashMap<Caracteristica, Integer> caracteristicas = new HashMap<Caracteristica, Integer>();

	public Personaje(Tipo tipo, String nombreReal, String nombrePersonaje, int velocidad, int fuerza, int resistencia,
			int destreza) {
		this.tipo = tipo;
		this.nombreReal = nombreReal;
		this.nombrePersonaje = nombrePersonaje;
		caracteristicas.put(Caracteristica.VELOCIDAD, velocidad);
		caracteristicas.put(Caracteristica.FUERZA, fuerza);
		caracteristicas.put(Caracteristica.RESISTENCIA, resistencia);
		caracteristicas.put(Caracteristica.DESTREZA, destreza);
	}

	@Override
	public Tipo tipoDeCompetidor() {
		return this.tipo;
	}

	@Override
	public int obtenerCaracteristica(Caracteristica c) {
		return caracteristicas.get(c);
	}

	@Override
	public String toString() {
		return "Tipo: " + this.tipo + ", Nombre real: " + this.nombreReal + ", Nombre de personaje: "
				+ this.nombrePersonaje + "\n" + "VEL: " + caracteristicas.get(Caracteristica.VELOCIDAD) + ", FUE: "
				+ caracteristicas.get(Caracteristica.FUERZA) + ", RES: "
				+ caracteristicas.get(Caracteristica.RESISTENCIA) + ", DES: "
				+ caracteristicas.get(Caracteristica.DESTREZA);
	}
}
