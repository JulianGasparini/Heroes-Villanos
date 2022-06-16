package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import manejoDePersonajes.*;

public class CreadorLigas {

	private ArenaDeCombate ac;

	public CreadorLigas() {
		ac = ArenaDeCombate.getInstancia();
	}
	/*
	 * @pos: procesa una Liga construida en una linea con el formato correspondiente ("Nombre Liga", Integrante n, Integrante n+1, ...)
	 * 		Si la liga se crea sin problemas la almacena en la lista de competidores de la clase ArenaDeCombate
	 */
	public void cargarLigaAMemoria(String[] datos) throws LigaNoPudoCrearseCorrectamente {
		try {

			Liga nuevaLiga = new Liga(datos[0].trim()); // Nombre
			System.out.println(datos[1]);
			nuevaLiga.setTipo(ac.getCompetidor(datos[1].trim()).getTipoDeCompetidor()); //Set tipo de Liga

			for (int i = 1; i < datos.length; i++) { // Mientras la linea siga

				Competidor adicionALiga = ac.getCompetidor(datos[i].trim()); // Busca el personaje

				if (adicionALiga == null)	{								// Si no existe, levanta excepcion
					throw new CompetidorNoExisteException();
					}

				if (!adicionALiga.getPerteneceALiga()
						|| adicionALiga.getTipoDeCompetidor() == nuevaLiga.getTipoDeCompetidor()) { // Si existe, le pregunta si ya no pertenece a otra liga
																									// y si coincide con el tipo de villano/heroe

					nuevaLiga.agregarCompetidor(adicionALiga);										// Lo agrega a la liga y lo marca como perteneciente a una liga
					adicionALiga.setPerteneceALiga(true);

				} else {
					throw new CompetidorNoPuedeAgregarseALigaException();
				}
			}
			
			ac.agregarCompetidor(nuevaLiga);														// Luego de iterar por todos los integrantes, agrega la liga a la lista de competidores
			ac.agregarALigas(nuevaLiga);
		} catch (CompetidorNoPuedeAgregarseALigaException e) {
			throw new LigaNoPudoCrearseCorrectamente();
		} catch (CompetidorNoExisteException | CompetidorRepetidoException e) {
			System.err.println("Competidor no existe");
		}

	}
	
	/*
	 * @pos: Procesa un archivo conteniendo multiples lineas que conforman ligas
	 */
	public void cargarLigaDesdeArchivo(String archivo) throws FileNotFoundException, LigaNoPudoCrearseCorrectamente {

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
