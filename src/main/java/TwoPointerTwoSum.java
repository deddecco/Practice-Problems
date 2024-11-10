import java.util.Arrays;
import java.util.HashMap;

public class TwoPointerTwoSum {
     public static void main(String[] args) {
          int[] nums = {2, 7, 11, 15};
          int target = 22;
          System.out.println(Arrays.toString(findTwoSum(nums, target)));
     }

     public static int[] findTwoSum(int[] nums, int target) {

          HashMap<Integer, Integer> map = new HashMap<>();
          for (int i = 0; i < nums.length; i++) {
               if (map.containsKey(target - nums[i])) {
                    return new int[]{map.get(target - nums[i]), i};
               } else {
                    map.put(nums[i], i);
               }
          }
          return null;
     }
}
