/*
Diseñar un programa que lea y guarde razas de perros en un ArrayList de tipo String.
El programa pedirá una raza de perro en un bucle, el mismo se guardará en la lista y
después se le preguntará al usuario si quiere guardar otro perro o si quiere salir. Si
decide salir, se mostrará todos los perros guardados en el ArrayList.
2. Continuando el ejercicio anterior, después de mostrar los perros, al usuario se le
pedirá un perro y se recorrerá la lista con un Iterator, se buscará el perro en la lista.
Si el perro está en la lista, se eliminará el perro que ingresó el usuario y se mostrará
la lista ordenada. Si el perro no se encuentra en la lista, se le informará al usuario y
se mostrará la lista ordenada
 */
package ejercicio_0102;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        ArrayList<String> razasDePerros = new ArrayList<>();

        System.out.println("Ingrese la raza del perro: ");
        String raza = scan.next();
        razasDePerros.add(raza);  

        while (true) {
            System.out.println("Desea ingresar otra raza? y/n");
            String opcion = scan.next().toLowerCase();

            if (opcion.equals("y")) {
                System.out.println("Ingrese la raza");
                raza = scan.next();
                razasDePerros.add(raza);
                System.out.println("Se agregó " + raza + " a la lista de razas.");

            } else if (opcion.equals("n")) {
                System.out.println("Razas:");
                for (String razas : razasDePerros) {
                    System.out.println(razas);
                }

                System.out.println("Desea eliminar una raza? y/n");
                opcion = scan.next();
                System.out.println("Que raza desea eliminar? ");
                raza = scan.next();

                Iterator<String> it = razasDePerros.iterator();
                if (opcion.equals("y")) {
                    while (it.hasNext()) {
                        if (it.next().equals(raza)) {
                            it.remove();
                            System.out.println("Raza " + raza + " eliminada");
                        }
                    }
                    it = razasDePerros.iterator();
                    while (it.hasNext()) {
                        System.out.println("Lista de razas actualizada: ");
                        System.out.println(it.next() + " ");
                    }
                } else if (opcion.equals("n")) {
                    continue;
                }
                break;
            } else {
                System.out.println("Opcion invalida, ingrese 'y' para agregar otra raza o 'n' para mostrar la lista y salir.");
            }
        }
    }
}
