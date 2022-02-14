/*
Almacena en un HashMap los códigos postales de 10 ciudades a elección de esta
página: https://mapanet.eu/index.htm. Nota: Poner el código postal sin la letra, solo el
numero.
• Pedirle al usuario que ingrese 10 códigos postales y sus ciudades.
• Muestra por pantalla los datos introducidos
• Pide un código postal y muestra la ciudad asociada si existe sino avisa al usuario.
• Muestra por pantalla los datos
• Agregar una ciudad con su código postal correspondiente más al HashMap.
• Elimina 3 ciudades existentes dentro del HashMap, que pida el usuario.
• Muestra por pantalla los datos
 */
package ejercicio_extra_04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        HashMap<Integer, String> codigosPostales = new HashMap<>();
        String respuesta = "";
        do {
            System.out.println("------MENU------");
            System.out.println("1- Ingresar diez (10) codigos postales y sus respectivas ciudades");
            System.out.println("2- Mostrar ciudad");
            System.out.println("3- Eliminar ciudad");
            System.out.println("4- Añadir ciudad");
            System.out.println("5- Mostrar todos los datos");
            System.out.println("6- Salir");
            respuesta = scan.next();
            switch (respuesta) {
                case "1":
                    for (int i = 0; i < 10; i++) {
                        System.out.println("Codigo postal °" + (i + 1));
                        int codigoPostal = scan.nextInt();
                        System.out.println("Ciudad °" + (i + 1));
                        String ciudad = scan.next();
                        codigosPostales.put(codigoPostal, ciudad);
                    }
                    break;
                case "2":
                    System.out.println("Ingrese el codigo postal de la ciudad:");
                    int codigo = scan.nextInt();
                    for (Map.Entry<Integer, String> entrada : codigosPostales.entrySet()) {
                        if (entrada.getKey() == codigo) {
                            System.out.println(entrada.getValue());
                        } else {
                            System.out.println("No se encontró una ciudad asociada con ese codigo.");
                        }
                    }
                    break;
                case "3":
                    System.out.println("Ingrese el nombre de la ciudad a eliminar: ");
                    String ciudad = scan.next();
                    boolean flag = false;
                    
                    Iterator<Entry<Integer, String>> iterator = codigosPostales.entrySet().iterator();
                    while(iterator.hasNext()){
                        Entry<Integer, String> entry = iterator.next();
                        if(entry.getValue().equalsIgnoreCase(ciudad)){
                            iterator.remove();
                            flag = true;
                        }
                    }
                    if(flag){
                        System.out.println("Se eliminó " + ciudad);
                    } else {
                        System.out.println("No se pudo eliminar " + ciudad + " ya que no existe en el conjunto.");
                    }
                    break;
                case "4":
                    System.out.println("Ingrese el codigo postal de la ciudad que desea añadir: ");
                    codigo = scan.nextInt();
                    System.out.println("Ingrese el nombre de la ciudad: ");
                    ciudad = scan.next();
                    codigosPostales.put(codigo, ciudad);
                    System.out.println(ciudad + " se agrego con éxito.");
                    break;
                case "5":
                    System.out.println("Código postal / Ciudad");
                    for (Map.Entry<Integer, String> entry : codigosPostales.entrySet()) {
                        System.out.println(entry.getKey() + " / " + entry.getValue());
                    }
                    break;
                case "6":
                    System.out.println("Saliendo...");
                    break;
                default: 
                    System.out.println("Opción Inválida.");
            }

        } while (!respuesta.equalsIgnoreCase("6"));

    }

}
