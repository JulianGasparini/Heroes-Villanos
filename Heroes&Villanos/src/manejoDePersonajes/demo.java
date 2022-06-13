package manejoDePersonajes;

public class demo {

	public static void main(String[] args) {

		Competidor c1 = new Personaje(Tipo.Heroe, "Bruce Wayne", "Batman", 400, 600, 800, 600);
		Competidor c2 = new Personaje(Tipo.Heroe, "Clark Kent", "Superman", 900, 800, 800, 700);
		Competidor c3 = new Personaje(Tipo.Heroe, "Selina Kyle", "Catwoman", 700, 300, 400, 900);
		Liga l1 = new Liga(Tipo.Heroe, "Justice League");
		Liga l2 = new Liga(Tipo.Heroe, "Supers");
		l1.agregarCompetidor(c1);
		l1.agregarCompetidor(c2);
		l2.agregarCompetidor(c3);
		l1.agregarCompetidor(l2);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println("///////////////");
		l1.obtenerListaCompetidores();
		l2.obtenerListaCompetidores();
		System.out.println("///////////////");
		System.out.println(l1.obtenerCaracteristica(Caracteristica.VELOCIDAD));
		System.out.println(l1.obtenerCaracteristica(Caracteristica.FUERZA));
		System.out.println(l1.obtenerCaracteristica(Caracteristica.RESISTENCIA));
		System.out.println(l1.obtenerCaracteristica(Caracteristica.DESTREZA));
	}

}
