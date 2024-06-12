package serialization;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class Student implements Serializable {

    public static String stateBoard = "SSC";


    private   String name;
    private int rollno;
    //using transient keyword which doesn't get serialized
    transient  private int age;
    //experimenting transient with final keyword  when literal is initialized-- transient doesn't work in this case
    /*
    * The final modifier makes no difference when it has literal initialization.
    * When a variable of type String is declared as final and transient,
    *  its value is determined at compile-time and is stored in the class’s constant pool.
    *  Since it is final, it’s value can’t be change after it’s initialization.
    * Hence, its value will be taken from the class and not null.
    * */
    private transient final String city = "Ananthapuramu";

    //experimenting transient with final keyword when variable is declared
    private transient  final String state;

    public Student (){
        this.state ="Andhra Pradesh";
    }


}
