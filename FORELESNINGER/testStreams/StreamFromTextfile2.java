import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFromTextfile2 {
    public static void main(String[] args) throws IOException {
        //stream rows from text file, and save to List
        List<String> band2 = Files.lines(Paths.get("Music_bands.txt")) //lager stream med Files.lines()
            .filter(x -> x.contains("jit"))
            .collect(Collectors.toList()); //samler og koncertere alt så langt til list.
        band2.forEach(x -> System.out.println(x)); //kan også bruke "System.out::println" inni forEach()
    }
}
