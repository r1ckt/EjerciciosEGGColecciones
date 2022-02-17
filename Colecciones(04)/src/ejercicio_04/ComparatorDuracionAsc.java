package ejercicio_04;

import java.util.Comparator;

public class ComparatorDuracionAsc implements Comparator<Pelicula> {

    @Override
    public int compare(Pelicula t, Pelicula t1) {
        return t.getDuracion().compareTo(t1.getDuracion());
    }
    
}
