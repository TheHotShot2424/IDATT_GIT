import java.util.stream.IntStream;

public class IntegerStreamWithSum {
    public static void main(String[] args) {
        System.out.println(
            IntStream //to create stream of objects 
            .range(1, 5)
            .sum());
        System.out.println();
    }
}
