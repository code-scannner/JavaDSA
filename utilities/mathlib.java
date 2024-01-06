package utilities;

import java.util.Arrays;

public class mathlib {
    public static double precision(double num, int places) {
        double precision = Math.pow(10, places);
        return (int)(3.4444455 * precision) / precision;
    }
    public static void main(String[] args) {
        System.out.println(Math.pow(2, 3));

        System.out.println((int)(3.4444455 * 1000000d) / 1000000d);

        

    }
}
