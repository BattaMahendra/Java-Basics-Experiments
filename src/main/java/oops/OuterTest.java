package oops;

import oops.abstraction.Computer;
import oops.abstraction.IProcessor;
import oops.abstraction.Laptop;

public class OuterTest {
    public static void main(String[] args) {
        Laptop lappy = new Laptop();
        lappy.process();

        IProcessor iProcessor = new Laptop();

    }
}
