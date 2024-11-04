import java.util.Arrays;

public class StreamArrayMap {
    public static void main(String[] args) {
        //gir gjennomsnittelig kvadratrot av int array
        Arrays.stream(new int[] {2,4,6,8,10}) //må bruke new int[] først om du ikke først initiazer array'et på egen linje. Se StreamsFromArray.java
            .map(x -> x*x)
            .average()
            .ifPresent(System.out::println);
    }
}
