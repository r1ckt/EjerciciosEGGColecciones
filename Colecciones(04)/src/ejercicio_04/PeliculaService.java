package ejercicio_04;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

public class PeliculaService {

    private ArrayList<Pelicula> peliculas;
    private Scanner scan;

    public PeliculaService() {
        this.peliculas = new ArrayList<>();
        this.scan = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
    }

    public void solicitarDatos() {
        System.out.println("A continuacion ingrese los datos de la pelicula");

        System.out.println("Titulo:");
        String titulo = this.scan.next();

        System.out.println("Director:");
        String director = this.scan.next();

        System.out.println("Horas:");
        int horas = this.scan.nextInt();
        System.out.println("Minutos");
        int minutos = this.scan.nextInt();

        LocalTime duracion = LocalTime.of(horas, minutos);
        crearPelicula(titulo, director, duracion);

    }

    public void crearPelicula(String titulo, String director, LocalTime duracion) {

        Pelicula pelicula = new Pelicula();

        pelicula.setTitulo(titulo);
        pelicula.setDirector(director);
        pelicula.setDuracion(duracion);

        agregarPelicula(pelicula);
        System.out.println("La pelicula se agrego con exito a la lista!");
        System.out.println();

    }

    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
    }

    public void mostrarPeliculasMayorDeUnaHora() {
        LocalTime unaHora = LocalTime.of(1, 0);
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getDuracion().isAfter(unaHora)) {
                System.out.println(pelicula);
            }
        }
    }

    public void mostrarPeliculas() {
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula);
        }
    }

    public ArrayList<Pelicula> ordenarSegunDuracionDesc() {
        Collections.sort(peliculas, new ComparatorDuracionDesc());
        return peliculas;
    }

    public ArrayList<Pelicula> ordenarSegunDuracionAsc() {
        Collections.sort(peliculas, new ComparatorDuracionAsc());
        return peliculas;

    }

    public ArrayList<Pelicula> ordenarSegunTituloAlf() {
        Collections.sort(peliculas, new ComparatorTituloAlf());
        return peliculas;
    }

    public ArrayList<Pelicula> ordenarSegunDirectorAlf() {
        Collections.sort(peliculas, new ComparatorDirectorAlf());
        return peliculas;
    }

    public void mostrarSegunDuracionDesc(ArrayList<Pelicula> peliculas) {
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula);

        }
    }

    public void mostrarSegunDuracionAsc(ArrayList<Pelicula> peliculas) {
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula);
        }
    }

    public void mostrarSeguntTituloAlf(ArrayList<Pelicula> peliculas) {
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula);
        }
    }

    public void mostrarSegunDirectorAlf(ArrayList<Pelicula> peliculas) {
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula);
        }
    }

    public void procesamientoPrincipal() {
        String respuesta = "";

        do {
            if (this.peliculas.isEmpty()) {
                solicitarDatos();
            }

            System.out.println("Desea ingresar otra pelicula?");
            respuesta = scan.next().toUpperCase();
            switch (respuesta) {
                case "SI":
                    solicitarDatos();
                    break;
                case "NO":
                    System.out.println("Operacion finalizada.");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }

        } while (respuesta.equalsIgnoreCase("si"));
    }

    public void procesamientoSecundario() {
        int respuesta = 0;
        do {
            System.out.println("1- Mostrar todas las peliculas");
            System.out.println("2- Mostrar en pantalla todas las películas con una duración mayor a 1 hora.");
            System.out.println("3- Ordenar las películas de acuerdo a su duración (de mayor a menor) y mostrarlo en pantalla.");
            System.out.println("4- Ordenar las películas de acuerdo a su duración (de menor a mayor) y mostrarlo en pantalla.");
            System.out.println("5- Ordenar las películas por titulo, alfabéticamente y mostrarlo en pantalla.");
            System.out.println("6- Ordenar las películas por director, alfabéticamente y mostrarlo en pantalla.");
            System.out.println("7- Salir del programa");

            respuesta = this.scan.nextInt();

            switch (respuesta) {
                case 1:
                    mostrarPeliculas();
                    break;
                case 2:
                    mostrarPeliculasMayorDeUnaHora();
                    break;
                case 3:
                    mostrarSegunDuracionDesc(ordenarSegunDuracionDesc());
                    break;
                case 4:
                    mostrarSegunDuracionAsc(ordenarSegunDuracionAsc());
                    break;
                case 5:
                    mostrarSeguntTituloAlf(ordenarSegunTituloAlf());
                    break;
                case 6:
                    mostrarSegunDirectorAlf(ordenarSegunDirectorAlf());
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;

            }
        } while (respuesta != 7);
    }

}
