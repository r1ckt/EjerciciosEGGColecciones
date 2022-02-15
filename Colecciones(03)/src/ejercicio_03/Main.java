/*
Crear una clase llamada Alumno que mantenga información sobre las notas de
distintos alumnos. La clase Alumno tendrá como atributos, su nombre y una lista de
tipo Integer con sus 3 notas.
En el main deberemos tener un bucle que crea un objeto Alumno. Se pide toda la
información al usuario y ese Alumno se guarda en una lista de tipo Alumno y se le
pregunta al usuario si quiere crear otro Alumno o no.
Después de ese bluce tendremos el siguiente método en la clase Alumno:
Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su
nota final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método.
Dentro del método se usará la lista notas para calcular el promedio final de alumno.
Siendo este promedio final, devuelto por el método y mostrado en el main
 */
package ejercicio_03;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        AlumnoService alumnoService = new AlumnoService();
        String respuesta = "";
        
        do {
            System.out.println("A continuacion, ingrese datos del alumno");
            alumnoService.crearAlumno();
            System.out.println("Desea agregar otro alumno? Si/No");
            respuesta = scan.next();
        } while (respuesta.equalsIgnoreCase("si"));

        do {
            System.out.println("1- Ver las notas de un alumno");
            System.out.println("2- Ver el promedio general de un alumno");
            System.out.println("3- Salir");
            respuesta = scan.next();

            switch (respuesta) {
                case "1":
                    System.out.println("Ingrese el nombre del alumno: ");
                    alumnoService.imprimirNotas(scan.next());
                    break;
                case "2":
                    System.out.println("Ingrese el nombre del alumno: ");
                    alumnoService.calcularNotaFinal(scan.next());
                    break;
                case "3":
                    System.out.println("Cerrando el programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (!respuesta.equalsIgnoreCase("3"));

    }
}
