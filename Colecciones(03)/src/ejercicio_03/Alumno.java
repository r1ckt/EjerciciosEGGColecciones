package ejercicio_03;

import java.util.ArrayList;

public class Alumno {
    private String nombre;
    private ArrayList<Integer> notas = new ArrayList<>();;

    public Alumno() {
        notas = new ArrayList<>();
    }

    public Alumno(String nombre, ArrayList<Integer> notas) {
        this.nombre = nombre;
        this.notas = notas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Integer> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Integer> notas) {
        this.notas = notas;
    }
    
    public void cargarNota(int nota){
        notas.add(nota);
    }
    
    public void notaFinal(String nombre){
        int sumaDeNotas = 0;
        int cantidadNotas = notas.size();
        
        for (Integer nota : notas) {
            sumaDeNotas += nota;
        }
        
        System.out.println("Promedio final del alumno " + nombre  + " es: " + sumaDeNotas/cantidadNotas);
    }
}
