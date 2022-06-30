package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Excepciones.LigaNoPudoCrearseCorrectamente;
import Excepciones.NoSeEncontroElArchivoExcepcion;
import Excepciones.PersonajeNoPudoCrearseCorrectamente;

public abstract class Creador {

	/*
	 * @pos: lee el archivo indicado en el parametro desde el directorio base del
	 * proyecto ...\\Heroes&Villano\\archivo
	 */
	public void cargarDesdeArchivo(String archivo)
			throws LigaNoPudoCrearseCorrectamente, PersonajeNoPudoCrearseCorrectamente, NoSeEncontroElArchivoExcepcion {

		try {

			BufferedReader bf = new BufferedReader(new FileReader(archivo));
			String linea;

			while ((linea = bf.readLine()) != null) {

				String[] datos = linea.split(",");
				crear(datos);

			}

			bf.close();

		} catch (IOException o) {
			throw new NoSeEncontroElArchivoExcepcion();
		}

	}

	public abstract boolean crear(String[] datos)
			throws PersonajeNoPudoCrearseCorrectamente, LigaNoPudoCrearseCorrectamente;
}