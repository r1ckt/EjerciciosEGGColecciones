package ejercicio_04;
import java.util.Comparator;

public class ComparatorDirector implements Comparator<Pelicula> {

    @Override
    public int compare(Pelicula t, Pelicula t1) {
        return t.getDirector().compareTo(t1.getDirector());
    }
    
}
