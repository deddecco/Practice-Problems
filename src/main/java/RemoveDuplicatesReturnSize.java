import java.util.HashSet;
import java.util.Set;


// return the size of an array after duplicates have been removed
public class RemoveDuplicatesReturnSize {

     public static void main(String[] args) {
          System.out.println(sizeAfterNoDups(new int[]{1, 1, 2}));
     }

     private static int sizeAfterNoDups(int[] ints) {
          Set<Integer> noDups = new HashSet<>();
          for (int anInt : ints) {
               noDups.add(anInt);
          }
          return noDups.size();
     }
}