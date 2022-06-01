package io;

import java.util.Scanner;

public class demo {

	public static void main(String[] args) {

		Scanner sn = new Scanner(System.in);
		Menu menu = new Menu();

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
					break;
				case 2:
					System.out.println("Seleccionaste: creación\n");
					break;
				case 3:
					System.out.println("Seleccionaste: Listado\n");
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
					System.out.println("Seleccionaste: creación\n");
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
