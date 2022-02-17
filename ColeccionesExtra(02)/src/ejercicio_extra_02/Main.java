/*
Crear una clase llamada CantanteFamoso. Esta clase guardará cantantes famosos y
tendrá como atributos el nombre y discoConMasVentas.
Se debe, además, en el main, crear una lista de tipo CantanteFamoso y agregar 5
objetos de tipo CantanteFamoso a la lista. Luego, se debe mostrar los nombres de cada
cantante y su disco con más ventas por pantalla.
Una vez agregado los 5, en otro bucle, crear un menú que le de la opción al usuario de
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

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);

        ArrayList<CantanteFamoso> cantantes = new ArrayList<>();
        int count = 0;

        while (count < 5) {
            CantanteFamoso cantante = new CantanteFamoso();
            System.out.println("Ingrese el nombre artístico del cantante: ");
            String nombre = scan.next();
            System.out.println("Ingrese el disco mas vendido del cantante: ");
            String disco = scan.next();

            cantante.setNombre(nombre);
            cantante.setDiscoConMasVentas(disco);

            cantantes.add(cantante);

            count++;
        }
        System.out.println("Mostrando datos ingresados");
        Iterator<CantanteFamoso> it = cantantes.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("");

        int opcion = 0;
        do {
            CantanteFamoso cantante = new CantanteFamoso();

            System.out.println("1 - Añadir cantante");
            System.out.println("2 - Mostrar todos los cantantes");
            System.out.println("3 - Eliminar cantante");
            System.out.println("4 - Salir del programa");
            opcion = scan.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre artístico del cantante: ");
                    String nombre = scan.next();
                    System.out.println("Ingrese el disco mas vendido del cantante: ");
                    String disco = scan.next();

                    cantante.setNombre(nombre);
                    cantante.setDiscoConMasVentas(disco);

                    cantantes.add(cantante);
                    System.out.println("Se añadio " + nombre + " con exito.");
                    break;
                case 2:
                    Iterator<CantanteFamoso> itMostrar = cantantes.iterator();
                    while (itMostrar.hasNext()) {
                        System.out.println(it.next());
                    }
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("Que cantante desea eliminar?");
                    nombre = scan.next();
                    boolean flag = false;
                    Iterator<CantanteFamoso> itEliminar = cantantes.iterator();
                    while (itEliminar.hasNext()) {
                        if(nombre.equalsIgnoreCase(itEliminar.next().getNombre())){
                            itEliminar.remove();
                            flag = true;
                        }
                    }
                    if(flag){
                        System.out.println("Se elimino " + nombre);
                    } else {
                        System.out.println("No se puedo eliminar " + nombre + " porque no existe en el conjunto.");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);
    }
}
