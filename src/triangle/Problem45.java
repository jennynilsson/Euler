package triangle;

/**
 * Triangle, pentagonal, and hexagonal numbers are generated by the following formulae:
 * Triangle 	  	Tn=n(n+1)/2 	  	1, 3, 6, 10, 15, ...
 * Pentagonal 	  	Pn=n(3n−1)/2 	  	1, 5, 12, 22, 35, ...
 * Hexagonal 	  	Hn=n(2n−1) 	  	1, 6, 15, 28, 45, ...
 * <p/>
 * It can be verified that T285 = P165 = H143 = 40755.
 * <p/>
 * Find the next triangle number that is also pentagonal and hexagonal.
 */
public class Problem45 {

    public static void main(String[] args) {

        long n = 285;

        long triangle;
        long pentagonal;

        while (true) {
            n += 2;
            triangle = getTriangle(n);
            if (triangle != -1) {
                pentagonal = getPentagonal(triangle, n);
                if (pentagonal != -1) {
                    System.out.println("Match for " + n + " " + pentagonal + " " + getHexagonal(triangle, pentagonal) + " = " + triangle);
                    break;
                }
            }
        }
    }

    private static long getTriangle(long n) {
        return (n * (n + 1)) / 2;
    }

    private static long getPentagonal(long sum, long triangle) {
        for (long p = triangle; p > 0; p--) {
            if ((p * (3 * p - 1)) / 2 == sum) {
                return p;
            }
        }
        return -1;
    }

    private static long getHexagonal(long sum, long pentagonal) {
        for (long p = pentagonal; p > 0; p--) {
            if (p * (2 * p - 1) == sum) {
                return p;
            }
        }
        return -1;
    }
}
