package maths;

public class Modulus {
    public static int modin(int x, int mod){
        return Power.pow(x, mod - 2,mod);
    }
    public static void main(String[] args) {
        System.out.println(modin(3,5));
    }
}