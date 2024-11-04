import java.util.Arrays;
import java.util.List;

public class StreamList {
    public static void main(String[] args) {
        List<String> people = Arrays.asList("Al","Sal","Bal","Thal","Jalh","Aja");
        people.stream() //gjør om elementene til stream som kan behandles
            .map(String::toLowerCase) //.map tar for seg alle elementer og transformerer de som angitt
            .filter( (x) -> x.startsWith("a")) //.filter er å filtrere spesifikke elementer som passer gitt krav
            .forEach(System.out::println);
    }
}
