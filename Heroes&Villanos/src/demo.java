
import java.util.Scanner;

import Excepciones.LigaNoPudoCrearseCorrectamente;
import Excepciones.PersonajeNoPudoCrearseCorrectamente;
import Excepciones.MismoTipoExcepcion;
import Excepciones.NoSeEncontroElArchivoExcepcion;
import competidores.*;
import io.*;
import manipuladorCompetidores.ArenaDeCombate;
import manipuladorCompetidores.ConversorDatosAString;

public class demo {

	public static void main(String[] args) {

		Scanner sn = new Scanner(System.in);
		Menu menu = new Menu();
		ArenaDeCombate ac = ArenaDeCombate.getInstancia();
		Escritor es = new Escritor();
		ConversorDatosAString cs = new ConversorDatosAString();
		Creador cl = new CreadorLigas();
		Creador cp = new CreadorPersonajes();

		int opcion;

		do {

			System.out.println(menu.principal());

			opcion = sn.nextInt();

			switch (opcion) {

			case 1:
				int op;
				System.out.println(menu.administracionDePersonajes());
				op = sn.nextInt();

				switch (op) {

				case 1:
					System.out.println(menu.submenuCargaArchivo());

					try {
						cp.cargarDesdeArchivo(sn.next());
					} catch (PersonajeNoPudoCrearseCorrectamente | LigaNoPudoCrearseCorrectamente | NoSeEncontroElArchivoExcepcion e) {
						System.err.println(e.getMessage());
					}
					break;
				case 2:
					System.out.println(menu.submenuCreacionPersonaje());

					String[] pj = new String[7];
					for (int i = 0; i < pj.length; i++) {
						pj[i] = sn.next();
					}
					try {
						cp.crear(pj);
					} catch (PersonajeNoPudoCrearseCorrectamente | LigaNoPudoCrearseCorrectamente e) {
						System.err.println(e.getMessage());
					}

					break;
				case 3:
					System.out.println("Lista: \n" + cs.toStringPersonajes());
					break;
				case 4:
					System.out.println(menu.submenuGuardarPersonajes());
					es.escribirPersonajesEnArchivo(sn.next());
					break;

				}

				break;
			case 2:
				int op2;
				System.out.println(menu.administracionDeLigas());
				op2 = sn.nextInt();

				switch (op2) {

				case 1:
					System.out.println(menu.submenuCargaArchivo());
					try {
						cl.cargarDesdeArchivo(sn.next());
					} catch (NoSeEncontroElArchivoExcepcion | LigaNoPudoCrearseCorrectamente | PersonajeNoPudoCrearseCorrectamente e) {
						System.err.println(e.getMessage());
					}

					break;
				case 2:

					System.out.println(menu.submenuCreacionLiga());

					String liga = sn.next();

					System.out.println(
							"Introduci los personajes o ligas que van a formar parte de la liga.\n Para terminar ingresa un '.'");

					for (int i = 0; i <= 30; i++) {
						String linea = sn.next();
						if (!linea.equals("p")) {
							liga += ", " + linea;
						} else {
							i = 30;
						}
					}
					try {
						cl.crear(liga.split(","));
					} catch (LigaNoPudoCrearseCorrectamente | PersonajeNoPudoCrearseCorrectamente e) {
						System.err.println(e.getMessage());
					}

					break;

				case 3:

					System.out.println("Seleccionaste: Listado\n" + cs.toStringLigas());
					break;

				case 4:
					System.out.println(menu.submenuGuardarLigas());
					es.escribirLigasEnArchivo(sn.next());
					break;

				}

				break;
			case 3:

				System.out.println(menu.submenuCombate());

				try {
					Caracteristica c = Caracteristica.valueOf(sn.next());
					System.out.println("Ingresa el primer competidor: ");
					Competidor c1 = ac.getCompetidor(sn.next().trim());
					System.out.println("Ingresa el segundo competidor: ");
					Competidor c2 = ac.getCompetidor(sn.next().trim());

					if (c1.getTipoDeCompetidor() != c2.getTipoDeCompetidor()) {
						throw new MismoTipoExcepcion();
					}

					if (c1.esGanador(c2, c)) {
						System.out.println("El ganador es: " + c1.getNombre());
					} else
						System.out.println("El ganador es: " + c2.getNombre());

				} catch (IllegalArgumentException e) {
					System.err.println("La caracteristica no existe");
				} catch (MismoTipoExcepcion e) {
					System.err.println(
							"Los dos competidores son del mismo tipo\n para enfrentarse deben ser heroe vs villano o villano vs heroe");
				} catch (NullPointerException e) {
					System.err.println("Personaje no existe");
				}

				break;
			case 4:

				int op4;
				System.out.println(menu.reportes());
				op4 = sn.nextInt();

				switch (op4) {

				case 1:
					System.out.println(
							"Seleccionaste: Personajes/ligas ordenados por x caracteristica\nIntroduzca la caractertisica por la que quiere ordenarlos:");
					try {
						System.out.println(cs.toStringOrdenadosPorCaracteristica(Caracteristica.valueOf(sn.next())));
					} catch (IllegalArgumentException e) {
						System.err.println("No existe esa caracteristica");
					}

					break;
				case 2:
					System.out.println(menu.submenuListadoCombate());
					try {
						Competidor comp = ac.getCompetidor(sn.next().trim());
						System.out.println("Ingresa la caracteristica por la que lo queres comparar");
						Caracteristica c = Caracteristica.valueOf(sn.next());
						System.out.println(cs.getCompetidoresQuePuedeVencer(comp, c));
					} catch (NullPointerException e) {
						System.err.println("Competidor no existe");
					}
					break;
				}

			}
		} while (opcion != 5);

		sn.close();
	}

}
