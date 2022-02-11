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

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        ArrayList<Alumno> alumnos = new ArrayList<>();
        Alumno alumno = new Alumno();

        while (true) {
            System.out.println("Ingrese el nombre del alumno: ");
            alumno.setNombre(scan.next());

            System.out.println("Ingrese la primer nota: ");
            alumno.cargarNota(scan.nextInt());

            System.out.println("Ingrese la segunda nota: ");
            alumno.cargarNota(scan.nextInt());

            System.out.println("Ingrese la tercer nota: ");
            alumno.cargarNota(scan.nextInt());

            alumnos.add(alumno);

            System.out.println("Desea crear otro alumno? Si/No");
            String opcion = scan.next().toLowerCase();

            if (opcion.equals("no")) {
                break;
            } else if (opcion.equals("si")) {
                continue;
            }

        }
        
        System.out.println();
        System.out.println("Ingrese el nombre de un alumno para calcular su promedio: ");
        
        String nombreAlumno = scan.next();
        boolean flag = false;
        for (Alumno alumno1 : alumnos) {
            if (alumno.getNombre().equals(nombreAlumno)) {
                flag = true;
            }
        }
        if (flag) {
            alumno.notaFinal(nombreAlumno);
        }

    }
}
