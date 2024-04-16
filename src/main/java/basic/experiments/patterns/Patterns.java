package basic.experiments.patterns;

public class Patterns {

    public static void main(String[] args) {
        int inputSize=3;
        squarePattern(inputSize);

        simpleRightAngledTriangle(inputSize);

        numberedRightAngledTriangle(inputSize);

        numberedRightAngledTriangle2(inputSize);

        downwardNumberedTriangle(7);

        int height  = 4;
        int width =  7;

        equilateralTriangle(height, width);

        equilateralTriangle(inputSize);

        downWardEquilateralTriangle(inputSize);

        rhombus(inputSize);


    }

    private static void rhombus(int inputSize) {
        System.out.println("\n\n"+ " Rhombus Pattern");
        equilateralTriangle(inputSize);
        downWardEquilateralTriangle(inputSize);
    }

    private static void downWardEquilateralTriangle(int inputSize) {

        for(int i = inputSize-1; i>=0; i--){
            System.out.println();
            /*print spaces before star*/
            for(int j = 0; j<= inputSize -i-1; j++){
                System.out.print(" ");
            }

            /*for printing stars after spaces*/
            for(int j=0; j< 2*i+1; j++){
                System.out.print("*");
            }

            /*for printing spaces again after stars*/

//            for(int j = 0; j<= inputSize -i-1; j++){
//                System.out.print(" ");
//            }
        }
    }

    private static void equilateralTriangle(int inputSize) {
        System.out.println("\n\n"+ "Equilateral triangle Pattern");
        for(int i = 0; i< inputSize; i++){
            System.out.println();
            /*print spaces before star*/
            for(int j = 0; j<= inputSize -i-1; j++){
                System.out.print(" ");
            }

            /*for printing stars after spaces*/
            for(int j=0; j< 2*i+1; j++){
                System.out.print("*");
            }

            /*for printing spaces again after stars*/

            for(int j = 0; j<= inputSize -i-1; j++){
                System.out.print(" ");
            }
        }
    }

    private static void equilateralTriangle(int height, int width) {
        System.out.println("\n\n"+ "Equilateral triangle Pattern");
        for(int i = 0; i< height; i++){
            System.out.println();
            for(int j =0; j<= width; j++){
                if(j >=  width /2 -i && j <= width /2 +i )
                System.out.print("*");
                else System.out.print(" ");
            }
        }
    }

    private static void downwardNumberedTriangle(int inputSize) {
        System.out.println("\n\n"+ "numbered  downward right angled triangle Pattern");
        for(int i = inputSize; i>= 1; i--){
            System.out.println();
            for(int j = 1; j<= i; j++){
                System.out.print(j);
            }
        }
    }

    private static void numberedRightAngledTriangle2(int inputSize) {
        System.out.println("\n\n"+ " same numbered right angled triangle Pattern");
        for(int i = 1; i<= inputSize; i++){
            System.out.println();
            for(int j = 1; j<= i; j++){
                System.out.print(i);
            }
        }
    }

    private static void numberedRightAngledTriangle(int inputSize) {
        System.out.println("\n\n"+ "numbered right angled triangle Pattern");
        for(int i = 1; i<= inputSize; i++){
            System.out.println();
            for(int j = 1; j<= i; j++){
                System.out.print(j);
            }
        }
    }

    private static void simpleRightAngledTriangle(int inputSize) {
        System.out.println("\n\n"+ "right angled triangle Pattern");
        for(int i = 1; i<= inputSize; i++){
            System.out.println();
            for(int j = 1; j<= i; j++){
                System.out.print("* ");
            }
        }
    }

    private static void squarePattern(int inputSize) {
        System.out.println("\n\n"+ "Simple Square Pattern");
        for(int i = 1; i<= inputSize; i++){
            System.out.println();
            for(int j = 1; j<= inputSize; j++){
                System.out.print("* ");
            }

        }
    }
}
