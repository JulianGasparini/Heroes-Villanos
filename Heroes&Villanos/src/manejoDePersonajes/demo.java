package manejoDePersonajes;

public class demo {

	public static void main(String[] args) {

		Competidor c1 = new Personaje(Tipo.HEROE, "Bruce Wayne", "Batman", 400, 600, 800, 600);
		Competidor c2 = new Personaje(Tipo.HEROE, "Clark Kent", "Superman", 900, 800, 800, 700);
		Competidor c3 = new Personaje(Tipo.HEROE, "Selina Kyle", "Catwoman", 700, 300, 400, 900);
		Liga l1 = new Liga(Tipo.HEROE, "Justice League");
		Liga l2 = new Liga(Tipo.HEROE, "Supers");
		l1.agregarPersonaje(c1);
		l1.agregarPersonaje(c2);
		l2.agregarPersonaje(c3);
		l1.agregarPersonaje(l2);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println("///////////////");
		l1.obtenerCompetidor();
		l2.obtenerCompetidor();
		System.out.println("///////////////");
		System.out.println(l1.obtenerCaracteristica(Caracteristica.VELOCIDAD));
		System.out.println(l1.obtenerCaracteristica(Caracteristica.FUERZA));
		System.out.println(l1.obtenerCaracteristica(Caracteristica.RESISTENCIA));
		System.out.println(l1.obtenerCaracteristica(Caracteristica.DESTREZA));
	}

}
