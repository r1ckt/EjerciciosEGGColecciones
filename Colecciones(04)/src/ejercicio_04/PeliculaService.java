package ejercicio_04;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class PeliculaService {

    ArrayList<Pelicula> peliculas;

    public PeliculaService() {
        this.peliculas = new ArrayList<>();
    }

    public void agregarPelicula() {
        Scanner scan = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);

        Pelicula pelicula = new Pelicula();

        System.out.println("A continuacion ingrese los datos de la pelicula");

        System.out.println("Titulo:");
        pelicula.setTitulo(scan.next());

        System.out.println("Director:");
        pelicula.setDirector(scan.next());

        System.out.println("Duración");
        System.out.println("Horas:");
        int horas = scan.nextInt();
        System.out.println("Minutos");
        int minutos = scan.nextInt();
        
        LocalTime duracion = LocalTime.of(horas, minutos);
        pelicula.setDuracion(duracion);

        agregarPelicula(pelicula);
        System.out.println("La pelicula se agrego con exito a la lista!");

    }

    public void mayorDeUnaHora() {
        LocalTime unaHora = LocalTime.of(1, 0);
        for (Pelicula peli : peliculas) {
            if (peli.getDuracion().isAfter(unaHora)) {
                System.out.println(peli);
            }
        }
    }

    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
    }
    
    public void mostrarPeliculas(){
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula);
        }
    }

}
