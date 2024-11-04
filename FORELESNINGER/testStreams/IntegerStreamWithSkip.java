import java.util.stream.IntStream;

public class IntegerStreamWithSkip {
    public static void main(String[] args) {
        IntStream
            .range(1, 10)
            .skip(5)
            .forEach( (x) -> System.out.println(x)); //stream-operation .forEach() er i seg selv en funksjonell 
                                                     //interface, så dermed trengs ingen functionalInterface-klasse 
                                                     //å bli laget. Samme gjelder alt i Consumer-package'en. 
        System.out.println(); //filler
    }
}
