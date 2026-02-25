package string.String_Props;

import java.util.HashMap;
import java.util.Map;

public class Tricky {

    public static void main(String[] args) {
        //1.
        String s1 = "A";
        String s2 = s1 + "B";  // as it contains combination of variable and literal --> resolved at run time --> mapped to Heap space
        String s3 = "AB";

        // now answer
        System.out.println(s2 == s3);  // false

        //2. Observe this
        String M = "M";
        String combo = "M" + "N";  // as both are literals resolved at compile time --> mapped to SCP
        String MN = "MN";

        //now answer
        System.out.println(combo == MN);  // true

        //2.A  --> look at this question
        final String a = "Hello";
        String b = a + "World";
        String c = "HelloWorld";

        System.out.println(b == c);  // true
        /*
        * The above is true because the final variables are treated as literals. They are compile time constants
        * JVM treats it like literal
        * Compile-time concatenation → SCP
        * */

        //observe this

        s1 = "A";    //scp
        s2 = "B";    //scp
        s3 = s1 + s2;   // resolved at run time ==> s1+s2 stored in heap space

        System.out.println(s3 == "AB");

        /**
         * 🧠 One Golden Mental Rule
         *
         * 💛 If a variable is involved → runtime → Heap
         * 💛 If only literals/constants(final) → compile time → SCP*/

        //3.
        /*
        * 👁️  Why?
        *
        * 🔥 JVM converts null to "null"
        * 🔥 String concatenation uses String.valueOf()
        * */
        String s4 = null;
        String s5 = "123";
        System.out.println(s4+s5);  //null123

        System.out.println("Hello"+5);
        System.out.println(5+"Hello");
        System.out.println(10+5);

        System.out.println("\n ====================================== \n");
        //4.
        String s = "Hello";
        s.replace('H','Y');
        System.out.println(s);      //Hello

        System.out.println("\n ==================  MAPS  ==================== \n");
        //observe below
        Map<String, Integer> map = new HashMap<>();
        String key = "Java";
        map.put(key, 1);

        key = key.concat("World");

        System.out.println(map.get("Java"));   // "Java".hashcode() is used and bucket is calculated
        System.out.println(map.get(key));

        System.out.println("\n ====================================== \n");

        char[] ch = { 's', 'u', 'f', 'i', 'y', 'a', 'n' };
        System.out.println(ch); // sufiyan
        String stdName = "sufiyan";
        System.out.println(stdName == String.valueOf(ch));

        int[] in = {1,2,3,4,5,6,7,8,9};
        System.out.println(in);

        System.out.println("\n ====================================== \n");

        /**
         * Java 8:
         * String → char[] → each char always takes 2 bytes [ every thing considered as UTF-16]
         * but generally ASCII requires only one byte per char.
         * So half of the memory is being wasted
         *
         *
         * Java 9+:
         * String → byte[] + coder
         *          ├─ Latin-1 → 1 byte
         *          └─ UTF-16 → 2 bytes
         *
         * 🔹 If all characters fit in ISO-8859-1 (Latin-1) → 1 byte per char
         * 🔹 If not → 2 bytes per char (UTF-16)
         * 💡 This decision is made at runtime when the string is created.
         *
         *         */

        // after Java 9
        String a1 = "Hello";     // Latin-1  --> 1 byte per char
        String b1 = "नमस्ते";      // UTF-16  --> 2 bytes per char
        String emoji = "🙂";     // UTF-16  --> 2 bytes per char

        System.out.println("\n ================= ESCAPE CHARACTERS  ===================== \n");
        // escape chars in Strings printing

        String escStr = "How to learn \"coding\" easily?";
        System.out.println(escStr);  // we used \ to include " " (double quotes) in string itself

        //some more examples
        String tabStr = "This space\t is of tab's size.";
        System.out.println(tabStr);

        String backSlashStr = "This is a backslash \\ here.";
        System.out.println(backSlashStr);

        String newLineStr = "The text\n after this will be in new line";
        System.out.println(newLineStr);

        System.out.println("\n ===============  STRING BUILDER ======================= \n");


        s1 = "Hello";
        StringBuilder sb = new StringBuilder("Hello");
        s3 = sb.toString();  // creates new String in heap

//        System.out.println(s1 == sb);  // compile time error
        System.out.println(s1 == s3);  // false

        s3 = s3.intern();
        System.out.println(s1 == s3);  // true

        System.out.println("\n ====================================== \n");

        StringBuilder sb1 = new StringBuilder("X");
        StringBuilder sb2 = new StringBuilder("X");

        System.out.println(sb1.equals(sb2)); // false    --> as SB is an Object, takes up Object.equals()

        // false because here Object.equals() is taken into account.
        // so the references are compared here , so they will be false

        System.out.println("\n ====================================== \n");

    }
}
