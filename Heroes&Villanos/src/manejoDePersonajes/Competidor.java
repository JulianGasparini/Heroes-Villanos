package manejoDePersonajes;

import java.util.ArrayList;
import java.util.List;

public abstract class Competidor  {
	public List<Caracteristica> caracteristicasEnum = new ArrayList<Caracteristica>();

	public abstract int obtenerCaracteristica(Caracteristica c);

	public abstract Tipo tipoDeCompetidor();

	public boolean esGanador(Competidor enemigo, Caracteristica c) {

		int numeroDeCarac = c.ordinal();

		if (this.esEmpate(enemigo, caracteristicasEnum.get(numeroDeCarac))) {

			System.out.println("caracteristica empate " + c);
			
			return this.esGanador(enemigo, caracteristicasEnum.get(numeroDeCarac + 1));

		} else {
			System.out.println("caracteristica a Pelear por " + c);

			return (this.obtenerCaracteristica(c) > enemigo.obtenerCaracteristica(c));
		}
	}

	private boolean esEmpate(Competidor enemigo, Caracteristica c) {

		return (this.obtenerCaracteristica(c) == enemigo.obtenerCaracteristica(c));

	}

}
