import java.util.Optional;
import java.util.stream.Stream;

public class BasicExperiments {

    public static void main(String[] args) {
       Optional find =  Stream.of("one", "two", "three", "four")
                .map(String::toUpperCase)
                .filter(s -> s.length() > 3) .findFirst();

        System.out.println(find);

        System.out.println(10*20+"Mahendra");
        System.out.println("Mahendra"+10*20);

//        for(int i=0;0;i++){
//            System.out.println("Hello world");
//        }
    }
}
