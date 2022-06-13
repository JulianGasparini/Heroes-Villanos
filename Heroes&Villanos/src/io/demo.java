package io;

import java.io.FileNotFoundException;
import java.util.Scanner;

import manejoDePersonajes.ArenaDeCombate;

public class demo {

	public static void main(String[] args) throws FileNotFoundException, LineaDePersonajeMalCreada {

		Scanner sn = new Scanner(System.in);
		Menu menu = new Menu();
		CreadorPersonajes la = new CreadorPersonajes();
		ArenaDeCombate ac = ArenaDeCombate.getInstancia();

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
					la.cargarPersonajesDesdeArchivo(sn.next());
					break;
				case 2:
					System.out.println("Seleccionaste: creaci�n\n");
					System.out.println("Introduci la linea con los datos de tu personaje en el siguiente orden: \n");
					System.out.println(
							"1- Heroe/Villano\n2-Nombre real\n3-Nombre de personaje\n4-Su velocidad\n5-Su fuerza\n6-Su resistencia\n7-Su destreza");
					String[] pj = new String[7];
					for (int i = 0; i < pj.length; i++) {
						pj[i] = sn.next();
					}

					la.crearPersonaje(pj);

						break;
				case 3:
					System.out.println("Seleccionaste: Listado\n");
					System.out.println(ac.toString());
					break;
				case 4:
					System.out.println("Seleccionaste: Guardar en archivo todos los personajes\n");
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
					break;
				case 2:
					System.out.println("Seleccionaste: creaci�n\n");
					break;
				case 3:
					System.out.println("Seleccionaste: Listado\n");
					break;
				case 4:
					System.out.println("Seleccionaste: Guardar en archivo todos las ligas\n");
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
					System.out.println("Seleccionaste: Personajes/ligas ordenados por x caracteristica\n");
					break;
				case 2:
					System.out.println("Personajes ligas que venzan a x personajes\n");
					break;
				}

			}
		} while (opcion != 5);

		sn.close();
	}

}
