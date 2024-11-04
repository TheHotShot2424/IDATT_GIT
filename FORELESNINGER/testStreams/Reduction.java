import java.util.stream.Stream;

public class Reduction {
    public static void main(String[] args) {
        double total = Stream.of(7.3, 1.5, 4.8)
                            .reduce(0.0, (Double a, Double b) -> a + b);
        System.out.println("Total = " + total);
    }
}
