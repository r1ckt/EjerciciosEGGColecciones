package ejercicio_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class AlumnoService {

    private ArrayList<Alumno> alumnos;
    private Scanner scan;

    public AlumnoService() {
        this.alumnos = new ArrayList<>();
        this.scan = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
    }

    public void solicitarDatos() {
        ArrayList<Integer> notas = new ArrayList<>();

        System.out.println("Nombre del alumno: ");
        String nombre = this.scan.next();
        System.out.println("Primer nota:");
        int nota1 = this.scan.nextInt();
        System.out.println("Segunda nota: ");
        int nota2 = this.scan.nextInt();
        System.out.println("Tercer nota: ");
        int nota3 = this.scan.nextInt();

        notas.add(nota1);
        notas.add(nota2);
        notas.add(nota3);

        crearAlumno(nombre, notas);
    }

    public void crearAlumno(String nombre, ArrayList<Integer> notas) {
        Alumno alumno = new Alumno();

        alumno.setNombre(nombre);
        alumno.setNotas(notas);

        agregarAlumno(alumno);
        System.out.println("Se agrego el alumno con éxito.");

    }

    public void agregarAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    public Alumno buscarAlumno(String nombre) {
        Alumno alumnoReturn = null;

        for (Alumno alumno : this.alumnos) {
            if (alumno.getNombre().equalsIgnoreCase(nombre)) {
                return alumno;
            }
        }
        return alumnoReturn;
    }

    public double calcularNotaFinal(Alumno alumno) {
        int sum = 0;
        Iterator<Integer> iterator = alumno.getNotas().iterator();
        while (iterator.hasNext()) {
            Integer nota = iterator.next();
            sum += nota;
        }
        return (double) sum / 3;
    }

    public void procesamientoPrincipal() {
        String respuesta = "";
        do {
            if (this.alumnos.isEmpty()) {
                solicitarDatos();
            } else {
                System.out.println("Desea ingresar otro alumno? Si/No");
                respuesta = this.scan.next().toUpperCase();

                switch (respuesta) {
                    case "SI":
                        solicitarDatos();
                        break;
                    case "NO":
                        System.out.println("Operacion finalizada.");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                        break;
                }
            }
        } while (!respuesta.equalsIgnoreCase("NO"));
    }

    public void procesamientoSecundario() {
        System.out.println("Ingrese el nombre del alumno que desea hallar: ");
        String nombre = this.scan.next();
        Alumno alumno = buscarAlumno(nombre);

        if (alumno != null) {
            System.out.printf("%.2f\n", calcularNotaFinal(alumno));
        } else {
            System.out.println("No se encontro alumno con ese nombre.");
        }
    }
}
