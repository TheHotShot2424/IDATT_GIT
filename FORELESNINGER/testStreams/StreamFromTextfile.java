import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamFromTextfile {
    public static void main(String[] args) throws IOException {
        //stream rows from text file, sort, filter and then print
        Stream<String> band = Files.lines(Paths.get("Music_bands.txt")); //Files.line gir en stream av string av hver linje i filen
        band //trenger ikke .stream() da dette lages linje 9. 
            .sorted() //alfabetisk
            .filter((x) -> x.length() > 13) //finne hvilke setninger/linjer har mer enn 13 bokstaver
            .forEach(System.out::println);
        band.close();
    }
}
