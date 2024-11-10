import java.util.Comparator;

import static java.util.Arrays.*;

public class SumOfSumOfSubsets {

     public static int[][] generatePowerset(int[] set) {
          // power set of empty set is empty
          if (set.length == 0) {
               return new int[][]{{}};
          }

          // generate the powerset of [1, 2, 3,  ..., n-1]
          int[] subsetWithoutLast = new int[set.length - 1];
          // copy that into the result set
          System.arraycopy(set, 0, subsetWithoutLast, 0, set.length - 1);
          int[][] subsetsWithoutLast = generatePowerset(subsetWithoutLast);

          // the powerset of up to n is exactly twice the length of the powerset of up to n-1
          int[][] result = new int[subsetsWithoutLast.length * 2][];

          System.arraycopy(subsetsWithoutLast, 0, result, 0, subsetsWithoutLast.length);

          // make a copy of each elemet of the powerset that was missing n, and put n there in the second copy
          for (int i = 0; i < subsetsWithoutLast.length; i++) {
               int[] newSubset = new int[subsetsWithoutLast[i].length + 1];
               System.arraycopy(subsetsWithoutLast[i], 0, newSubset, 0, subsetsWithoutLast[i].length);
               newSubset[newSubset.length - 1] = set[set.length - 1];
               result[subsetsWithoutLast.length + i] = newSubset;
          }

          // {1, 2, 3} has {{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}} = 8 sets in its power set
          // the power set of {1, 2, 3} is 2 copies of the powerset of {1, 2}-- one with a 3 on the end, and one without a 3 on the end
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

          sort(result, Comparator.comparingInt(a -> a.length));


          System.out.println(deepToString(result));
          System.out.println(sumOfSumOfSubsets(result));
     }
}
