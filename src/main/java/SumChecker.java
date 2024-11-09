public class SumChecker {

     public static void main(String[] args) {
          int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
          System.out.println(sumChecker(nums));
     }

     public static int sumChecker(int[] nums) {
          int sum = 0;
          for (int num : nums) {
               sum += (int) (num * Math.pow(2, nums.length - 1));
          }
          return sum;
     }
}
