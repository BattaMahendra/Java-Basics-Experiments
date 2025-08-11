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


        // externalization
        System.out.println("\n == Externalization ==");
        Teacher teacher = new Teacher();
        teacher.name = "Mahesh";
        teacher.dept = "Java";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\batta\\IdeaProjects\\Java-Basics-Experiments\\src\\main\\resources\\files\\externalized-objects.txt"))) {
            oos.writeObject(teacher);
        }

        // De externalize
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\batta\\IdeaProjects\\Java-Basics-Experiments\\src\\main\\resources\\files\\externalized-objects.txt"))) {
            Teacher p2 = (Teacher) ois.readObject();
            System.out.println("After deserialization: " + p2);
        }
    }

    private static void deserialize() throws IOException, ClassNotFoundException {
        FileInputStream fin = new FileInputStream("C:\\Users\\batta\\IdeaProjects\\Java-Basics-Experiments\\src\\main\\resources\\files\\Serialized-Objects.txt");
        ObjectInputStream oin  = new ObjectInputStream(fin);
        Student deserializedStudent = (Student) oin.readObject();
        System.out.println("\n deserialized java object"+deserializedStudent);
        //static variables
        System.out.println(Student.stateBoard);

        oin.close();
        fin.close();
    }

    private static void serialize(Student s) throws IOException {

        System.out.println("Object about to get serialized: "+ s.toString());
        FileOutputStream fo = new FileOutputStream("C:\\Users\\batta\\IdeaProjects\\Java-Basics-Experiments\\src\\main\\resources\\files\\Serialized-Objects.txt");
        ObjectOutputStream oo = new ObjectOutputStream(fo);

        oo.writeObject(s);

        // Close the output stream.
        oo.close();

        // Close the file.
        oo.close();
        System.out.printf("Object serialized");
    }
}
