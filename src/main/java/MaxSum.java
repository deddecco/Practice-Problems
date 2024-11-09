// find the max sum of a contiguous subarray
public class MaxSum {

     public static void main(String[] args) {
          System.out.println(findMaxSum(new int[]{2, 3, -8, 7, -1, 2, 3}));
     }

     public static int findMaxSum(int[] nums) {
          int maxSum = nums[0];
          for (int i = 0; i < nums.length; i++) {
               int currentSum = 0;

               for (int j = i; j < nums.length; j++) {
                    currentSum += nums[j];
                    maxSum = Math.max(maxSum, currentSum);
               }
          }

          return maxSum;
     }
}
