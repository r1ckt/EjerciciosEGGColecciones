/*
 Implemente un programa para una Librería haciendo uso de un HashSet para evitar datos
repetidos. Para ello, se debe crear una clase llamada Libro que guarde la información de
cada uno de los libros de una Biblioteca. La clase Libro debe guardar el título del libro,
autor, número de ejemplares y número de ejemplares prestados. También se creará en
el main un HashSet de tipo Libro que guardará todos los libros creados.
En el main tendremos un bucle que crea un objeto Libro pidiéndole al usuario todos sus
datos y los seteandolos en el Libro. Despues, ese Libro se guarda en el conjunto y se le
pregunta al usuario si quiere crear otro Libro o no.
La clase Librería contendrá además los siguientes métodos:

• Constructor por defecto.

• Constructor con parámetros.

• Métodos Setters/getters

• Método prestamo(): El usuario ingresa el titulo del libro que quiere prestar y se lo
busca en el conjunto. Si está en el conjunto, se llama con ese objeto Libro al método.
El método se incrementa de a uno, como un carrito de compras, el atributo
ejemplares prestados, del libro que ingresó el usuario. Esto sucederá cada vez que
se realice un préstamo del libro. No se podrán prestar libros de los que no queden
ejemplares disponibles para prestar. Devuelve true si se ha podido realizar la
operación y false en caso contrario.

• Método devolucion(): El usuario ingresa el titulo del libro que quiere devolver y se lo
busca en el conjunto. Si está en el conjunto, se llama con ese objeto al método. El
método decrementa de a uno, como un carrito de compras, el atributo ejemplares
prestados, del libro seleccionado por el usuario. Esto sucederá cada vez que se
produzca la devolución de un libro. No se podrán devolver libros donde que no
tengan ejemplares prestados. Devuelve true si se ha podido realizar la operación y
false en caso contrario.

• Método toString para mostrar los datos de los libros. 
 */
package ejercicio_extra_03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        LibreriaService libreriaService = new LibreriaService();
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
                    libreriaService.crearLibro();
                    break;
                case "2":
                    libreriaService.mostrarLibros();
                    break;
                case "3":
                    libreriaService.prestamo();
                    break;
                case "4":
                    libreriaService.devolucion();
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
