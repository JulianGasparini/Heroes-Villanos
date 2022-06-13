package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.InvalidParameterException;
import manejoDePersonajes.*;

/*
 * Esta clase tiene la responsabilidad de crear Personajes, sean ingresados por consola o por un archivo de texto
 */
public class CreadorPersonajes {


	private ArenaDeCombate arena;
	
	/*
	 * @pos: crea un personaje y lo agrega a la lista en la instancia de la Arena de combate
	 */
	public boolean crearPersonaje(String[] datos) throws LineaDePersonajeMalCreada {

		try {

			Competidor nuevo = new Personaje(Tipo.valueOf(datos[0]), datos[1], datos[2],
					Integer.parseInt(datos[3].trim()), Integer.parseInt(datos[4].trim()),
					Integer.parseInt(datos[5].trim()), Integer.parseInt(datos[6].trim()));
			arena.getCompetidores().add(nuevo);
			return true;

		} catch (InvalidParameterException | NumberFormatException | IndexOutOfBoundsException e) { // revisar
			throw new LineaDePersonajeMalCreada();
		}
	}
	
	/*
	 * @pos: lee el archivo indicado en el parametro desde el directorio base del proyecto ...\\Heroes&Villano\\archivo
	 */
	public void cargarPersonajesDesdeArchivo(String archivo) throws FileNotFoundException, LineaDePersonajeMalCreada { // revisar
																														// excepcion

		try {

			BufferedReader bf = new BufferedReader(new FileReader(archivo));
			String linea;

			while ((linea = bf.readLine()) != null) {

				String[] datos = linea.split(",");
				crearPersonaje(datos);

			}

			bf.close();

		} catch (IOException o) {
			throw new FileNotFoundException();
		}

	}
	
	/*
	 * @Constructor: se crea el objeto junto con la instancia de la arena de combate
	 */

	public CreadorPersonajes() {

		arena = ArenaDeCombate.getInstancia();
	}

}
