package ejercicio_extra_03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class LibreriaService {

    HashSet<Libreria> libros;
    Scanner scan;

    public LibreriaService() {
        this.libros = new HashSet<>();
        this.scan = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);

    }

    public void ingresarDatos() {
        Scanner scan = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);

        System.out.println("A continuacion, ingrese datos del libro");
        System.out.println("Titulo: ");
        String titulo = this.scan.next();
        System.out.println("Autor: ");
        String autor = this.scan.next();
        System.out.println("Cantidad de ejemplares: ");
        int ejemplares = this.scan.nextInt();
        System.out.println("Cantidad de ejemplares prestados");
        int prestados = this.scan.nextInt();
        
        crearLibro(titulo, autor, ejemplares, prestados);
    }

    public void crearLibro(String titulo, String autor, int ejemplares, int prestados) {
        Libreria libro = new Libreria();

        libro.setTitulo(titulo);
        libro.setAutor(autor);
        libro.setCantEjemplares(ejemplares);
        libro.setCantEjemplaresPrestados(prestados);
        
        agregarLibro(libro);
        System.out.println("El libro se añadio con exito.");

    }

    public void agregarLibro(Libreria libro) {
        libros.add(libro);
    }

    public void mostrarLibros() {
        Iterator<Libreria> it = libros.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public boolean prestamo() {
        Scanner scan = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);

        System.out.println("Ingrese el título del libro que desea prestar: ");
        String tituloLibro = scan.next();

        boolean flag = false;
        for (Libreria valor : libros) {

            if (tituloLibro.equalsIgnoreCase(valor.getTitulo())) {
                int prestado = valor.getCantEjemplaresPrestados();

                if (valor.getCantEjemplares() > valor.getCantEjemplaresPrestados()) {
                    prestado++;
                    valor.setCantEjemplaresPrestados(prestado);
                    System.out.println("Se presto el libro: " + tituloLibro + ".");
                    flag = true;

                } else {
                    System.out.println("Disculpas, en estos momento " + tituloLibro + " no esta disponible.");
                    flag = false;
                }

            } else {
                System.out.println(tituloLibro + " no se encuentra disponible en la libreria.");
                flag = false;
            }
        }
        return flag;
    }

    public boolean devolucion() {
        Scanner scan = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);

        System.out.println("Ingrese el título del libro que desea devolver: ");
        String tituloLibro = scan.next();

        boolean flag = false;
        for (Libreria valor : libros) {

            if (tituloLibro.equals(valor.getTitulo())) {
                int prestado = valor.getCantEjemplaresPrestados();

                if (valor.getCantEjemplaresPrestados() > 0) {
                    prestado--;
                    valor.setCantEjemplaresPrestados(prestado);
                    System.out.println("Se devolvio " + tituloLibro + " a la librería.");
                    flag = true;
                } else {
                    System.out.println("No se registraron prestamos de " + tituloLibro);
                    flag = false;
                }

            } else {
                System.out.println(tituloLibro + " no pertenece a la librería.");
                flag = false;
            }

        }

        return flag;

    }
    public void procesamientoPrincipal(){
        String respuesta = "";

        do {
            
            System.out.println("1- Agregar libro");
            System.out.println("2- Mostrar libros");
            System.out.println("3- Prestar libro");
            System.out.println("4- Devolver libro");
            System.out.println("5- Salir");

            respuesta = scan.next();
            switch (respuesta) {
                case "1":
                    ingresarDatos();
                    break;
                case "2":
                    mostrarLibros();
                    break;
                case "3":
                    prestamo();
                    break;
                case "4":
                    devolucion();
                    break;
                case "5":
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción invalida.");
            }

        } while (!respuesta.equalsIgnoreCase("5"));

    }

}
