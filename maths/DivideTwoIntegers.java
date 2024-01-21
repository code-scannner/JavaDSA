package maths;

public class DivideTwoIntegers {
    public static int divid(long dividend, long divisor) {
        if (dividend < divisor)
            return 0;
        int i = 0;
        while (dividend >= (divisor << i))
            i++;
        return (1 << (i - 1)) + divid(dividend - (divisor << (i - 1)), divisor);
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1)
                return Integer.MAX_VALUE;
            else if (divisor == 1)
                return Integer.MIN_VALUE;
        }

        long result = divid(Math.abs((long) dividend), Math.abs((long) divisor));
        if (dividend < 0 ^ divisor < 0) {
            return -(int) result;
        } else {
            return (int) result;
        }
    }

    public static void main(String[] args) {
        int dividend = 102;
        int divisor = 3;
        System.out.println(divide(dividend, divisor));
    }
}
