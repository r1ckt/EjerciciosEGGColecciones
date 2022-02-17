package ejercicio_04;

import java.util.Comparator;

public class ComparatorTituloAlf implements Comparator<Pelicula> {

    @Override
    public int compare(Pelicula t, Pelicula t1) {
        return t.getTitulo().compareTo(t1.getTitulo());
    }
    
}
