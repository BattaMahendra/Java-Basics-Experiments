package basic.experiments.basic.concepts;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;

public enum Operation {
    PLUS {
        @Override
        public double apply(double x, double y) {
            return x+y;
        }
    },
    MINUS {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE {
        @Override
        public double apply(double x, double y) {
            return x / y;
        }
    };

    //We can have abstract methods in enum
    // Abstract method to be overridden by each constant
    public abstract double apply(double x, double y);

    public static void main(String[] args) {
        double a = 6;
        double b = 2;

        for (Operation op : Operation.values()) {
            System.out.println("Operation: " + op);
            System.out.println("Result: " + op.apply(a, b));
        }

        //basic representation of enum
        FamilyEnum fatherEnum = FamilyEnum.FATHER;
        fatherEnum.description();

        // we can also use this way.
        Enum<FamilyEnum> father = FamilyEnum.FATHER;

        // enum important methods

        Operation.PLUS.name(); // name of the enum constant
        Operation.PLUS.ordinal(); // prints the order of the constant in Operation family ( zero based index)

        Operation addition = Operation.valueOf("PLUS");  // converts a string into enum of specified type
        addition.apply(2,3);

        Operation[] operationsArray = Operation.values(); // array of all constants
        Arrays.stream(operationsArray).forEach(System.out::print);

        // enum set and entering all the constants of Operation class
        EnumSet<Operation> operationEnumSet = EnumSet.allOf(Operation.class);
        operationEnumSet.forEach(System.out::println);

        // more ways to initialize
        EnumSet<FamilyEnum> elderGroup = EnumSet.of(FamilyEnum.GRANDPARENTS, FamilyEnum.FATHER, FamilyEnum.MOTHER);

        EnumMap<Operation, String> operationStringEnumMap = new EnumMap<>(Operation.class);

        operationStringEnumMap.put(Operation.PLUS,"Addition");
        operationStringEnumMap.put(Operation.MINUS,"Subtraction");
        operationStringEnumMap.entrySet().forEach(System.out::println);

    }
}
