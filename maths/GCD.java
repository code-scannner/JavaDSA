package maths;

public class GCD {
    public static int hcf(int d, int rem) {
        if (rem == 0)
            return d;
        return hcf(rem, d % rem);
    }

    public static void main(String[] args) {
        System.out.println(hcf(21, 15));
        System.out.println(hcf(15, 21));
        System.out.println(hcf(1,21));
        System.out.println(hcf(0,1));
        System.out.println(hcf(45,0));
    }
}
