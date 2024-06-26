package basic.experiments.patterns;

public class Patterns {

    public static void main(String[] args) {
        int inputSize=5;
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

        arrowHeadPattern(5);

        reverseArrowHeadPattern(5);

        oneAndZeroRightAngledTriangle(inputSize);

        leftAndRightRightAngledTriableCombo(inputSize);

        NumberedRightTriangle(inputSize);

        alphabetRightAngledTriangle(inputSize);

        equilateralTriangleWithAlphabets(7);

        rightDecrementAlphabetTriangle(inputSize);

        wholeRectangleWithRhombusInsideIt(inputSize);

        hollowSquare(7);
        numberPattern(7);

    }

    private static void numberPattern(int inputSize) {
        System.out.println("\n\n");
        int want = inputSize;
        for(int i = 1; i < 2* inputSize; i++){
            System.out.println();


            for(int j = inputSize; j>0; j--){
                System.out.print(Math.max(j,want)+" ");
            }
            for(int j = 2; j<= inputSize; j++){
                System.out.print(Math.max(j,want)+" ");
            }
            if(i< inputSize) want--;
            else want++;

        }
    }

    private static void hollowSquare(int inputSize) {
        System.out.println("\n\n");
        for(int i = 0; i< inputSize; i++){
            System.out.println();
            for (int j = 0; j< inputSize; j++){
                if(i ==0 || i == inputSize -1) System.out.print("*");
                else if (j ==0 || j == inputSize -1) System.out.print("*");
                else System.out.print(" ");
            }
        }
    }

    private static void wholeRectangleWithRhombusInsideIt(int inputSize) {
        System.out.println("\n\n");
        //First half of Rectangle
        for (int i =5; i >0; i--){
            System.out.println();
            //print first inverted right angled triangle
                int j ;
                for ( j =0; j < i; j++){
                    System.out.print("* ");
                }

                for (int k = j; k < inputSize; k++){
                    System.out.print("  ");
                }
            //print second inverted right angled triangle

                for (int k = j; k < inputSize; k++){
                    System.out.print("  ");
                }
                for(int l =0; l<i; l++ ){
                    System.out.print("* ");
                }
        }
        // Second half of rectangle
        for (int i =0; i <inputSize; i++){
            System.out.println();
            //print first  right angled triangle

            for (int j =0; j <= i; j++){
                System.out.print("* ");
            }

            for (int k = i+1; k < inputSize; k++){
                System.out.print("  ");
            }
            //print second inverted right angled triangle

            for (int k = i+1; k < inputSize; k++){
                System.out.print("  ");
            }
            for(int l =0; l<=i; l++ ){
                System.out.print("* ");
            }
        }
    }

    private static void rightDecrementAlphabetTriangle(int inputSize) {

        System.out.println("\n\n");
        for(int i = 0; i < inputSize; i++){
            System.out.println();
            char k = (char)('A'+ inputSize-1-i);

            for (int j =0; j<=i; j++){
                System.out.print(k++);
            }
        }
    }

    private static void equilateralTriangleWithAlphabets(int inputSize) {
        System.out.println("\n\n");
        for(int i = 0; i< inputSize; i++){
            System.out.println();
            //printing spaces at starting
            for (int j = 0; j< inputSize -i-1; j++ ){
                System.out.print("*");
            }

            //printing alphabets upto half
            char j;
            for ( j ='A'; j<= 'A'+i; j++){
                System.out.print((char)j);
            }

            //printing reverse alphabets upto remaining half
            for(char k = (char) (j-2); k>='A'; k-- ){
                System.out.print((char)k);
            }
            // for printing the spaces again.
            for(int l=0;l<inputSize-i-1;l++){
                System.out.print("*");
            }
        }
    }

    private static void alphabetRightAngledTriangle(int inputSize) {
        System.out.println("\nRight angled triange with alphabets");

        for(int i = 1; i<= inputSize; i ++){
            System.out.println();
            for(char j='A'; j <= 'A'+i; j++){
                System.out.print( j);
            }
        }
        for(int i = inputSize; i>=1; i --){
            System.out.println();
            for(char j='A'; j <= 'A'+i; j++){
                System.out.print( j);
            }
        }
        System.out.println();

        for(int i = 'A'; i< 'A'+inputSize-1; i ++){
            System.out.println();
            for(char j='A'; j <= i; j++){
                System.out.print( (char)i);
            }
        }


    }

    private static void NumberedRightTriangle(int inputSize) {
        System.out.println("\nRight angled triange with numbers");
        int counter=0;
        for(int i = 1; i<= inputSize; i ++){
            System.out.println();
            for(int j=1; j <= i; j++){
                System.out.print(++counter +" ");
            }
        }
    }

    private static void leftAndRightRightAngledTriableCombo(int inputSize) {
        System.out.println("\n Downward empty equilateral triangle with numbers");
        for(int i = 1; i<= inputSize; i ++){
            System.out.println();
            for(int j = 1; j<= inputSize; j++){
               if(j<=i) System.out.print(j);
               else System.out.print(" ");
            }
            for(int j = inputSize; j>=1; j--){
                if(j<=i) System.out.print(j);
                else System.out.print(" ");
            }
        }
    }

    private static void oneAndZeroRightAngledTriangle(int inputSize) {
        System.out.println("\n\n"+ "One and zero right angled triangle Pattern");
        for(int i = 1; i<= inputSize; i++){
            System.out.println();
            for(int j = 1; j<= i; j++){
                if((i+j)%2==0) System.out.print("1");
                else System.out.print("0");
            }
        }
    }

    private static void reverseArrowHeadPattern(int inputSize) {
        System.out.println("\n\n Reverse Arrow head pattern");
        for(int i = inputSize-1; i >=0; i--){
            System.out.println();
            for(int j = 0; j<i; j++){
                System.out.print("n");
            }
            for(int j=i; j < inputSize; j++){
                System.out.print("*");
            }
        }
        for(int i = inputSize -1; i >= 0; i--){
            System.out.println();

            for(int j = inputSize-1; j >i; j--){
                System.out.print("n");
            }

            for(int j=i; j>=0; j--){
                System.out.print("*");
            }
        }
    }

    private static void arrowHeadPattern(int inputSize) {
        System.out.println("\n\nArrow head pattern");
        for(int i = 0; i< inputSize; i++){
            System.out.println();
            for(int j=0; j<=i; j++){
                System.out.print("*");
            }
        }
        for(int i = inputSize -1; i >= 0; i--){
            System.out.println();
            for(int j=i-1; j>=0; j--){
                System.out.print("*");
            }
        }
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
