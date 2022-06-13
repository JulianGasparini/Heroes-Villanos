package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import manejoDePersonajes.*;

public class CreadorLigas {

	private ArenaDeCombate ar;

	public CreadorLigas() {
		ar = ArenaDeCombate.getInstancia();
	}

	public void cargarLigaAMemoria(String[] datos) {
		try {

			Liga nuevaLiga = new Liga(datos[0].trim());

			for (int i = 1; i < datos.length; i++) {

				Competidor adicionALiga = ar.getCompetidor(datos[i].trim());

				try {

					if (adicionALiga == null)
						throw new CompetidorNoExisteException();

				} catch (Exception e) {
					System.err.println("El competidor no existe");
				}

				if (!adicionALiga.getPerteneceALiga()) {
					nuevaLiga.agregarCompetidor(adicionALiga);
					adicionALiga.setPerteneceALiga(true);
				}
			}

			ar.agregarCompetidor(nuevaLiga);

		} catch (Exception e) {
			System.err.println("No pudo crearse Liga");
		}

	}

	public void cargarLigaDesdeArchivo(String archivo) throws FileNotFoundException {

		try {

			BufferedReader bf = new BufferedReader(new FileReader(archivo));
			String linea;

			while ((linea = bf.readLine()) != null) {

				String[] datos = linea.split(",");
				cargarLigaAMemoria(datos);

			}

			bf.close();

		} catch (IOException o) {
			throw new FileNotFoundException();
		}

	}

}
