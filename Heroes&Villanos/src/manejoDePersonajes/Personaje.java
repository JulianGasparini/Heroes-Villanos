package manejoDePersonajes;

import java.util.ArrayList;
import java.util.List;

public class Personaje extends Competidor {

	private String nombreReal;	
	private Tipo tipo;
	private List<Integer> caracteristicas = new ArrayList<Integer>();

	public Personaje(Tipo tipo, String nombreReal, String nombrePersonaje, int velocidad, int fuerza, int resistencia,
			int destreza) {

		this.tipo = tipo;
		this.nombreReal = nombreReal;
		this.nombre = nombrePersonaje;
		this.perteneceALiga = false;
		caracteristicas.add(velocidad);
		caracteristicas.add(fuerza);
		caracteristicas.add(resistencia);
		caracteristicas.add(destreza);
		caracteristicasEnum.add(Caracteristica.VELOCIDAD);
		caracteristicasEnum.add(Caracteristica.FUERZA);
		caracteristicasEnum.add(Caracteristica.RESISTENCIA);
		caracteristicasEnum.add(Caracteristica.DESTREZA);
	}

	@Override
	public Tipo tipoDeCompetidor() {
		return this.tipo;
	}

	@Override
	public int obtenerCaracteristica(Caracteristica c) {
		int i = c.ordinal();
		return caracteristicas.get(i);
	}

	@Override
	public String toString() {

		return this.tipo + ", " + this.nombreReal + ", " + this.nombre + ", " + this.caracteristicas.get(0)
				+ ", " + this.caracteristicas.get(1) + ", " + this.caracteristicas.get(2) + ", "
				+ this.caracteristicas.get(3);

//		return "Tipo: " + this.tipo + ", Nombre real: " + this.nombreReal + ", Nombre de personaje: "
//				+ this.nombrePersonaje + "\n" + "VELOCIDAD : " + caracteristicas.get(Caracteristica.VELOCIDAD.ordinal())
//				+ "\nFUERZA : " + caracteristicas.get(Caracteristica.FUERZA.ordinal()) + "\nRESISTENCIA: "
//				+ caracteristicas.get(Caracteristica.RESISTENCIA.ordinal()) + "\nDESTRESA: "
//				+ caracteristicas.get(Caracteristica.DESTREZA.ordinal());
	}

	public static void main(String[] args) {

		// velocidad, fuerza , resistencia y destreza

		Competidor heroe = new Personaje(Tipo.Heroe, "Bruce Wayne", "Batman", 1000, 800, 800, 600);
		Competidor villano = new Personaje(Tipo.Villano, "Clark Kent", "Superman", 1000, 600, 800, 700);

		System.out.println(heroe.toString());
		System.out.println("Heroe gano: " + heroe.esGanador(villano, Caracteristica.VELOCIDAD));
		System.out.println("Villano gano: " + villano.esGanador(heroe, Caracteristica.VELOCIDAD));

		System.out.println("Por Fuerza");
		System.out.println("Heroe gano: " + heroe.esGanador(villano, Caracteristica.FUERZA));
		System.out.println("Villano gano: " + villano.esGanador(heroe, Caracteristica.FUERZA));

		// EMPATE PREGUNTAR COMO RESOLVER
		System.out.println("Por Resistencia");
		System.out.println("Heroe gano: " + heroe.esGanador(villano, Caracteristica.RESISTENCIA));
		System.out.println("Villano gano: " + villano.esGanador(heroe, Caracteristica.RESISTENCIA));

		System.out.println("Por Destreza");
		System.out.println("Heroe gano: " + heroe.esGanador(villano, Caracteristica.DESTREZA));
		System.out.println("Villano gano: " + villano.esGanador(heroe, Caracteristica.DESTREZA));

	}

}
