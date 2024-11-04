import java.util.Arrays;

public class StreamsFromArray {
    public static void main(String[] args) {
        String[] names = {"Al", "Hans", "Marx", "Carl", "Popper", "Sagan", "Markus"};
        Arrays.stream(names) //kunne også brukt Stream.of(names)
            .filter( (x) -> x.startsWith("M"))
            .sorted()
            .forEach(System.out::println); //hvor x i "x -> System.out.println(x)" går direkte til metode kan den ersattes med kun System.out::println
    }
}
