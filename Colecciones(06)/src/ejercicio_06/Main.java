/*
Se necesita una aplicación para una tienda en la cual queremos almacenar los
distintos productos que venderemos y el precio que tendrán. Además, se necesita
que la aplicación cuente con las funciones básicas.
Estas las realizaremos en el main. Como, introducir un elemento, modificar su precio,
eliminar un producto y mostrar los productos que tenemos con su precio (Utilizar
Hashmap). El HashMap tendrá de llave el nombre del producto y de valor el precio.
Realizar un menú para lograr todas las acciones previamente mencionadas
 */
package ejercicio_06;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        HashMap<String, Double> tienda = new HashMap<>();
        String respuesta = "";

        do {
            System.out.println("Ingrese el nombre del producto:");
            String producto = scan.next();
            System.out.println("Ingrese el precio del producto:");
            Double precio = scan.nextDouble();

            tienda.put(producto, precio);
            System.out.println(producto + " se añadio con exito a la tienda.");

            System.out.println("Desea ingresar otro producto? Si/No");
            respuesta = scan.next();
        } while (respuesta.equalsIgnoreCase("si"));

        do {
            System.out.println("-------MENU-------");
            System.out.println("1-Mostrar productos");
            System.out.println("2-Añadir producto");
            System.out.println("3-Modificar precio de un producto");
            System.out.println("4-Eliminar producto");
            System.out.println("5-Salir");
            respuesta = scan.next();

            switch (respuesta) {
                case "1":
                    System.out.println();
                    System.out.println("Lista de productos: ");
                    for (Map.Entry<String, Double> entry : tienda.entrySet()) {
                        System.out.println(entry.getKey() + "  $" + entry.getValue());
                    }
                    System.out.println();
                    break;
                case "2":
                    System.out.println();
                    System.out.println("Ingrese el nombre del producto:");
                    String producto = scan.next();
                    System.out.println("Ingrese el precio del producto:");
                    Double precio = scan.nextDouble();

                    tienda.put(producto, precio);

                    System.out.println("El producto " + producto + " se añadio con exito.");
                    System.out.println();
                    break;
                case "3":
                    System.out.println();
                    System.out.println("Ingrese el nombre del producto: ");
                    producto = scan.next();
                    System.out.println("Ingrese el precio: ");
                    precio = scan.nextDouble();
                    boolean flag = false;

                    for (Map.Entry<String, Double> entry : tienda.entrySet()) {
                        if (entry.getKey().equals(producto)) {
                            entry.setValue(precio);
                            flag = true;
                        }
                    }
                    if (flag) {
                        System.out.println("Se modifico el precio de " + producto + " a " + "$" + precio);
                    } else {
                        System.out.println("No se pudo modificar el precio de " + producto);
                    }
                    System.out.println();
                    break;
                case "4":
                    System.out.println();
                    System.out.println("Ingrese el nombre del producto a eliminar: ");
                    producto = scan.next();
                    flag = false;

                    for (String key : tienda.keySet()) {
                        if (key.equals(producto)) {
                            tienda.remove(producto);
                            flag = true;
                        }
                    }
                    if (flag) {
                        System.out.println(producto + " se elimino exitosamente.");
                    } else {
                        System.out.println("Error, " + producto + " no existe en la tienda.");
                    }
                    System.out.println();
                    break;
                case "5":
                    System.out.println("Saliendo...");
                    System.out.println();
                    break;
                default:
                    System.out.println("Opción invalida.");
                    System.out.println();
            }
        } while (!respuesta.equals("5"));
    }

}
