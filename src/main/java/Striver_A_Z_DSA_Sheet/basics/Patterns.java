package Striver_A_Z_DSA_Sheet.basics;



public class Patterns {

    public static void main(String[] args) {

        squarePattern();
        rightAngledTriangle();
        rightAngledNumberedTriangle();
        rightAngledNumberedSameTriangle();
        rightAngledDownwardTriangle();
        rightAngledDownwardNumberedTriangle();
        halfPyramid();
        invertedPyramid();
        rhombus();
        arrow();
        oneZeroRightTriangle();
        invertedNumberedPyramid();
        rightAngledForwardTriangle();
        rightAngledCharForwardTriangle();
        rightAngledSameCharForwardTriangle();
        characterPyramid();
        rightAngledCharTriangle();

        int N=5;
        hollowSquare( N);


        compoundNumberSquare(N);


    }

    private static void compoundNumberSquare(int N) {
        for(int i = N; i >=1; i--){
            for(int j = N; j>=1; j--){
                if(i>=j) System.out.print(" "+i+" ");
                else System.out.print(" "+j+" ");
            }
            for(int j = 2; j<= N; j++){
                if(j<=i)  System.out.print(" "+i+" ");
                else  System.out.print(" "+j+" ");
            }
            System.out.println();
        }
        for(int i = 2; i <= N; i++){
            for(int j = N; j>=1; j--){
                if(j>=i)  System.out.print(" "+j+" ");
                else  System.out.print(" "+i+" ");
            }
            for(int j = 2; j<= N; j++){
                if(j<=i)  System.out.print(" "+i+" ");
                else  System.out.print(" "+j+" ");
            }
            System.out.println();
        }

        System.out.println("\n=====================================\n");
    }


    private static void hollowSquare(int N) {
        for(int i=1; i<= N; i++){

            for (int j=1; j<=N; j++){
                if(i>1 && i<N && j>1 && j<N) System.out.print(" ");
                else System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("\n=====================================\n");
    }


    private static void rightAngledCharTriangle() {

        for(int i=1; i<=5; i++){

            char k = (char)('F'-i);

            for(int j =1; j <= i; j++){
                System.out.print(" "+(k++) +" ");
            }
            System.out.println();

        }

        System.out.println("\n=====================================\n");
    }

    private static void characterPyramid() {
        for(int i=1; i<=5; i++){
            char k = 'A';
            for(int j =5; j >= i; j--){
                System.out.print(" ");
            }
            for(int j =1; j<i; j++){
                System.out.print(k++);
            }
            for(int j =1; j<=i; j++){
                System.out.print(k--);
            }
            System.out.println();
        }

        System.out.println("\n=====================================\n");
    }


    private static void rightAngledSameCharForwardTriangle() {
        char k =97;
        for(int i=1; i<=5; i++){
            for(int j =1; j <= i; j++){
                System.out.print(" "+k +" " );
            }
            k++;
            System.out.println();
        }

        System.out.println("\n=====================================\n");
    }

    private static void rightAngledCharForwardTriangle() {
        char k =97;
        for(int i=1; i<=5; i++){
            for(int j =1; j <= i; j++){
                System.out.print(" "+k++ +" " );
            }
            k =97;
            System.out.println();
        }

        System.out.println("\n=====================================\n");
    }

    private static void rightAngledForwardTriangle() {
        int k =1;
        for(int i=1; i<=5; i++){
            for(int j =1; j <= i; j++){
                System.out.print(" "+k++ +" " );
            }
            System.out.println();
        }

        System.out.println("\n=====================================\n");
    }

    private static void invertedNumberedPyramid() {


        for(int i=1; i<=5; i++){
            for(int j =1; j <= i; j++){
                System.out.print(j);
            }
            for(int j =5; j>i; j--){
                System.out.print(" ");
            }
            for(int j =5; j>i; j--){
                System.out.print(" ");
            }
            for(int j=i; j>=1; j--){
                System.out.print(j);
            }
            System.out.println();
        }

        System.out.println("\n=====================================\n");
    }

    private static void oneZeroRightTriangle() {

        for(int i =0; i< 5; i++) {
            for(int j=0; j<=i; j++){
                if((i+j)%2 ==0) System.out.print("1");
                else System.out.print("0");
            }
            System.out.println();
        }
        System.out.println("\n=====================================\n");

    }

    private static void arrow(){
        for(int i=1; i<=5; i++){
            for(int j=1; j<=i; j++){
                System.out.print(" * ");
            }
            System.out.println();
        }
        for(int i=1; i<=5; i++){
            for(int j=5; j>i; j--){
                System.out.print(" * ");
            }
            System.out.println();
        }
        System.out.println("\n=====================================\n");
    }

    private static void rhombus() {

        for(int i=1; i<=5; i++){
            for(int j =5; j >= i; j--){
                System.out.print(" ");
            }
            for(int j =1; j<i; j++){
                System.out.print("*");
            }
            for(int j =1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=1; i<=5; i++){
            for(int j =1; j <= i; j++){
                System.out.print(" ");
            }
            for(int j =5; j>i; j--){
                System.out.print("*");
            }
            for(int j =5; j>=i; j--){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("\n=====================================\n");

    }

    private static void invertedPyramid() {


        for(int i=1; i<=5; i++){
            for(int j =1; j <= i; j++){
                System.out.print(" ");
            }
            for(int j =5; j>i; j--){
                System.out.print("*");
            }
            for(int j =5; j>=i; j--){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("\n=====================================\n");
    }

    private static void halfPyramid() {
        for(int i=1; i<=5; i++){
            for(int j =5; j >= i; j--){
                System.out.print(" ");
            }
            for(int j =1; j<i; j++){
                System.out.print("*");
            }
            for(int j =1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("\n=====================================\n");
    }


    private static void rightAngledDownwardNumberedTriangle() {
        for(int i=5; i>=1; i--){
            for(int j =1; j <= i; j++){
                System.out.print(" "+j+" ");
            }
            System.out.println();
        }

        System.out.println("\n=====================================\n");
    }

    private static void rightAngledDownwardTriangle() {
        for(int i=1; i<=5; i++){
            for(int j =5; j >= i; j--){
                System.out.print(" * ");
            }
            System.out.println();
        }

        System.out.println("\n=====================================\n");
    }

    private static void rightAngledNumberedSameTriangle() {
        for(int i=1; i<=5; i++){
            for(int j =1; j <= i; j++){
                System.out.print(" "+i+" ");
            }
            System.out.println();
        }

        System.out.println("\n=====================================\n");
    }

    private static void rightAngledNumberedTriangle() {
        for(int i=1; i<=5; i++){
            for(int j =1; j <= i; j++){
                System.out.print(" "+j+" ");
            }
            System.out.println();
        }

        System.out.println("\n=====================================\n");
    }

    private static void rightAngledTriangle() {
        for(int i=1; i<=5; i++){
            for(int j =1; j <= i; j++){
                System.out.print(" * ");
            }
            System.out.println();
        }

        System.out.println("\n=====================================\n");
    }

    private static void squarePattern() {

        for(int i=1; i<=5; i++){
            for(int j =1; j <= 5; j++){
                System.out.print(" * ");
            }
            System.out.println();
        }

        System.out.println("\n=====================================\n");
    }


}
