/*
Crear una clase llamada CantanteFamoso. Esta clase guardará cantantes famosos y
tendrá como atributos el nombre y discoConMasVentas.
Se debe, además, en el main, crear una lista de tipo CantanteFamoso y agregar
objetos de tipo CantanteFamoso a la lista. Luego, se debe mostrar los nombres de cada
cantante y su disco con más ventas por pantalla.
Una vez agregado, en otro bucle, crear un menú que le de la opción al usuario de
agregar un cantante más, mostrar todos los cantantes, eliminar un cantante que el
usuario elija o de salir del programa. Al final se deberá mostrar la lista con todos los
cambios.
 */
package ejercicio_extra_02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
    private static ArrayList<CantanteFamoso> cantantes = new ArrayList<>();

    public static void main(String[] args) {

        procesamientoPrincipal();
        procesamientoSecundario();

    }

    public static void solicitarDatos() {
        System.out.println("Ingrese el nombre del cantante: ");
        String nombre = scan.next();
        System.out.println("Ingrese el disco mas vendido:");
        String discoMasVendido = scan.next();

        crearCantanteFamoso(nombre, discoMasVendido);

    }

    public static void crearCantanteFamoso(String nombre, String discoConMasVentas) {
        CantanteFamoso cantante = new CantanteFamoso();

        cantante.setNombre(nombre);
        cantante.setDiscoConMasVentas(discoConMasVentas);

        agregarCantante(cantante);
        System.out.println(cantante.getNombre() + " se añadió con éxito a la lista.");
    }

    public static void agregarCantante(CantanteFamoso cantante) {
        cantantes.add(cantante);
    }

    public static CantanteFamoso buscarCantante(String nombre) {
        CantanteFamoso cantanteRetorno = null;

        for (CantanteFamoso cantante : cantantes) {
            if (cantante.getNombre().equalsIgnoreCase(nombre)) {
                return cantante;
            }
        }

        return cantanteRetorno;
    }

    public static void eliminarCantante(CantanteFamoso cantante) {
        Iterator<CantanteFamoso> it = cantantes.iterator();
        boolean flag = false;
        while (it.hasNext()) {
            if (it.next().getNombre().equalsIgnoreCase(cantante.getNombre())) {
                it.remove();
                flag = true;
            }
        }
        if (flag) {
            System.out.println(cantante.getNombre() + " fue eliminado de la lista de cantantes.");
        } else {
            System.out.println(cantante.getNombre() + " no existe en la lista.");
        }
    }

    public static void mostrarCantante(CantanteFamoso cantante) {
        System.out.println(cantante);
    }

    public static void mostrarTodosLosCantantes() {
        System.out.println("Lista de cantantes");
        for (CantanteFamoso cantante : cantantes) {
            System.out.println(cantante);
        }
    }

    public static void procesamientoPrincipal() {
        String respuesta = "";

        do {
            if (cantantes.isEmpty()) {
                solicitarDatos();
            } else {
                System.out.println("Desea ingresar otro cantante? SI/NO");
                respuesta = scan.next().toUpperCase();
                switch (respuesta) {
                    case "SI":
                        solicitarDatos();
                        break;
                    case "NO":
                        System.out.println("Proceso finalizado");
                }

            }
        } while (!respuesta.equalsIgnoreCase("no"));
    }

    public static void procesamientoSecundario() {
        int opcion = 0;
        do {
            System.out.println("1- Añadir un cantante más");
            System.out.println("2- Mostrar cantante");
            System.out.println("3- Eliminar cantante");
            System.out.println("4- Mostrar todos los cantantes");
            System.out.println("5- Salir");
            opcion = scan.nextInt();

            switch (opcion) {
                case 1:
                    solicitarDatos();
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del cantante:");
                    String nombre = scan.next();
                    mostrarCantante(buscarCantante(nombre));
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del cantante:");
                    nombre = scan.next();
                    eliminarCantante(buscarCantante(nombre));
                    break;
                case 4:
                    mostrarTodosLosCantantes();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
            }

        } while (opcion != 5);
    }
}
