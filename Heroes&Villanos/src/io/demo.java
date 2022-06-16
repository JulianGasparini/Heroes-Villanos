package io;

import java.io.FileNotFoundException;
import java.util.Scanner;

import manejoDePersonajes.ArenaDeCombate;
import manejoDePersonajes.Caracteristica;

public class demo {

	public static void main(String[] args) {

		Scanner sn = new Scanner(System.in);
		Menu menu = new Menu();
		CreadorPersonajes la = new CreadorPersonajes();
		ArenaDeCombate ac = ArenaDeCombate.getInstancia();
		Escritor es = new Escritor();
		CreadorLigas cl = new CreadorLigas();

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
					System.out.println("Seleccionaste: carga desde archivo\n");
					System.out.println("Introduci el nombre del archivo que queres cargar\n");
					try {
						la.cargarPersonajesDesdeArchivo(sn.next());
					} catch (FileNotFoundException e) {
						System.err.println("No se encontro el archivo");
					} catch (LineaDePersonajeMalCreada e) {
						System.err.println("Una linea de personaje se encontró mal formada");
					} catch (IllegalArgumentException e) {
						System.err.println("La linea esta mal formada o no pertenece a una linea de personaje");
					}
					break;
				case 2:
					System.out.println("Seleccionaste: creación\n");
					System.out.println("Introduci la linea con los datos de tu personaje en el siguiente orden: \n");
					System.out.println(
							"1- Heroe/Villano\n2-Nombre real\n3-Nombre de personaje\n4-Su velocidad\n5-Su fuerza\n6-Su resistencia\n7-Su destreza");
					String[] pj = new String[7];
					for (int i = 0; i < pj.length; i++) {
						pj[i] = sn.next();
					}
					try {
						la.crearPersonaje(pj);
					} catch (LineaDePersonajeMalCreada e) {
						System.err.println("Datos introducidos incorrectamente");
					}

					break;
				case 3:
					System.out.println("Seleccionaste: Listado\n");
					System.out.println(ac.toStringPersonajes());
					break;
				case 4:
					System.out.println("Seleccionaste: Guardar en archivo todos los personajes\n");
					System.out.println(
							"Introduci el nombre del archivo donde se van a guardar los personajes (sin .txt): ");
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
					System.out.println("Seleccionaste: carga desde archivo\n");
					System.out.println("Introduci el nombre del archivo que queres cargar\n");
					try {
						cl.cargarLigaDesdeArchivo(sn.next());
					} catch (FileNotFoundException e) {
						System.err.println("No se encontro el archivo");
					} catch (LigaNoPudoCrearseCorrectamente e) {
						System.err.println("Una liga no pudo crearse, los datos eran incorrectos");
					}
					break;
				case 2:
					System.out.println("Seleccionaste: creación\n");
					System.out.println("Introduci el nombre de la liga a crear");
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
						cl.cargarLigaAMemoria(liga.split(","));
					} catch (LigaNoPudoCrearseCorrectamente e) {
						System.err.println("La liga no puedo crearse, datos incorrectos");
					}
					break;
				case 3:
					System.out.println("Seleccionaste: Listado\n");
					System.out.println(ac.toStringLigas());
					break;
				case 4:
					System.out.println("Seleccionaste: Guardar en archivo todos las ligas\n");
					System.out.println(
							"Introduci el nombre del archivo donde se van a guardar las ligas (sin .txt): ");
					es.escribirLigasEnArchivo(sn.next());
					break;

				}

				break;
			case 3:

				int op3;
				System.out.println(menu.realizacionCombates());
				op3 = sn.nextInt();

				switch (op3) {

				case 1:
					System.out.println("Seleccionaste: personaje contra liga\n");
					break;
				case 2:
					System.out.println("Seleccionaste: liga contra liga\n");
					break;
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
						System.out.println(ac.toStringOrdenados(Caracteristica.valueOf(sn.next())));
					} catch (Exception e) {
						System.err.println("No existe esa caracteristica");
					}

					break;
				case 2:
					System.out.println("Personajes ligas que venzan a x personajes o liga\n");
					break;
				}

			}
		} while (opcion != 5);

		sn.close();
	}

}
