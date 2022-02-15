package ejercicio_04;

import java.time.LocalTime;

public class Pelicula {

    private String titulo;
    private String director;
    private LocalTime duracion;

    public Pelicula() {
    }

    public Pelicula(String titulo, String director, LocalTime duracion) {
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

    public LocalTime getDuracion() {
        return duracion;
    }

    public void setDuracion(LocalTime duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Pelicula:\n " + "Titulo: " + titulo + "\n Director: " + director + "\n Duracion: " + duracion + "hr ";
    }

}
