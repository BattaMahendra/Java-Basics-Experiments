package serialization;

import java.io.*;

public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Student s = new Student();
        s.setName("Manju");
        s.setRollno(1);
        s.setAge(22);

        //serializing s object
        serialize(s);

        //deserialize the same object from file
        deserialize();
    }

    private static void deserialize() throws IOException, ClassNotFoundException {
        FileInputStream fin = new FileInputStream("C:\\Users\\batta.chowdary\\IdeaProjects\\Java-Basics-Experiments\\src\\main\\resources\\files\\Serialized-Objects.txt");
        ObjectInputStream oin  = new ObjectInputStream(fin);
        Student deserializedStudent = (Student) oin.readObject();
        System.out.println("\n deserialized java object"+deserializedStudent);
        //static variables
        System.out.println(Student.stateBoard);

        oin.close();
        fin.close();
    }

    private static void serialize(Student s) throws IOException {
        FileOutputStream fo = new FileOutputStream("C:\\Users\\batta.chowdary\\IdeaProjects\\Java-Basics-Experiments\\src\\main\\resources\\files\\Serialized-Objects.txt");
        ObjectOutputStream oo = new ObjectOutputStream(fo);

        oo.writeObject(s);

        // Close the output stream.
        oo.close();

        // Close the file.
        oo.close();
        System.out.printf("Object serialized");
    }
}
