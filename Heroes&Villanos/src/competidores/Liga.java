package competidores;

import java.util.*;

public class Liga extends Competidor {

	private ArrayList<Competidor> liga;

	// Constructor de liga
	public Liga(String nombreLiga) {
		setNombre(nombreLiga);
		this.liga = new ArrayList<Competidor>();
		setPerteneceALiga(false);;
	}

	// Agrega competidor a lista de liga
	public boolean agregarCompetidor(Competidor p) {
		return liga.add(p);
	}

	// Obtiene el valor de la caracteristica que se pasa por parámetro
	@Override
	public int getCaracteristicaPorEnum(Caracteristica c) {
		int suma = 0;
		for (Competidor p : liga) {
			suma += p.getCaracteristicaPorEnum(c);
		}
		return suma;
	}

	@Override
	public String toString() {
		String rt = "";
		for (Competidor competidor : liga) {
			rt += competidor.getNombre() + ", ";
		}
		return rt;
	}

}
