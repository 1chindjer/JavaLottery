import java.util.*;
import java.io.*;

public class ToyLottery {
    private PriorityQueue<Toy> toyQueue = new PriorityQueue<>(new ToyComparator());
    private Random rand = new Random();

    public ToyLottery(String... toyData) {
        for (String data : toyData) {
            String[] parts = data.split(" ");
            toyQueue.add(new Toy(parts[0], parts[2], Integer.parseInt(parts[1])));
        }
    }

    public String get() {
        int totalWeight = toyQueue.stream().mapToInt(Toy::getWeight).sum();
        int randWeight = rand.nextInt(totalWeight);

        for (Toy toy : toyQueue) {
            randWeight -= toy.getWeight();
            if (randWeight < 0) {
                return toy.getId();
            }
        }

        return null;
    }

    public static void main(String[] args) throws IOException {
        ToyLottery lottery = new ToyLottery(
                "1 2 конструктор",
                "2 2 робот",
                "3 6 кукла"
        );

        FileWriter writer = new FileWriter("./Java_final/src/result.txt");
        for (int i = 0; i < 10; i++) {
            writer.write(lottery.get() + "\n");
        }
        writer.close();
    }
}
