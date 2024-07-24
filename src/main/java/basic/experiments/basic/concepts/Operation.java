package basic.experiments.basic.concepts;

public enum Operation {
    PLUS {
        @Override
        public double apply(double x, double y) {
            return x + y;
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
    }
}
