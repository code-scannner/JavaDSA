package utilities;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class mathlib {
    public static double precision(double num, int places) {
        double precision = Math.pow(10, places);
        return (int)(3.4444455 * precision) / precision;
    }
    public static void main(String[] args) {
        
        BigInteger bg = new BigInteger("1234567890123456789012345");
        bg = bg.modPow(new BigInteger("-1"), new BigInteger("4499"));
        System.out.println(bg.toString());

        // System.out.println(Math.log(6));

        // System.out.println(Math.pow(2, 3));

        // System.out.println((int)(3.4444455 * 1000000d) / 1000000d);
        // System.out.println(Math.round(5.5 - 0.000001) );

        // int num = -5, m = 5;
        // System.out.println((m + num%m)%m);

    }
}
