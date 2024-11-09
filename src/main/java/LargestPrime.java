import java.util.ArrayList;
import java.util.List;

// find the largest prime less than a bound
public class LargestPrime {
     public static void main(String[] args) {
          System.out.println(getLargestPrime(100));
     }

     public static int getLargestPrime(int n) {
          List<Integer> primesLessThanN = generatePrimeList(n);
          return primesLessThanN.get(primesLessThanN.size() - 1);
     }

     public static List<Integer> generatePrimeList(int n) {
          List<Integer> primeList = new ArrayList<>();
          for (int i = 2; i <= n; i++) {
               if (isPrime(i)) {
                    primeList.add(i);
               }
          }

          return primeList;
     }

     private static boolean isPrime(int n) {
          boolean isPrime = true;
          for (int i = 2; i <= Math.sqrt(n); i++) {
               if (n % i == 0) {
                    isPrime = false;
                    break;
               }
          }

          return isPrime;
     }
}
