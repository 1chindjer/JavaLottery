import java.util.Comparator;

public class ToyComparator implements Comparator<Toy> {
    public int compare(Toy t1, Toy t2) {
        return Integer.compare(t2.getWeight(), t1.getWeight());
    }
}
