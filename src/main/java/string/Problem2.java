package string;

public class Problem2 {
    public static void main(String[] args) {
        String input = "143Kishore";
        bruteForceApproach(input);
        regexApproach(input);
    }

    private static void regexApproach(String input) {
        int value = Integer.parseInt(input.replaceAll("[^0-9]", ""));
    }

    private static void bruteForceApproach(String input) {
        char[] c = input.toCharArray();
        char[] numArray = {'0','1','2','3','4','5','6','7','8','9'};
        String num ="";
        for(int i=0; i<c.length;i++){
            for(int j=0; j<numArray.length; j++){
                if(c[i]==numArray[j]){
                    num +=c[i];
                }
            }
        }
        System.out.println(Integer.parseInt(num));
    }
}
