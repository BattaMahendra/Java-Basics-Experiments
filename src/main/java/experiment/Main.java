package experiment;

public class Main {

    static final int i;

    static {
        i =9;
    }


    public static final void staticMethod(){
        System.out.println("hi");
    }

    public static void main(String[] args) {

    }

    public int printParams(int i){
        System.out.println(i);
        return i;
    }

    public  char printParams(int i, char c){
        System.out.println(i);
        return c;
    }
}

class MainChild1{

    public int printParams(int i){
        System.out.println(i);
        return i;
    }

}
class MainChild2 extends MainChild1
{
//    public char printParams(int i){
//        System.out.println(i);
//        return '';
//    }

}