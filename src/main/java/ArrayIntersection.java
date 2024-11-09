import java.util.ArrayList;
import java.util.Arrays;


// find the intersection of 2 arrays
public class ArrayIntersection {

     public static void main(String[] args) {
          int[] nums1 = new int[]{1, 2, 2, 1};
          int[] nums2 = new int[]{2, 2};
          System.out.println(Arrays.toString(intersection(nums1, nums2)));
     }

     public static int[] intersection(int[] a, int[] b) {
          ArrayList<Integer> intersection = new ArrayList<>();
          Arrays.sort(a);
          Arrays.sort(b);
          for (int j : a) {
               if (Arrays.binarySearch(b, j) >= 0) {
                    intersection.add(j);
               }
          }

          int[] intersectionArray = new int[intersection.size()];
          for (int i = 0; i < intersection.size(); i++) {
               intersectionArray[i] = intersection.get(i);
          }
          return intersectionArray;
     }
}
