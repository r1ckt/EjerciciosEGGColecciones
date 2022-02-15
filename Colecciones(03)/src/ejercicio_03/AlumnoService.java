package ejercicio_03;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class AlumnoService {
    
    private ArrayList<Alumno> alumnos;
    
    public AlumnoService(){
        this.alumnos = new ArrayList<>();
    }
    
    public void crearAlumno(){
        Scanner scan = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        Alumno alumno = new Alumno();
        
        System.out.println("Nombre del alumno: ");
        alumno.setNombre(scan.next());
        System.out.println("Primer nota:");
        alumno.setNota1(scan.nextInt());
        System.out.println("Segunda nota: ");
        alumno.setNota2(scan.nextInt());
        System.out.println("Tercer nota: ");
        alumno.setNota3(scan.nextInt());
        
        agregarAlumno(alumno);
        System.out.println("Se agrego el alumno con éxito.");
        
    }
    public void agregarAlumno(Alumno alumno){
        alumnos.add(alumno);
    }
    
    public void imprimirNotas(String nombre){
        boolean flag = false;
        for (Alumno alumno : alumnos) {
            if(alumno.getNombre().equalsIgnoreCase(nombre)){
            System.out.printf("Nombre: %s \n" , alumno.getNombre());
            System.out.printf("Nota 1: %d \n" , alumno.getNota1());
            System.out.printf("Nota 2: %d \n" , alumno.getNota2());
            System.out.printf("Nota 3: %d \n" , alumno.getNota3());
            flag = true;
            }
        }
        if(!flag){
            System.out.println("No se encontraron datos de " + nombre);
        }
    }
    
    public void calcularNotaFinal(String nombre){
        int sum = 0;
        for (Alumno alumno : alumnos) {
             if(alumno.getNombre().equalsIgnoreCase(nombre)){
             sum = alumno.getNota1() + alumno.getNota3() + alumno.getNota2();    
             }
        }
        System.out.printf("Promedio general de %s: %.2f\n", nombre ,1.0 * sum/3 ); ;
    }
    
    public void imprimirAlumnos(){
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }
    }
    
}
