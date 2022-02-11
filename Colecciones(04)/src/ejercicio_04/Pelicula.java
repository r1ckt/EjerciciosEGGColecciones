package ejercicio_04;

import java.util.Comparator;

public class Pelicula {

    private String titulo;
    private String director;
    private Double duracion;

    public Pelicula() {
    }

    public Pelicula(String titulo, String director, Double duracion) {
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Double getDuracion() {
        return duracion;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }

    public static Comparator<Pelicula> ordenarSegunDuracionDesc = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula o1, Pelicula o2) {
            return o2.getDuracion().compareTo(o1.getDuracion());
        }
    };
    
    public static Comparator<Pelicula> ordenarSegunTituloAlf = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula o2, Pelicula o1) {
            return o2.getTitulo().compareTo(o1.getTitulo());
        }
    };
    
    public static Comparator<Pelicula> ordenarSegunDirectorAlf = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula o2, Pelicula o1) {
            return o2.getDirector().compareTo(o1.getDirector());
        }
    };

    @Override
    public String toString() {
        return "Pelicula:\n " + "Titulo: " + titulo + "\n Director: " + director + "\n Duracion: " + duracion + "hr ";
    }

}
