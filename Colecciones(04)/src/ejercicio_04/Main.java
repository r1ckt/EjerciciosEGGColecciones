/*
Un cine necesita implementar un sistema en el que se puedan cargar peliculas. Para
esto, tendremos una clase Pelicula con el titulo, director y duración de la película (en
horas). Implemente las clases y métodos necesarios para esta situación, teniendo en
cuenta lo que se pide a continuación:19
En el main deberemos tener un bucle que crea un objeto Pelicula pidiéndole al
usuario todos sus datos y guardándolos en el objeto Pelicula.
Después, esa Pelicula se guarda una lista de Peliculas y se le pregunta al usuario si
quiere crear otra Pelicula o no.

Después de ese bucle realizaremos las siguientes acciones:

• Mostrar en pantalla todas las películas.

• Mostrar en pantalla todas las películas con una duración mayor a 1 hora.

• Ordenar las películas de acuerdo a su duración (de mayor a menor) y mostrarlo
en pantalla.

• Ordenar las películas de acuerdo a su duración (de menor a mayor) y mostrarlo
en pantalla.

• Ordenar las películas por titulo, alfabéticamente y mostrarlo en pantalla.

• Ordenar las películas por director, alfabéticamente y mostrarlo en pantalla.

 */
package ejercicio_04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        String respuesta = "";

        do {
            Pelicula pelicula = new Pelicula();

            System.out.println("A continuacion ingrese los datos de la pelicula");

            System.out.println("Nombre:");
            String nombre = scan.next();
            pelicula.setTitulo(nombre);

            System.out.println("Director:");
            String director = scan.next();
            pelicula.setDirector(director);

            System.out.println("Duración:");
            double duracion = scan.nextDouble();
            pelicula.setDuracion(duracion);

            peliculas.add(pelicula);
            System.out.println("La pelicula se agrego con exito a la lista!");

            System.out.println();
            System.out.println("Desea ingresar otra pelicula? si/no ");
            respuesta = scan.next();

        } while (respuesta.equalsIgnoreCase("si"));
        
        do{

        System.out.println("----- MENU -----");
        System.out.println("1- Mostrar todas las peliculas");
        System.out.println("2- Mostrar peliculas con una duracion mayor a 1 hora");
        System.out.println("3- Mostrar peliculas ordenadas de acuerdo a su duracion (mayor a menor)");
        System.out.println("4- Mostrar peliculas ordenadas alfabeticamente por titulo");
        System.out.println("5- Mostrar peliculas ordenadas alfabeticamente por director");
            System.out.println("6- Salir");

        respuesta = scan.next();
        switch (respuesta) {
            case "1":
                for (Pelicula pelicula : peliculas) {
                    System.out.println(pelicula);
                }
                break;
            case "2": 
                for (int i = 0; i < peliculas.size(); i++) {
                    if(peliculas.get(i).getDuracion() > 1){
                        System.out.println(peliculas.get(i));
                    }
                }
                break;
            case "3": 
                Collections.sort(peliculas, Pelicula.ordenarSegunDuracionDesc);
                for(int i = 0; i < peliculas.size(); i++){
                    System.out.println(peliculas.get(i));
                }
                break;
            case "4":
                Collections.sort(peliculas, Pelicula.ordenarSegunTituloAlf);
                for(int i = 0; i < peliculas.size(); i++){
                    System.out.println(peliculas.get(i));
                }
                break;
            case "5": 
                Collections.sort(peliculas, Pelicula.ordenarSegunDirectorAlf);
                for(int i = 0; i < peliculas.size(); i++){
                    System.out.println(peliculas.get(i));
                }
                break;
            case "6":
                System.out.println("Saliendo...");
                break;
            default: 
                System.out.println("Opcion invalida.");
        }
        } while(!respuesta.equals("6"));
    }

}
