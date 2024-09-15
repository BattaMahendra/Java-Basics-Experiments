import java.util.Optional;
import java.util.stream.Stream;

public class BasicExperiments {

    public static void main(String[] args) {
       Optional find =  Stream.of("one", "two", "three", "four")
                .map(String::toUpperCase)
                .filter(s -> s.length() > 3) .findFirst();

        System.out.println(find);
    }
}
