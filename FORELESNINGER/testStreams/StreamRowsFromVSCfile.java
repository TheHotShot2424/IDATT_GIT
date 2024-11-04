import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamRowsFromVSCfile {
    public static void main(String[] args) throws IOException {
        // Stream rows from CSV file and count
        Stream<String> rows1 = Files.lines(Paths.get("data.txt")); //lages om til stream
        int rowCount = (int)rows1
                    .map((x) -> x.split(",")) //alle elementer/rows splittes til array'er ved komma
                    .filter((x) -> x.length == 3) //bare få kommer gjennom. Filtrerer ut array'ene under 3 elementer.
                    .count();
        System.out.println(rowCount + " rows.");
        rows1.close();
    }
}
