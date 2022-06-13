package io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import manejoDePersonajes.*;

/*
 * Guarda los distintos personajes y ligas almacenados en la memoria dinamica a la memoria estatica en formato de archivo de textos
 */
public class Escritor {

	private ArenaDeCombate ar;

	/*
	 * @Constructor: obtiene la unica instancia de arena
	 */
	public Escritor() {
		ar = ArenaDeCombate.getInstancia();
	}

	/*
	 * @pos: guarda los personajes en un archivo de texto, el cual obtendra su
	 * 			nombre por los parametros del metodo
	 */
	public void escribirPersonajesEnArchivo(String nombreArchivo) {

		File personajes = new File(nombreArchivo + ".txt");
		try (FileWriter fw = new FileWriter(personajes)) {
			List<Competidor> personajesGuardados = ar.getCompetidores();
			for (Competidor competidor : personajesGuardados) {
				fw.write(competidor.toString() + "\n");
			}

		} catch (IOException e) {
			System.err.println("No se pudo crear el archivo");
		}
	}

}
