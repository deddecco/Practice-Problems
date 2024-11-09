import java.util.Arrays;
import java.util.Comparator;

public class SumOfSumOfSubsets {

     public static int[][] generatePowerset(int[] set) {
          if (set.length == 0) {
               return new int[][]{{}};
          }

          int[] subsetWithoutLast = new int[set.length - 1];
          System.arraycopy(set, 0, subsetWithoutLast, 0, set.length - 1);
          int[][] subsetsWithoutLast = generatePowerset(subsetWithoutLast);

          int[][] result = new int[subsetsWithoutLast.length * 2][];

          System.arraycopy(subsetsWithoutLast, 0, result, 0, subsetsWithoutLast.length);

          for (int i = 0; i < subsetsWithoutLast.length; i++) {
               int[] newSubset = new int[subsetsWithoutLast[i].length + 1];
               System.arraycopy(subsetsWithoutLast[i], 0, newSubset, 0, subsetsWithoutLast[i].length);
               newSubset[newSubset.length - 1] = set[set.length - 1];
               result[subsetsWithoutLast.length + i] = newSubset;
          }

          return result;
     }

     public static int sumOfSumOfSubsets(int[][] powerset) {
          int sum = 0;
          for (int[] set : powerset) {
               for (int element : set) {
                    sum += element;
               }
          }

          return sum;
     }


     public static void main(String[] args) {

          int[] set = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

          int[][] result = generatePowerset(set);

          Arrays.sort(result, Comparator.comparingInt(a -> a.length));


          System.out.println(Arrays.deepToString(result));
          System.out.println(sumOfSumOfSubsets(result));
     }
}
