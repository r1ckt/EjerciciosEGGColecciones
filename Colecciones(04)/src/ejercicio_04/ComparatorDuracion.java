package ejercicio_04;

import java.util.Comparator;

public class ComparatorDuracion implements Comparator<Pelicula> {

    @Override
    public int compare(Pelicula t, Pelicula t1) {
        return t1.getDuracion().compareTo(t.getDuracion());
    }
    
}
