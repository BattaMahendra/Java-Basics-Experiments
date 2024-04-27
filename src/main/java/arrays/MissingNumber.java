package arrays;

class MissingNumber {
    public static int missingNumber(int[] nums) {

        int[] ans = new int[nums.length+1];

        for(int x : nums){
            ans[x]++;
        }

        for(int i=0;i<ans.length;i++){
            if(ans[i]==0){
                return i;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3};
        missingNumber(nums);
    }
}