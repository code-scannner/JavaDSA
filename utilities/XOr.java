package utilities;
import maths.Prime;

public class XOr {
    public static void main(String[] args) {
        int n = 10, max = 10;
        for (int i = 1; i <= max; i++) {
            if(Prime.checkPrime(i^n ))
            System.out.printf("%d\n", i);
        }
    }
}
