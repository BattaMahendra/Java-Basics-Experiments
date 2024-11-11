package string;

public class AreaOfTriangle {

    public static double areaOfTriangle(int a, int b, float angle){

        //converting the angle into radians using formula 22/7 * 1/180 * angle
        double pi = 22.0/7.0;
        double val = 1.0/180;
        double radiansConversion = pi*val*angle;

        System.out.println("Hey I am just printing out");
        //calculation of sin value
       double sinAngle = Math.sin(radiansConversion);

       //finding out height of triangle using formula sin (angle) = opp-side/hypotenuse
        double height = sinAngle*b;

        //calculation of area using formula 1/2 * height * base
        double area = 0.5 * height*a;
        System.out.println( Math.round(area*100.0)/100.0);

        double roundedArea = Math.round(area*100.0)/100.0;

        return roundedArea;
    }

    public static void main(String[] args) {

        System.out.println("Sin 30 = "+ Math.sin(Math.toRadians(30)));

       // areaOfTriangle(4,5,30);

         double pi = 22.0/7.0;
         double val = 1.0/180;
        System.out.println(pi);
        System.out.println(val);

        double radiansConvertion = pi*val*30;

        System.out.println(Math.sin(radiansConvertion));

    }
}
