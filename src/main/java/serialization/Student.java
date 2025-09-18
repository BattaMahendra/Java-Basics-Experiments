package serialization;


import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/*

*

 Serializes non-static, non-transient instance fields.
*
*
*
Basics & Why
What is Serialization / Deserialization

Serialization: converting an object graph into a byte stream (so it can be stored or sent).
1. So that we can transfer the object over a network
2. To Store object into DB or save in file

Deserialization: reconstructing objects back from that byte stream.

Typical APIs: ObjectOutputStream / ObjectInputStream.

When to use

Persisting objects to disk, sending objects over network (RMI, cached state), or implementing deep cloning
* */

@Data
@ToString
public class Student implements Serializable {

    /*
    *   Used when to check compatibility during deserialization
    *   If we dont provide it then compiler automatically generates one by class features.
    *   (Be careful as different java versions create different ids , so during deserialization it might break)
    * */
    private static final long serialVersionUID = 1L;

    /*
    * static fields belong to class so they are not serialized by default
    * */
    public static String stateBoard = "SSC";


    private   String name;
    private int rollno;
    //using transient keyword which doesn't get serialized
    transient  private int age;

    //experimenting transient with final keyword  when literal is initialized -- transient doesn't work in this case
    /*
    * The final modifier makes no difference when it has literal initialization.
    * When a variable of type String is declared as final and transient,
    *  its value is determined at compile-time and is stored in the class’s constant pool.
    *  Since it is final, it’s value can’t be changed after its initialization.
    * Hence, its value will be taken from the class and not null.
    * */
    private transient final String city = "Ananthapuramu";

    //experimenting transient with final keyword when variable is declared
    //here transient works as the field is being initialized in the constructor
    //and when the object is deserialized the constructor is not called so the state value will be null when deserialized
    private transient  final String state;

    private Teacher teacher;

    //non serialized object
    //private Department department; // results in runtime error as Department is not a serializable object.


    public Student (){
        this.state ="Andhra Pradesh";
        teacher = new Teacher("Mahesh", "JAVA");
       // department = new Department(1, "CS");
    }


}

class Department{

    int id;
    String name;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }


}


/*
* Important topics to address
* 1. What is externalization ( how it is helpful as alternative of serialization)
* 2. Serialization on Enums ( they follow different mechanisms compared to serialization)
* 3. What is readResolve() method is useful ?
* 4. How to customize serialization ? ( wirteObject() and readObject() methods)
* 5. How is inheritance possible in serializable parent or serializable child ?
* 6. What happens if a serializable class contains non serializable object reference ? ( how to handle it )
*     ans.   // ❌ Throws java.io.NotSerializableException
*           how to handle it
*           THree ways
*           1. Mark that field as transient
*           2. handle in  customization i.e use writeObject() and readObject() methods
*           3. Make that object class serializable
* */

