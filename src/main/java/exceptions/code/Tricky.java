package exceptions.code;

public class Tricky {

    public static void main(String[] args) {

        int i = tricky();
        System.out.println(i);

    }


    // change string s value to null and Mahendra to see changes

    private static int tricky() {
        try{
            System.out.println("we are in the try block");
            String s = "Mahendra";
//            String s = null;
            return s.length();
        }catch(Exception e) {
            System.out.println(" we are in the catch block \n");

            return 7;
        }
        finally{
//             System.exit(0);
            System.out.println(" we are in the finally block \n");
            return 1;
        }
    }


}
