import java.util.stream.Stream;

public class StreamOfEtc {
    public static void main(String[] args) {
        Stream.of("Ares","Afrodite","Artemis") //kan stream'e int, String, objekter. 
            .sorted()
            .findFirst()
            .ifPresent(System.out::println); 
    }
}
