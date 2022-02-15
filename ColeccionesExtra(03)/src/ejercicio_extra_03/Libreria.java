package ejercicio_extra_03;


public class Libreria {

    private String titulo;
    private String autor;
    private int cantEjemplares;
    private int cantEjemplaresPrestados;

    public Libreria() {
    }

    public Libreria(String titulo, String autor, int cantEjemplares, int cantEjemplaresPrestados) {
        this.titulo = titulo;
        this.autor = autor;
        this.cantEjemplares = cantEjemplares;
        this.cantEjemplaresPrestados = cantEjemplaresPrestados;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCantEjemplares() {
        return cantEjemplares;
    }

    public void setCantEjemplares(int cantEjemplares) {
        this.cantEjemplares = cantEjemplares;
    }

    public int getCantEjemplaresPrestados() {
        return cantEjemplaresPrestados;
    }

    public void setCantEjemplaresPrestados(int cantEjemplaresPrestados) {
        this.cantEjemplaresPrestados = cantEjemplaresPrestados;
    }


    @Override
    public String toString() {
        return "Libreria\n" + "Titulo: " + titulo + "\nAutor: " + autor + "\nCantidad de ejemplares disponibles: " + cantEjemplares + "\nEjemplares prestados: " + cantEjemplaresPrestados + "\n";
    }

}
