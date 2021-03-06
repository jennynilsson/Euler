package prime;

import java.util.ArrayList;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * <p/>
 * What is the largest prime factor of the number 600851475143 ?
 */

public class Problem3 {

    public static void main(String[] args) {
        long number = 600851475143L;
        long sqrt = Math.round(Math.sqrt(number));

        System.out.println(sqrt);

        ArrayList<Long> numbers = new ArrayList<>();

        for (long i = 2; i <= sqrt; i++) {
            numbers.add(i);
        }

        long p = 2;

        boolean run = true;
        boolean found = false;
        while (run) {
            for (long n = p; n < numbers.size() + 2; n = n + p) {
                if (n != p && n % p == 0) {
                    numbers.set((int) (n - 2), -n);
                }
            }

            long oldPrime = p;
            found = false;
            for (long n : numbers) {
                if (n > p) {
                    p = n;
                    found = true;
                    break;
                }
            }

            if (!found || oldPrime == p || p > sqrt) {
                run = false;
            }


            System.out.println("Prime" + p);
        }

        for (long n : numbers) {
            if (n > 0) {
                System.out.println("Prime" + n);
            }
        }
    }
}
