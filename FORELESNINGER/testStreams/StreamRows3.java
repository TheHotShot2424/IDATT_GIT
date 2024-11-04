import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamRows3 {
    public static void main(String[] args) throws IOException {
        //Stream rows from CSV file, store fields in HashMap
        Stream<String> rows3 = Files.lines(Paths.get("data.txt"));
        Map<String,Integer> map = new HashMap<>();
        
        map = rows3 //lagre alt i en map variabel
                .map((x) -> x.split(","))
                .filter((x) -> x.length == 3)
                .filter((x) -> Integer.parseInt(x[1]) > 15)
                .collect(Collectors.toMap( //her gjøre det om til map
                    x -> x[0], x -> Integer.parseInt(x[1]) //setter key (før komma) og value (etter komma) par
                ));
        rows3.close();

        for(String key : map.keySet()){
            System.out.println(key + " " + map.get(key));
        }
    }
}
