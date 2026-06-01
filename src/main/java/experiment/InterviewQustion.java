package experiment;



class  Employee {
    String name;
    static int id = 5;  //remove static and check the output

    public Employee(){

    }

    public static void main(String[] args) {
        Employee e1 = new Employee();
        Employee e2 = new Employee();
        e1.id =10;

        System.out.println(e2.id);
        System.out.println(e1.id);
    }
}
