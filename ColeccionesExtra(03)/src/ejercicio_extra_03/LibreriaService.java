package ejercicio_extra_03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class LibreriaService {

    HashSet<Libreria> libros;

    public LibreriaService() {
        this.libros = new HashSet<>();
    }

    public void crearLibro() {
        Libreria libro = new Libreria();
        Scanner scan = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);

        System.out.println("A continuacion, ingrese datos del libro");
        System.out.println("Titulo: ");
        libro.setTitulo(scan.next());
        System.out.println("Autor: ");
        libro.setAutor(scan.next());
        System.out.println("Cantidad de ejemplares: ");
        libro.setCantEjemplares(scan.nextInt());
        System.out.println("Cantidad de ejemplares prestados");
        libro.setCantEjemplaresPrestados(scan.nextInt());

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

}
