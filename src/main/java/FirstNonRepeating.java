import java.util.HashMap;


// find the first character in a string that does not repeat
public class FirstNonRepeating {
     public static void main(String[] args) {
          System.out.println(firstNonRepeatingChar("swiss"));
          System.out.println(firstNonRepeatingChar("repeated"));
     }

     public static char firstNonRepeatingChar(String str) {
          if (str == null || str.isEmpty()) {
               return '\0';
          } else {
               HashMap<Character, Integer> freq = new HashMap<>();
               for (char c : str.toCharArray()) {
                    if (freq.containsKey(c)) {
                         freq.put(c, freq.get(c) + 1);
                    } else {
                         freq.put(c, 1);
                    }
               }

               for (char c : str.toCharArray()) {
                    if (freq.get(c) == 1) {
                         return c;
                    }
               }
          }

          return '\0';
     }
}
