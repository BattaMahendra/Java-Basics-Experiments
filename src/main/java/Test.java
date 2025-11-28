import java.util.List;

public class Test {

    public static void main(String[] args) {
        C c = new C();

        List<Integer> l = List.of(1,3,2,4,5,6,6,7,6);
        int i = 9;
        l.forEach(x ->{
            x++;
            System.out.println(x+x);

        });



    }
}

class A{

    public  static int i = Util.int1();
    static {
        System.out.println("Inside static block - A ");
    }

    {
        System.out.println("Inside instance block - A ");
    }
    public A(){
        System.out.println("Inside constructor - A");
    }


}

class B extends A{

     static int j = Util.int2();
    static {

        System.out.println("Inside static block - B ");
    }
    {
        System.out.println("Inside instance block - B ");
    }
    int m = Util.int4();
    public B(){
        System.out.println("Inside constructor - B");
    }

    public static  void printStaticB(){
        System.out.println("We are inside static method: B");


    }

}

class C extends B{


    static {

        System.out.println("Inside static block - C ");
    }
    public  static int k = Util.int3();

    {
        System.out.println("Inside instance block - C ");
    }

    int m = Util.int4();
    int n = Util.init("instance variable of C");
    public C(){
        System.out.println("Inside constructor - C");
    }

    public static  void printStaticC(){
        System.out.println("We are inside static method: C");
        i=Util.int1();
        j=9;
        k =0;


    }

    public   void printInstance(){
        System.out.println("We are inside instance method: C");
        printStaticC();
    }



}

class Util{

    public static int int1(){
        System.out.println(" we are initializing static variable - A");
        return 1;
    }

    public static int int2(){
        System.out.println(" we are initializing static variable - B");
        return 2;
    }

    public static int int3(){
        System.out.println(" we are initializing static variable - C");
        return 3;
    }

    public static int int4(){
        System.out.println(" we are initializing instance variable - C");
        return 4;
    }

    public static int init(String msg){
        System.out.println("we are in the :"+msg);
        return 0;
    }
}
