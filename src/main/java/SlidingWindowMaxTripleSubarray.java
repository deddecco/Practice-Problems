import static java.lang.Math.*;
import static java.lang.Math.max;

public class SlidingWindowMaxTripleSubarray {
     public static void main(String[] args) {

/*
          int[] arr = {2, 1, 5, 1, 3, 2};
          System.out.println(calcMaxSum(arr, 3));
*/

          int[] arr = {1, 2, 3, 4, 5};
          System.out.println(longestSubarrayWithSumAtMostK(arr, 9));


     }

     public static int sumTriple(int[] arr, int startIdx, int windowSize) {
          int sum = 0;
          for (int i = startIdx; i < startIdx + windowSize; i++) {
               if (startIdx + i < arr.length) {
                    sum += arr[startIdx + i];
               }
          }

          return sum;
     }

     public static int calcMaxSum(int[] arr, int windowSize) {
          int maxSum;
          int currSum = 0;
          for (int i = 0; i < windowSize; i++) {
               currSum += arr[i];
          }
          maxSum = currSum;

          for (int i = windowSize; i < arr.length; i++) {
               currSum += arr[i] - arr[i - windowSize];
               maxSum = max(maxSum, currSum);
          }

          return maxSum;
     }

     public static int longestSubarrayWithSumAtMostK(int[] arr, int bound) {
          int maxLengthSeenSoFar = 0;

          int currLength = 0;
          int currSum = 0;
          for (int i : arr) {
               while (currSum <= bound) {
                    currSum += i;
                    currLength++;
                    maxLengthSeenSoFar = max(maxLengthSeenSoFar, currLength);
               }
               currSum = 0;
               currLength = 0;
          }
          return maxLengthSeenSoFar;
     }
}
