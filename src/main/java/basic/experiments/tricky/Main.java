package basic.experiments.tricky;

import lombok.ToString;

@ToString
public class Main {

    public Main ref;

    public String name;

    public Main(String name){

        this.name = name;
        return;    // allowed in constructor

    }

    public static void main(String[] args) {
        Main m1 = new Main("one");
        Main m2 = new Main("two");

        m1.ref = m2;
        m2.ref = m1;
        System.out.println(m1);

    }
}
