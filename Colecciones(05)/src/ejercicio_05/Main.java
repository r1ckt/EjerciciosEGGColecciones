/*
Se requiere un programa que lea y guarde países, y para evitar que se ingresen
repetidos usaremos un conjunto. El programa pedirá un país en un bucle, se
guardará el país en el conjunto y después se le preguntará al usuario si quiere
guardar otro país o si quiere salir, si decide salir, se mostrará todos los países
guardados en el conjunto.

Después deberemos mostrar el conjunto ordenado alfabéticamente para esto
recordar como se ordena un conjunto.

Y por ultimo, al usuario se le pedirá un país y se recorrerá el conjunto con un Iterator,
se buscará el país en el conjunto y si está en el conjunto se eliminará el país que
ingresó el usuario y se mostrará el conjunto. Si el país no se encuentra en el conjunto
se le informará al usuario.
 */
package ejercicio_05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        HashSet<String> paises = new HashSet<>();
        String respuesta = "";

        do {
            System.out.println("Ingrese el nombre de un pais: ");
            String pais = scan.next();
            paises.add(pais);
            System.out.println(pais + " se agrego al conjunto de paises.");

            System.out.println();
            System.out.println("Desea ingresar otro pais? Si/No");
            respuesta = scan.next();
        } while (respuesta.equalsIgnoreCase("si"));

        do {
            System.out.println("----- MENU -----");
            System.out.println("1- Mostrar paises");
            System.out.println("2- Ordenar paises alfabeticamente");
            System.out.println("3- Eliminar pais");
            System.out.println("4- Salir");
            respuesta = scan.next();

            switch (respuesta) {
                case "1":
                    Iterator<String> it = paises.iterator();
                    while (it.hasNext()) {
                        System.out.println(it.next());
                    }
                    System.out.println();
                    break;
                case "2":
                    ArrayList<String> paisesLista = new ArrayList(paises);
                    Collections.sort(paisesLista);
                    Iterator<String> itLista = paisesLista.iterator();
                    while (itLista.hasNext()) {
                        System.out.println(itLista.next());
                    }
                    System.out.println();
                    break;
                case "3":
                    System.out.println("Ingrese el pais a eliminar: ");
                    String eliminarPais = scan.next();
                    boolean flag = false;
                    Iterator<String> itEliminar = paises.iterator();
                    while (itEliminar.hasNext()) {
                        if (itEliminar.next().equals(eliminarPais)) {
                            itEliminar.remove();
                            flag = true;
                        }
                    }
                    if(flag){
                        System.out.println(eliminarPais + " fue eliminado con exito.");
                    } else {
                        System.out.println("El pais no se encuentra en el conjunto.");
                    }
                    System.out.println();
                    break;
                case "4":
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
                    System.out.println();
            }
        } while (!respuesta.equals("4"));

    }

}
